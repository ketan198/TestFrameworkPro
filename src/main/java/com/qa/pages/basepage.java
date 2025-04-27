package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;
import com.qa.reportutil.ExtentLogger;

public class basepage {



	protected void click(By by , WaitStrategy waitstrategy ,String elementname) {
		
		WebElement e =  ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		e.click();
		ExtentLogger.pass(elementname + "is clicked" , true);
		
		

	}

	protected void sendkeys(By by , String value,WaitStrategy waitstrategy,String elementname) {
		WebElement e = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		e.sendKeys(value);
		ExtentLogger.pass(value + " is entered in " + elementname , false);
		
	}


	protected String getPageTitle() {

		return DriverManagerUtility.getDriver().getTitle();


	}
	
	
}
