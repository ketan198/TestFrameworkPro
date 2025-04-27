/**
 * 
 */
package com.qa.reportutil;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Ketan Tiwari
 *
 *Class and its methods are responsible to set , get and remove the ExtentTest objects when called upon respectively .
 */
public final class ExtentReportManager {
	
	private ExtentReportManager() {
	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	static ExtentTest getExtTest() { // Private package modifier , it cannot be called by outside 
		return extTest.get();
	}

	static void setExtTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}

}
