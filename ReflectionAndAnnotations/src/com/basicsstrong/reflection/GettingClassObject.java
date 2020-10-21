package com.basicsstrong.reflection;

public class GettingClassObject {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//forName()
		
		Class<?> clss1 = Class.forName("java.lang.String");
		Class<?> clss2 = Class.forName("java.lang.String");
		
		System.out.println(clss1==clss2);
		
		
		//ClassName.class
		
		Class<?> clss3 = int.class; 
		Class<?> clss4 = String.class; 
		
		//obj.getClass()
		MyClass m = new MyClass();
		Class<? extends MyClass> class1 = m.getClass();
		
		//super class
		Class<?> superclass = class1.getSuperclass();
		
		//interfaces
		
		Class<?>[] interfaces = class1.getInterfaces();
		
		//getName()
		
		System.out.println(class1.getName());
		

	}

}
