package com.basicsstrong.reflection;

import java.lang.reflect.Field;

public class FieldInfo {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Entity e = new Entity(10,"id");
		Class<? extends Entity> clss = e.getClass();
		
		Field[] fields = clss.getFields();
		
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
		
		Field[] declaredFields = clss.getDeclaredFields();
		
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
		
		//non-declared : all the public elements in that class and in its super class
		//declared : all the elements present in that class only.
		
		Field field = clss.getField("type");
		Field field2 = clss.getDeclaredField("val");
		field2.setAccessible(true);
		field2.set(e, 19);
		field.set(e, "rollNo.");
		
		System.out.println(e.getType()+" "+e.getVal());
		
		

	}

}
