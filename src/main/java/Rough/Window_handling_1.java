/**
 * 
 */
package Rough;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

/**
 * @author Ketan Tiwari
 *
 */


public class Window_handling_1 {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		// 1.want to open a new window with a specific URL 

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		String main_window = driver.getWindowHandle();
		System.out.println(main_window);
		Thread.sleep(3000);
		
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com/");
		
		Set<String> getwindowhandle = driver.getWindowHandles();
		
		System.out.println(getwindowhandle);
		
		
			
		
		// 2.Implement this using Js executor.
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open('https://www.youtube.com/', '_blank','width=800,height=600');"); // if we do not provide the with and height the 
		// browser decides itself what to open a tab or window , generally it is tab.
				
		Set<String> getwindowhandle2 = driver.getWindowHandles();
		for(String window : getwindowhandle2 ) {
			if(!window.equals(main_window)) {
				driver.switchTo().window(window);
				break;
			}}
			
		String new_window_now = driver.getWindowHandle();
		System.out.println(new_window_now);
		
		System.out.println(driver.getTitle());
			
		
		
		
		
		
		
		
		
		}
		
		
		}
		
		
		
		
		

