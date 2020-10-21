package com.basicsstrong.reflection;

import java.lang.reflect.Constructor;

public class ConstructorInfo {

	public static void main(String[] args) throws Exception {
		
		Class<?> clss = Class.forName("com.basicsstrong.reflection.Entity");
//		Constructor<?>[] constructors = clss.getConstructors();
		Constructor<?>[] constructors = clss.getDeclaredConstructors();
		
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		 Constructor<?> publicConstructor = clss.getConstructor(int.class, String.class);
		 Entity e = (Entity)publicConstructor.newInstance(10, "StudenId");
		 System.out.println(e.getVal() +" "+e.getType());
		 
		 Constructor<?> privateConstructor = clss.getDeclaredConstructor();
		 privateConstructor.setAccessible(true);
		 Entity defaultE = (Entity)privateConstructor.newInstance();
		 
		 System.out.println(defaultE.getType()+" "+defaultE.getVal());

	}

}
