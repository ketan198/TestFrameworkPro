package com.qa.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.DriverUtilities.DriverManagerUtility;


/**
 * 
 * @author Ketan Tiwari
 *	
 * Exetend by every test class in the framework , cannot be instantiated. 
 *
 *
 */
public class TestBase {


	protected TestBase() {

	}


	static Logger log  = LogManager.getLogger(TestBase.class);

	protected static String browser;


 /**
  * 
  * @param data
  * @throws IOException
  * 
  * data is directly feeded from the Dp but  
	Can inject only one of <ITestContext, XmlTest, Method, Object[], ITestResult> into a @BeforeMethod annotated setUp.
	For more information on native dependency injection please refer to https://testng.org/doc/documentation-main.html#native-dependency-injection

	TestNG always passes the method parameters as an Object[]. 
	So during the first run:
	@BeforeMethod(Object[] data) → data = [ Map1 ]
  * 
  * so 	Map<String, String> map =  (Map<String, String>)data[0] ;  can be done safely 
  * Because data[0] is actually the Map that was passed to the test method.
  * 
  * TestNG wraps the method params in an array for you.
  */
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws IOException {
		
		Map<String, String> map =  (Map<String, String>)data[0] ;  
		//  Each element of Object[] is treated as a separate invocation of  @Test method.
		
		DriverManagerUtility.initializeDriver(map.get("browser"));

	}

	@AfterMethod
	protected void teardown( ) {
		
		DriverManagerUtility.quit_driver();
		
	}


}


