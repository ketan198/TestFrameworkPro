package com.qa.CustomAnnotations;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.qa.enums.TestCategoryType;

/**
 * 
 * @author tiwar
 *
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {
	
	public String[] author() default {}; 
	public TestCategoryType[] category() default TestCategoryType.NA;
	
	

}