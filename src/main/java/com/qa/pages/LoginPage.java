package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;

public final class LoginPage extends basepage{
	
	
	
	private final By username_input = By.xpath("//input[@id ='user-name']");
	private final By password_input = By.xpath("//input[@id ='password' and @type='password']");
	private final By login_btn = By.xpath("//input[ @type='submit']");
	
	
	
	public Homepage enterUsernameandpassword(String username , String password) {
		sendkeys(username_input, username , WaitStrategy.PRESENCE , "Username input field");
		sendkeys(password_input, password,WaitStrategy.PRESENCE , "Password input field ");
		click(login_btn,WaitStrategy.CLICKABLE,"Login Button");
		
		return new Homepage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
	
	

}
