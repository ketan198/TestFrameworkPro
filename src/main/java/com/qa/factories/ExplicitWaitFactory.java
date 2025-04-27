package com.qa.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
		
	}
	
	
	public static WebElement performExplicitWait(WaitStrategy wait , By by) {
		
		WebElement element=null;
		
		if(wait==WaitStrategy.CLICKABLE){
			element = new WebDriverWait(DriverManagerUtility.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.elementToBeClickable(by));	
		}
		
		else if (wait==WaitStrategy.PRESENCE) {
			
			element = new WebDriverWait(DriverManagerUtility.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		
		else if (wait == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManagerUtility.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
			
		}
		
		else if (wait== WaitStrategy.NONE) {
			
			element = DriverManagerUtility.getDriver().findElement(by);
			
			
			
		}
		
		return element;
		
		

	}

}
