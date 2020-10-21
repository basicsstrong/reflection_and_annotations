package com.basicsstrong.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Repeatable(value = Designations.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface Designation {
	
	String value() default "Employee";

}
