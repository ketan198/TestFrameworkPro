
package RoughSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author tiwar
 *
 */
public class Webtables {


	@Test(enabled = false)
	public void webtableManipulation() throws InterruptedException {


		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://letcode.in/test");

		//		driver.manage().window().maximize();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;



		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text() = ' Advance table ']")));

		Thread.sleep(2000);

		// to find number of rows in the table

		List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));


		System.out.println(rows.size());


		// to find the number of columns 

		List<WebElement> col = driver.findElements(By.xpath("//colgroup//col"));

		System.out.println(col.size());


		//		for(int i = 1 ; i <rows.size()+1 ; i++) {
		//	
		//			
		//			for(int j =1 ; j< col.size()+1 ; j++) {
		//				
		//				
		//				String data = driver.findElement(By.xpath("//tbody//tr["+i+"]//td["+j+"]")).toString();
		//				
		//				System.out.println(data);
		//				
		//			}
		//			
		//			
		//			
		//		}


		for(WebElement we : rows) {

			List<WebElement> cells = we.findElements(By.tagName("td"));
			int count = 0 ;
			for(WebElement cell : cells) {

				System.out.print(cell.getText());
				if(count != cells.size()-1) {
					System.out.print("|");

				}
				count++;



			}
			System.out.println("");

		}







		driver.quit();



	}


	@Test(enabled = false)
	public void test2() throws InterruptedException {


		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://letcode.in/table");


		List<WebElement> rows = driver.findElements(By.xpath("//table[@id ='shopping']//tbody/tr"));

		int result = 0;

		for(WebElement row: rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));
			//		
			String res = cells.get(1).getText();
			result += Integer.parseInt(res);
			//				


		}
		System.out.println(result);

		Assert.assertEquals(858, result);


		// click only raj  radio button


//		String[] name  = {"Iron", "Raj"};
//
//		for(String name1: name ) {
//			WebElement we2 = driver.findElement(By.xpath("//table[@id='simpletable']//tr[td[text()= '"+name1+"']]//td//input"));
//			we2.click();
//			Thread.sleep(2000);
//		}




		//Calorie 


		Map<String, String> calorie = new HashMap<String, String>();
		
		
		List<WebElement> table_rows = driver.findElements(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']//tbody//tr"));
		
		for(WebElement row : table_rows) {
			
			List<WebElement> td = row.findElements(By.tagName("td"));
			
			
				
				calorie.put(td.get(0).getText(), td.get(1).getText());
				
			
			
			
		}
		
		System.out.println(calorie);
		
		







	}
	
	@Test(enabled = false)
	public void WebTabletest() throws InterruptedException, IOException   {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		Thread.sleep(2000);
		
		 List<WebElement> list_row =  driver.findElements(By.xpath("//table[@id = 'table1']//tbody//tr"));
//		 List<WebElement> list_col = driver.findElements(By.xpath("//table[@id = 'table1']//tbody//tr[1]//td"));
		 List<WebElement> header = driver.findElements(By.xpath("//table[@id = 'table1']//thead//tr//th"));
		 int rows = list_row.size();	
		 int col = header.size();
		 
		 System.out.println("Number od rows in the column excluding header : "+ list_row.size());
		
		 
		 List<Map<String, String>> MapList = new ArrayList<Map<String,String>>();
		 
		 Map<String, String> map = null;
		 
		 
		 for(int i = 0 ; i < rows ; i++) {
			 
			 map = new HashMap<String, String>();
			 
			 
			 List<WebElement> cells = list_row.get(i).findElements(By.tagName("td"));
			 
			 for(int j = 0 ; j < col-1 ; j++) {
				 
				 String key = header.get(j).getText();
				 String value = cells.get(j).getText();
				 map.put(key, value);
				 
				 
			 }
			 
			 
			 MapList.add(map);
			 
		 }
		 
		 System.out.println(MapList);
		 
		 
		 for(int i = 0 ; i < rows ; i++) {
		 System.out.println(MapList.get(i).get("First Name"));
		 
		 
		 }
		 
		 
		 
		 
		 //write all the the values in the excel;
		 
		 
		 
		 Workbook book = new XSSFWorkbook();
		 
		 
		 
		 Sheet sheet = book.createSheet("WebTableData");
		 
		 
		 int row_count = 0 ; 
		 
		 Row headerrow = sheet.createRow(row_count++);
		 int headerCellCount = 0 ;
		
		 for(String key : MapList.get(0).keySet()){
			 
			 Cell cell = headerrow.createCell(headerCellCount++);
			 cell.setCellValue(key);
			 
		 }
		 
		 for(Map<String, String> map1 : MapList) {
			 
			 Row dataRow = sheet.createRow(row_count++);
			 int dataCellCount = 0 ;
			 
			 for(String value : map1.values()) {
				 
				 Cell cell = dataRow.createCell(dataCellCount++);
				 cell.setCellValue(value);
				 
				 
			 }
			 
		 }
		 
		 FileOutputStream fos = new FileOutputStream("Webtable.xlsx");
		 book.write(fos);
		 
		 fos.close();
		 book.close();
		 
		 
		 
		 
		 
		 
		 
		driver.quit();	
		
		
		
		
		
		
		
	}
	
	
	
	@Test(enabled = true)
	public void secondDataTable() throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/table");
		Thread.sleep(2000);
		
		List<WebElement> list_headers = driver.findElements(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']//thead//tr//th"));
	
		List<WebElement> list_rows =  driver.findElements(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']//tbody//tr"));
		
		int row = list_rows.size();
		int columns = list_headers.size();
		
		
		List<Map<String, String>> list_map = new ArrayList<Map<String,String>>();
		
		Map<String, String> map = null; 
		
		
		for(int i =0 ; i < row ; i++) {
			
			map = new HashMap<String, String>();
			
			List<WebElement> cells  = list_rows.get(i).findElements(By.tagName("td"));
			
			for(int j = 0 ; j < columns ; j ++) {
				
				
				String key = list_headers.get(j).getText();
				String value = cells.get(j).getText();
				map.put(key, value);
				
				
			}
			
			list_map.add(map);
			
			
		}
		
		
		System.out.println(list_map);
		
		
		//handling if workbook already exists 
		
		Workbook wb = null ; 
		File file = new File("C:\\Workspace_2025\\DD\\Automation-Framework\\Webtable.xlsx");
		
		
		
		if(file.exists()) {
			
			FileInputStream fis =new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
			System.out.println("File exists adding new Sheet ... ");
			
			
		}
		else {
			
			wb = new XSSFWorkbook();
			System.out.println("Workbook does not exists creating a new one ");
		}
		
		
		Sheet sheet = wb.createSheet("TESTDATA2");
		int row_count = 0 ;
		int headderCellcount = 0 ; 
		
		Row header_row = sheet.createRow(row_count++); //creating header row only once.
		
		for(String key : list_map.get(0).keySet()) {
			
			Cell cell = header_row.createCell(headderCellcount++);
			cell.setCellValue(key);
			
		
			
			
			
			
		}
		
		
		for(Map<String, String> m : list_map) {
			
			
			Row datarow = sheet.createRow(row_count++);
			int data_cellcount = 0 ; 
			
			for(String value : m.values()) {
				
				Cell cell = datarow.createCell(data_cellcount++);
				cell.setCellValue(value);
				
				
			}
			
			
			
		}
		
		 FileOutputStream fos = new FileOutputStream("Webtable.xlsx");
		 wb.write(fos);
		 
		 fos.close();
		 wb.close();
		
		
		
		
		driver.quit();
	}
	
	
	


}
