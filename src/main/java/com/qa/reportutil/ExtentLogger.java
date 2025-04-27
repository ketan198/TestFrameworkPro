/**
 * 
 */
package com.qa.reportutil;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.utilities.TestUtils;

/**
 * @author Ketan Tiwari
 *
 */
public final class ExtentLogger {

	public static void pass(String message, boolean isscreenshotneeded) {

		if(isscreenshotneeded == true) {
			ExtentReportManager.getExtTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.getbase64ScreenshotPath()).build());

		}
		else {
			ExtentReportManager.getExtTest().pass(message);
		}

	}


	public static void fail(String message, boolean isscreenshotneeded) {

		if(isscreenshotneeded == true) {
			ExtentReportManager.getExtTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.getbase64ScreenshotPath()).build());

		}
		else {
			ExtentReportManager.getExtTest().fail(message);
		}

	}

	
	public static void skip(String message, boolean isscreenshotneeded) {

		if(isscreenshotneeded == true) {
			ExtentReportManager.getExtTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.getbase64ScreenshotPath()).build());

		}
		else {
			ExtentReportManager.getExtTest().skip(message);
		}

	}
	
	public static void info(String message, boolean isscreenshotneeded) {

		if(isscreenshotneeded == true) {
			ExtentReportManager.getExtTest().info(message,MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.getbase64ScreenshotPath()).build());

		}
		else {
			ExtentReportManager.getExtTest().info(message);
		}

	}
}
