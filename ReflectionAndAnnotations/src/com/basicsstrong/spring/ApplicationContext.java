package com.basicsstrong.spring;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import com.basicsstrong.annotation.Autowired;
import com.basicsstrong.annotation.Component;
import com.basicsstrong.annotation.ComponentScan;
import com.basicsstrong.annotation.Configuration;

public class ApplicationContext {
	private static HashMap<Class<?>, Object> map = new HashMap<>();
	
	public ApplicationContext(Class<AppConfig> clss) {
		
		Spring.initializeSpringContext(clss);
	}

	
	private static class Spring{
		
		private static void initializeSpringContext(Class<?> clss) {
			
			if(!clss.isAnnotationPresent(Configuration.class)) {
				
				throw new RuntimeException("The file is not a Configuration file!");
				
			}else {
				ComponentScan annotation = clss.getAnnotation(ComponentScan.class);
				String value = annotation.value();
				
				String packageStructure = "bin/"+ value.replace(".", "/");
				
				 File[] files = findClasses(new File(packageStructure));
				 
				 
				 for (File file : files) {
					 String name = value + "." + file.getName().replace(".class", "");
					try {
						Class<?> loadingClass = Class.forName(name);
						
						if(loadingClass.isAnnotationPresent(Component.class)) {
							
							Constructor<?> constructor = loadingClass.getConstructor();
							
							Object newInstance = constructor.newInstance();
							
							map.put(loadingClass, newInstance);
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}  
				}
			}
			
		}

		private static File[] findClasses(File file) {
			
			if(!file.exists()) {
				throw new RuntimeException("Package "+  file + " does not exist.");
			}else {
				File[] listFiles = file.listFiles(e -> e.getName().endsWith(".class"));
				return listFiles;
			}
		}
		
	}


	public <T> T getBean(Class<T> clss) {
		
		T object = (T)map.get(clss);
		
		Field[] declaredFields = clss.getDeclaredFields();
		
		injectBean(object, declaredFields);
		return object;
	}


	private <T> void injectBean(T object, Field[] declaredFields) {
		for (Field field : declaredFields) {
			if(field.isAnnotationPresent(Autowired.class)) {
				field.setAccessible(true);
				Class<?> type = field.getType();
				Object innerObject = map.get(type);
				try {
					field.set(object, innerObject);
					Field[] declaredFields2 = type.getDeclaredFields();
					
					injectBean(innerObject, declaredFields2);
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

}
