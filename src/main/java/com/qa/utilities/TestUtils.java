/**
 * 
 */
package com.qa.utilities;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;
import com.qa.reportutil.ExtentLogger;
import com.qa.reportutil.ReportManager;

/**
 * @author Ketan Tiwari
 *
 */
public class TestUtils  {
	

	
	
	public static void verifyLink(String url) {
		
		try {
		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();


		if (httpURLConnection.getResponseCode() == 200) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage());
		ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() , false);
		} else if(httpURLConnection.getResponseCode()== 301) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage() );
		ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() , false);
		}
		else {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			ExtentLogger.info(url+" - "+httpURLConnection.getResponseMessage() +"-"+"is a broken link"  , false);
		}
		} catch (Exception e) {
		System.out.println(url + " - " + "is a broken link");
		ExtentLogger.info(url+" - "+" is a broken link", false);

		}
		}
	
	public void get_all_links() {
		
		List<WebElement> links = DriverManagerUtility.getDriver().findElements(By.tagName("a"));
		
		
		for(WebElement link : links) {
			String url = link.getDomAttribute("href");
			if (url != null && !url.startsWith("http")) {
			    url = PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.TESTSITEURL) + url; // Convert relative URL to absolute
			}
			else if(url ==null) {
				
				ExtentLogger.info("URL IS NULL"+ link.getTagName(), false);
				
			}
			verifyLink(url);	
			
		}
		
		
		
	}
	
	
	public static String getbase64ScreenshotPath() {
		TakesScreenshot ts = (TakesScreenshot)(DriverManagerUtility.getDriver());
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		File destFile = new File(
				FrameworkConstants.getScreenshotsFolderPath() + "/" + ReportManager.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshot;
	}
	
	
	                
	

}
