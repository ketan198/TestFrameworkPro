/**
 * 
 */
package com.qa.reportutil;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;
import com.qa.enums.TestCategoryType;
import com.qa.utilities.PropertiesUtil;

/**
 * @author Ketan Tiwari
 * 
 * This Class is responsible for 
 * 
 *
 */
public final class ExtentReport {
	
	
	private ExtentReport() {
	}

	
	
	private static ExtentReports extent ; 
	private static ExtentTest test ; 
	
	/**
	 * Responsible for initializing ExtentReports 
	 * ExtentSparkReporter is used with JSon configs for better reporting 
	 * 
	 * 
	 */
	public static void extentinitializer() {
		
		try
		{
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
		}
		if (PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.ALLTESTS).equalsIgnoreCase("yes")) {
			
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getAlltestreportpath());
			spark.loadJSONConfig(new File(FrameworkConstants.getJsonConfigAlltestsFilePath()));
			spark.viewConfigurer().viewOrder()
			.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			
			extent.attachReporter(spark);
		}
		
		if (PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
			
			ExtentSparkReporter spark_onlyfailed = new ExtentSparkReporter(FrameworkConstants.getFailedreportpath());
			spark_onlyfailed.loadJSONConfig(new File(FrameworkConstants.getJsonConfigOnlyfailedFilePath()));
			spark_onlyfailed.viewConfigurer().viewOrder()
			.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			
			extent.attachReporter(spark_onlyfailed);
		}
		}catch(IOException e) {
			throw new RuntimeException("Issue with the spark reporter configs or read/ write operations") ;		}
		
			
	}
	
	
	/**
	 * Flush the report and unloads the Thread local. and opens the report
	 */
	public static void reportflush() {
		
		if(Objects.nonNull(extent)) {
			extent.flush();
			ExtentReportManager.unload();
			
		}
//		try {
//			Desktop.getDesktop().browse(new File(FrameworkConstants.getAlltestreportpath()).toURI());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//			
//		}
	}
	/**
	 * Creates ExtentTest and set the test in ExtentReportMananger which uses ThreadLocal Class for thread safety.
	 * @param testcasename 
	 * 
	 */
	public static void createtest(String testcasename) {
		
		test = extent.createTest(testcasename);
		ExtentReportManager.setExtTest(test);
	}
	
	/**
	 * Add Autors to the test 
	 * @param Authors
	 */
	public static void addAuthors(String[] Authors) {
		
		for(String temp : Authors) {
			ExtentReportManager.getExtTest().assignAuthor(temp);
		}
		
	}
	/**
	 * add categories to the test from its annotations
	 * @param categories
	 */
	public static void addCategories(TestCategoryType[] categories) {
		for(TestCategoryType temp : categories) {
			ExtentReportManager.getExtTest().assignCategory(temp.toString());
		}
		
	}
}
