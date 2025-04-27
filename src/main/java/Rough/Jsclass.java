package Rough;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author tiwar
 *
 */
public class Jsclass  {
	
	
	@Test
	public void someTest() throws MalformedURLException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we = driver.findElement(By.xpath("//a[contains(text() , ' Electronics ')]"));
		js.executeScript("arguments[0].click();", we );
		
		
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500);");
		Thread.sleep(1000);
		WebElement we1 = driver.findElement(By.xpath("//b[text() = 'Shop by category']"));
		
		String s =  (String) js.executeScript("return arguments[0].textContent;", we1);
		
		System.out.println(s);
		String mainwindowHandle = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.in/");
		
		Thread.sleep(1000);
		driver.switchTo().window(mainwindowHandle);
		Thread.sleep(1000);
		
		
		 WebElement ele =  driver.findElement(By.xpath("//a[text() = 'Fashion']"));
//		 ele.sendKeys(Keys.CONTROL,Keys.ENTER);
		 String yrl = "https://www.amazon.in" +ele.getDomAttribute("href");
		 System.out.println(yrl);
 		
		 
		
		 
		 js.executeScript("window.open(arguments[0],'_blank','widht=800 , height =600');",yrl);
		
		 Thread.sleep(3000);
		 
		
		Set<String> windows = driver.getWindowHandles();
		
		
		
		for(String s1 : windows) {
			if(!s1.equalsIgnoreCase(mainwindowHandle)) {
				
				driver.switchTo().window(s1);
			}
		}
		
		
		//open a link in new tab 
		
		 driver.close();
		 
		 
		 
		 driver.switchTo().window(mainwindowHandle);
		 
		 Thread.sleep(2000);

		 //Open a link in new tab by actions 
		 
		 
		 
		 Actions ac = new Actions(driver);
		 
		 ac.keyDown(Keys.CONTROL)
		 	.click(driver.findElement(By.xpath("//a[text() = 'Books']")))
		 	.keyUp(Keys.CONTROL)
		 	.perform();
		 	
		 
		 Thread.sleep(3000);
		 
		 
		 driver.quit();	
		
		 
		
		
		
		
		
		
	}
	

}
