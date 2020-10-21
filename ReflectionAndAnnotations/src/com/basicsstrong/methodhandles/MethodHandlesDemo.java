package com.basicsstrong.methodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

public class MethodHandlesDemo {

	public static void main(String[] args) throws Throwable {
		
		Lookup lookup = MethodHandles.lookup();
		Class<?> clss = lookup.findClass(Student.class.getName());
		
		MethodType methodType = MethodType.methodType(String.class);
		
		Student s = new Student();
		s.setCourse("Java");
		
		MethodHandle getCourseHandle = lookup.findVirtual(clss, "getCourse", methodType);
		
		System.out.println(getCourseHandle.invoke(s));
		
		
		
		MethodType type = MethodType.methodType(void.class);
		MethodHandle noArgHandle = lookup.findConstructor(clss, type);
		 Student s1 = (Student)noArgHandle.invoke();
		 s1.setName("Meenal");
		 s1.setCourse("Scala");
		 System.out.println(s1.toString());
		 
		 
		 MethodType type1 = MethodType.methodType(void.class,String.class,String.class);
		 MethodHandle paraCons = lookup.findConstructor(clss, type1);
		 Student divya = (Student)paraCons.invoke("Divya", "Python");
		 System.out.println(divya.toString());
		 
		 MethodType methodType2 = MethodType.methodType(void.class, String.class);
		 MethodHandle setNameHandle = lookup.findVirtual(clss, "setName", methodType2);
		 setNameHandle.invoke(s1, "Mohit");
		 System.out.println(s1.getName());
		 
		 MethodType methodType3 = MethodType.methodType(void.class, int.class);
		 MethodHandle setNumOfStudentsHandle = lookup.findStatic(clss, "setNumOfStudents", methodType3);
		 setNumOfStudentsHandle.invoke(2);
		 System.out.println(s1.getNumOfStudents());
		 
		 Lookup privateLookupIn = MethodHandles.privateLookupIn(clss, lookup);
		 
		 MethodHandle findGetter = privateLookupIn.findGetter(clss, "name", String.class);
		 MethodHandle findSetter = privateLookupIn.findSetter(clss, "name", String.class);
		 //findGetter.invoke(s1);
		 findSetter.invoke(s1, "Justin");
		 System.out.println(s1.getName());
		 
		 //VarHandles
		 
		 VarHandle courseVarHandle = privateLookupIn.findVarHandle(clss, "course", String.class);
		 courseVarHandle.set(s1, "Kotlin");
		 String val = (String)courseVarHandle.get(s1);
		 System.out.println(val);
		 
		 

	}

}
