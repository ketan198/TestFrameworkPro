/**
 * 
 */
package Rough;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

/**
 * @author Ketan Tiwari
 *
 */
public class Selenium_test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver wd = new ChromeDriver();
		
		
		wd.get("https://www.google.co.in/");
		Thread.sleep(3000);
		
		String main_window = wd.getWindowHandle();
		
		// 1. Want to opena new window 
		
		
		wd.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com/");
		
		Thread.sleep(3000);
		wd.close();
		
		wd.switchTo().window(main_window);
		
		
		//1. open a link in new window and switch to it 
		
		
		WebElement link = wd.findElement(By.xpath("//a[text() = 'Gmail']"));
		
		link.sendKeys(Keys.SHIFT , Keys.ENTER);
		
		Thread.sleep(3000);
		
		
		wd.switchTo().window(main_window);
		
		// 2. Open a link in new tab 
		
		WebElement aboutlink = wd.findElement(By.xpath("//a[text() = 'About']"));
		
		
		aboutlink.sendKeys(Keys.CONTROL , Keys.RETURN);
		
		
		Thread.sleep(3000);
		
		
		Set<String> all_tab_main  = wd.getWindowHandles();
		ArrayList<String> tablist = new  ArrayList<String>(all_tab_main);
		
		
		wd.switchTo().window(tablist.get(2));
		
		Thread.sleep(3000);
		
//		wd.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
