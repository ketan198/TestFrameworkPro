

Driver management 

--2 classes are created for threadloacal implementation and Driver utility for initilizing correct browser 
-- ThreadLocal class is used to create thread local variable for WebDriver instance, 
	which ensures that each thread has its own instance of WebDriver. This is particularly
	useful in parallel test execution, where multiple threads may be running tests simultaneously.
	By using ThreadLocal, we can avoid conflicts and ensure that each thread interacts with its own WebDriver 
	instance without interference from other threads.
	
-- Driver invocation : From Selenium 4.6 it is not required to have driver.exe files and 
	the Selenium itself automatically:
	downloads browser drivers,
	resolves versions,
	configures paths.
	
--- DriverUtility class : 
	1. This class is responsible for initializing the WebDriver based on the specified browser type.
	2. There is a getDriver() method that checks the value of the "browser" variable and initializes the appropriate WebDriver instance accordingly.
	3. The modes specified in config.properies file are local and remote
	4. IF THE MODE is local the driver will be initialized on the local machine and if the mode is remote the driver will be initialized on the remote machine using Selenium Grid.
	5. Method GetDriver() is usiing chromeOptions and prefrences to handle the website popups like allow location and block brower notification such as Password save , leak respectively.
	6.initializeDriver() method is responsible for seeting up th webdriver from thread local into seperate threads
	
	
--- DriverManger Class (Conflicting name with a dependency might correct later) 
    1. This class is responsible for managing the WebDriver instances using ThreadLocal.
    2. It provides methods to set and get the WebDriver instance for the current thread.
    3. The setDriver() method is used to set the WebDriver instance for the current thread, while the getDriver() method retrieves the WebDriver instance for the current thread.
    4. The quitDriver() method is responsible for quitting the WebDriver instance and removing it from the ThreadLocal storage, ensuring that resources are properly released after test execution.
    
*****************************************************************************************************************************************************************************************************    

Framework Constants Class :-

 -- This class is responsible for defining  CONSTANTS that are used throughout the framework. 
 -- All the constants are defiled as private static final , so that they cannout be accesed or changed outside the class and also they are final so that they cannot be modified after initialization.
 -- Getter are used to acces the constants from otehr classes in the framweork so that they can be used consistently across and to maintain encapsulation.
 
 
 ****************************************************************************************************************************************************************************************************
 
 ENUMS 
 
 -- Enums are used to ensure type safety , to avoid hardcoded strings 	, it acts like a fix list of allowed properties.
 --  It ensure centralized config key management 
 -- Example usage : String testmode = PropertiesUtil.getPropertyValue(ConfigPropertiesEnums.TESTMODE);
 
 
 
 ****************************************************************************************************************************************************************************************************
 
Custom Execption 
 -- Implemented a centralized custom exception handling mechanism to improve framework reliability and debugging.
 --Added specialized exceptions for different failure scenarios such as:
	1.Invalid Excel file path
	2.Invalid property file path
	3.Incorrect property key usage	
 --Used custom exceptions instead of generic exceptions to provide meaningful and readable error messages.

 
 ****************************************************************************************************************************************************************************************************
 
Explicit Wait Factory : 
 
 --Explicit Wait factory serves the purpose of custom waiting strategies for some expected wait strategies such as , CLICKABLE , PRESENCE etc. 
 -- It provides a method which takes two args , first waitstrategy enum and secon is BY (webelemenent) and this method returns a Webelement.
 
 
 ****************************************************************************************************************************************************************************************************
 
FrameworkAnnotation : 
 
 -- this is a Java Annotations class , in which I have defined two annotation methods with default values
 -- @Retention is set to RUNTIME , to use these at runtime . 
 -- @target is set to Methos so this Annotations are only aplicable in Methods. 
 Note : To attach these Annotation into test methods i am making use of customListner -- > which takes extent reports methods to attach these annotation on to the reports at Runtime. 
 
****************************************************************************************************************************************************************************************************

Listners : 

-- Custom Listiner class -- > this calss implements 2 uinterfaces ISuiteListner , Itestlistner
-- > 
Merthods like onStart() , OnFininsh() are implemnetd in this class , which comes from ISuiteListner. 
Methods like onTestStart() , onTestSucess() etc . are implemented in this class which comes form ITestListner. 


 ****************************************************************************************************************************************************************************************************
 
 Report Utility:  
 -- ExtentReportMananger : Used Threadlocal for storing ExtentTest , so that for each thread reports are unique and schynchronized. 
 -- ExtentReport : 1. which is used to Initiliaze the report extentinitilizer() , create report using createTest() , this method creates ExtentTest Class refrence variable , assigns extent{ExtentReport}.cereateTest("String ")
     to it and then sets that to remoremanager's setTEst method.
     2. AddAuthor() Method  is used to Assigne Authors to the Extent Test 
 
     3. addCategories method is used to Assign test categories to Esxtent test. 
     
-- ExtentLogger class : -  this has varios methos like Pass, fail , Skip , which is utilised during test execution flow s to updte reports. 
--ReportManager : THis class is used to update Report folder name.  As per the datet time Stamp. 
 
 ****************************************************************************************************************************************************************************************************
 
 
 
 
 
 
 
 
 
 
 
 
 