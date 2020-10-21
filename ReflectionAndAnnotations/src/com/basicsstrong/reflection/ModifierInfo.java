package com.basicsstrong.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierInfo {

	public static void main(String[] args) throws Exception {
		
		Entity e = new Entity(10,"id");
		Class<? extends Entity> clss = e.getClass();
		int modifiersInt = clss.getModifiers();
		//int i = modifiersInt & Modifier.PUBLIC;
		//boolean isPublicClass = Modifier.isPublic(modifiersInt);
		
		System.out.println(Modifier.toString(modifiersInt));
		
		 Method method= clss.getMethod("getVal");
		 int methodModifiers = method.getModifiers();
		 
		 //boolean ispubMethod =Modifier.isPublic(methodModifiers);
		 
		 System.out.println(Modifier.toString(methodModifiers));
		
	}

}
