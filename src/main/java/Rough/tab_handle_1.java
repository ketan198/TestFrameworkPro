/**
 * 
 */
package Rough;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ketan Tiwari
 *
 */
public class tab_handle_1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		Thread.sleep(3000);
		
		// want to open a new tab with specific URL 
		
//		driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com/");
		
		Thread.sleep(3000);
		
		Set<String> getwindows = driver.getWindowHandles();
		
		System.out.println(getwindows);
		
		
		//want to open a new tab with Java script
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open('https://www.youtube.com/')");
		
		
		

	}

}
