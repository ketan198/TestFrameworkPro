/**
 * 
 */
package RoughSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author tiwar
 *
 */


class pagefactoryex{

	


	@FindBy(xpath = "//a[contains(text(),'Fashion')]")
	WebElement fashion;


	WebDriver driver ;

	public pagefactoryex(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
public class FactoryPage {

	


	@Test
	public void test1() throws InterruptedException {


		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		   
		
		pagefactoryex pg = new pagefactoryex(driver);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(pg.fashion));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(pg.fashion));

		//Then do something 
		String str = pg.fashion.getText();

		System.out.println(str);

		pg.fashion.click();

		


	}

}
