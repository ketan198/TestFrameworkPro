/**
 * 
 */
package com.qa.DriverUtilities;

import org.openqa.selenium.WebDriver;

/**
 * @author tiwar
 *
 */
public class DriverManager {
	
private static ThreadLocal<WebDriver> trDriver = new ThreadLocal<>(); // Driver is delared via thread loacal class to make it thread safe 

	

	public static void setDriver(WebDriver driver) { // This method sets the driver
		trDriver.set(driver);
	}

	public static WebDriver getDriver() { // this method gets the driver instance 
		return trDriver.get();
	}

	public static void unload() { // this method removes the driver 
		trDriver.remove();
	}
	

}
