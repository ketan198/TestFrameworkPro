package com.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.CustomAnnotations.FrameworkAnnotations;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.TestCategoryType;
import com.qa.pages.LoginPage;
import com.qa.utilities.DataProviderClass;

public class LoginTest extends TestBase {
	
	/**
	 * The logintest method accepts a map<string, string> coming from 
	 * dataprovider , TestNg here sees that the dp return an 1-D object array , so each element of the Object[]
	 * is treated as a seperate invovation of the test method. that is why whole object[] array is not fed at once bt the elements 
	 * provide an invocation seperately for the same test method 
	 * 
	 * even if the parallel is kept true for dp 
	 * BTS :
	 * 
	 * call logintest(map1) -> in thread 1 
	 * call logintest(map2) -> in thread 2 
	 * call logintest(map3) -> in thread 3 
	 * 
	 * {@link newTest }
	 * 
	 * @param map
	 * 
	 * map is accepted here as parameter here from the dp (which returns a 1-D objcet array ) because testNg takes one element 
	 * from that array for each test method run 
	 * 
	 * if the param is chaged to Object[] data and we try to cast it to map (data[0]) it does not work , because dp does 
	 * not retunn data = [map] but it returns data[0] =Map
	 */

	@FrameworkAnnotations(author = {"Ketan"}, category = {TestCategoryType.REGRESSION, TestCategoryType.SMOKE})
	@Test(dataProvider = "dp" , dataProviderClass = DataProviderClass.class)
	public void logintest(Map<String, String> map) {
		
		
		
		
		String title = new LoginPage().
				enterUsernameandpassword(map.get("username"),map.get("password") )
				.click_menu().logout()
				.getTitle();
			
		Assert.assertEquals(title, "Swag Labs");
		
	
		
	
	
	}
	
	@FrameworkAnnotations(author = {"Ketan"}, category = {TestCategoryType.REGRESSION, TestCategoryType.SMOKE})
	@Test(dataProvider = "dp", dataProviderClass = DataProviderClass.class)
	public void newTest(Map<String, String> map) {
		
		
		
		String title = new LoginPage().
				enterUsernameandpassword(map.get("username"),map.get("password") )
				.click_menu().logout()
				.getTitle();
			
		Assert.assertEquals(title, "Swag Labs");
		
	
	
	
	
	}
	
	
	@Test(dataProvider = "dp", dataProviderClass = DataProviderClass.class)
	public void newTest2(Map<String, String> map) {
		
		
		
		String title = new LoginPage().
				enterUsernameandpassword(map.get("username"),map.get("password") )
				.click_menu().logout()
				.getTitle();
			
		Assert.assertEquals(title, "Swag Labs");
		
	
	
	
	
	}
	
	
//	@Test()
//	public void logintest() {
//		
//		
//		
//		String title = new LoginPage().
//				enterUsernameandpassword("standard_user","secret_sauce")
//				.click_menu().logout()
//				.getTitle();
//			
//		Assert.assertEquals(title, "Swag Labs");
//		
//	
//	
//	
//	
//	}
//	
//	@Test
//	public void newTest() {
//		
//		
//		
//		String title = new LoginPage().
//				enterUsernameandpassword("standard_user","secret_sauce")
//				.click_menu().logout()
//				.getTitle();
//			
//		Assert.assertEquals(title, "Swag Labs");
//		
//	
//	
//	
//	
//	}
	
	@DataProvider(name = "loginTestdata", parallel =  true)
	public Object[] getData() throws IOException{
		
		
		FileInputStream fis = new FileInputStream(FrameworkConstants.getTestdatasheetPath());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("TESTDATA");
		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();
		
		Object[] data = new Object[rownum];
		Map<String , String > map ;
		
		for(int i = 1 ; i <=rownum ; i++) {
			map = new HashedMap<>();
		for(int j = 0 ; j< columnnum ; j++) {
			String key = sheet.getRow(0).getCell(j).toString();
			String value = sheet.getRow(i).getCell(j).toString();
			map.put(key, value);
			
			data[i-1] = map;
			
			
		}
		}
		
		workbook.close();
		
		return data;
		
	}
	

}