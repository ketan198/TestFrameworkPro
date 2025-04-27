/**
 * 
 */
package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ketan Tiwari
 *
 */
public class window_handle_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		WebElement ele = driver.findElement(By.xpath("//a[text() ='Gmail']"));
		
		
		ele.sendKeys(Keys.SHIFT, Keys.ENTER);
		
		
		// Open link in new window using JS executor 
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
