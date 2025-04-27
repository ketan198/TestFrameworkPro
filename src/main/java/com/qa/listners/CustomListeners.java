package com.qa.listners;

import java.io.IOException;
import java.util.Objects;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.qa.CustomAnnotations.FrameworkAnnotations;
import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.reportutil.ExtentLogger;
import com.qa.reportutil.ExtentReport;



/**
 * @author Ketan Tiwari
 *
 */
public class CustomListeners implements ITestListener,ISuiteListener {

	/**
	 * It initializes the Extentreport on suite start. 
	 */
	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.extentinitializer();
		

	}

	/**
	 * Flushes the report on suite end.
	 */
	
	
	@Override
	public void onFinish(ISuite suite) {
		
			ExtentReport.reportflush();
		
	}

	/**
	 * overridden method from ItestListner --> responsible for creating test.
	 * ITestResult result - > is an object which holds all the info about the test gettig ran.
	 */
	
	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createtest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class)
		.author());
		
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class)
				.category());
	
	}

	/**
	 * Logs with a message
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + "Passed Sucessfully", false);
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		if (Objects.nonNull(DriverManagerUtility.getDriver())) {
			ExtentLogger.fail(result.getMethod().getMethodName() + "failed.", true);
			ExtentLogger.fail(result.getThrowable().toString(), true);
		}
		/*
		 * "If the WebDriver was null (for some reason like setup failure),
			instead of failing, mark the test as skipped in the Extent report."
		 */
		else {
			ExtentLogger.skip(result.getMethod().getMethodName(), false); 
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+"is Skipped", false);

	}





}
