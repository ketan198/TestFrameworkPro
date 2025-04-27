package com.qa.pages;



import org.openqa.selenium.By;
import com.qa.enums.WaitStrategy;

public final class Homepage extends basepage{


	private final By menu_btn = By.xpath("//button[@id= 'react-burger-menu-btn']");
	private final By logout_btn = By.xpath("//a[contains(text(),'Logout')]");


	public Homepage click_menu() {
		click(menu_btn,WaitStrategy.CLICKABLE , "Menu button");
		return this;
	}


	public LoginPage logout() {

		click(logout_btn,WaitStrategy.CLICKABLE , "Logout button");

		return new LoginPage();
	}
}
