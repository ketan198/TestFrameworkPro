package com.qa.DriverUtilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.enums.ConfigPropertiesEnums;
import com.qa.utilities.PropertiesUtil;

/**
 * @author Ketan Tiwari
	This Class is helpful for initializing , getting test mode etc 
 *
 */


public final class DriverManagerUtility {


	private DriverManagerUtility() {

	}

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
	public static WebDriver driver;


	/*
	 * this method initializes the driver takes a input string for browser , and
	 * utilises the driver object returned from the
	 * getbrowser_testmode method and gets the test site URL.
	 */

	/**
	 * 
	 * @param browser  take the browser from the class clasisg this method.
	 * @throws MalformedURLException
	 */
	public static void initializeDriver(String browser) { 

		if(Objects.isNull(getDriver())) {
			driver = getbrowser_testmode(browser);	

		}
		setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().get(PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.TESTSITEURL));


	}



	//method for quiting the driver and unloading Threadloacal instance

	public static void quit_driver() {
		if(Objects.nonNull(getDriver())) {
			getDriver().quit();
			unload();
		}
	}


	// this metgod return a webdriver object for the initialize driver method , by setting the test mode and the required browser names 

	/**
	 * 
	 * @param browser
	 * @return
	 * @throws MalformedURLException
	 * 
	 * 
	 * When you launch your Docker Selenium Grid (Hub + Nodes):

	The node (browser container) registers itself with hub.

	It mentions browserName, platform, version.

	✅ So when you send a RemoteWebDriver session,
	Selenium Hub matches your requested capabilities/options to available nodes.

	If you don't set anything, Grid might pick a default browser for you.
	 */

	public static WebDriver getbrowser_testmode(String browser)  {
		String testmode = PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.TESTMODE);
		DesiredCapabilities cap = new DesiredCapabilities(); //use ChromeOptions / Firefox options fo local
		driver = null ; 
		if(testmode.equalsIgnoreCase("remote")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");

				break;
			case "firefox":
				cap.setBrowserName("firefox");

				break;
			case "microsoftedge":
				cap.setBrowserName("MicrosoftEdge");

				break;

			default:
				throw new RuntimeException("Please specify a correct browser name ");
			}
			try {
				driver = new RemoteWebDriver(new URL(PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.REMOTEURL)),cap);
			} 
			catch (MalformedURLException e) {	
				
				throw new RuntimeException("Remote URL is not correct" , e);
			}
		}


		//asigning 

		if(testmode.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless");   use to set headless execution 
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "microsoftedge":
				driver = new EdgeDriver();
				break;

			default:
				throw new RuntimeException("Please specify the correct brwoser name");
			}

		}


		return driver;


	}




}
