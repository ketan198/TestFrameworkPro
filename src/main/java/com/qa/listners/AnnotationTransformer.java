/**
 * 
 */
package com.qa.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qa.utilities.DataProviderClass;

/**
 * @author tiwar
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer{
	
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderClass.class);
		annotation.setRetryAnalyzer(RetryFailedTest.class);
		
	}
}
