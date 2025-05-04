/**
 * 
 */
package RoughSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author tiwar
 *
 */
public class Waits {

	@Test
	public void testWaits() {
		
		WebDriver driver = new ChromeDriver();
		WebElement we = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		
		
		
		
		
	}
	
	//1. Implicit waits 
	
	
	
	
}
