/**
 * 
 */
package RoughSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author tiwar
 *
 */
public class AlertsClass {
	
	By element = By.xpath("//button[@class='btn btn-danger']");
	

	
	@Test
	public void test1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();

		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.quit();
					
		
		
		
		
		
		
		
		
		
	}
}
