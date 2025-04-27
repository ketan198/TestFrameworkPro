/**
 * 
 */
package Rough;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Ketan Tiwari
 *
 */
public class tab_handle_2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");  //https://www.google.co.in/
		
		Thread.sleep(3000);
		
		String main_tab = driver.getWindowHandle();
		
//		WebElement elev = driver.findElement(By.xpath("//a[text()= 'About']"));
		
//		elev.sendKeys(Keys.CONTROL, Keys.RETURN);
		
		Thread.sleep(3000);
		
//		Set<String> tabs = driver.getWindowHandles();
//		
//		for(String tab : tabs ) {
//			if(!tab.equals(main_tab)) {
//				driver.switchTo().window(tab);
//				break;
//			}
//			
//			
//		}
		
		WebElement home_ele = driver.findElement(By.xpath("//span[text()= 'Home & Furniture']/../.."));
		
//		driver.manage().window().maximize();
		Thread.sleep(3000);
		
//		WebElement fee =  driver.findElement(By.cssSelector("body"));
//		fee.sendKeys(Keys.CONTROL, Keys.RETURN);
//		
//		Actions ac = new Actions(driver);
//		ac.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Hello, JavaScript in Selenium!');");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		js.executeScript("var event = new MouseEvent('mouseover',{bubbles:true}); "
				+ "arguments[0].dispatchEvent(event);",home_ele);
		Thread.sleep(35000);
		
		
		
		

	}

}
