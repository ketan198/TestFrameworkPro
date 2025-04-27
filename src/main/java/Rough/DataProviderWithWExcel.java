package Rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithWExcel {


	@Test(dataProvider = "dp1")
	public void test1(Map<String, String> map) {
		System.out.println(map.get("username"));
//		System.out.println(password);
//		System.out.println(firstname);
//		System.out.println(lastname);
	}


	@DataProvider(name = "dp")
	public Object[][] getData() throws IOException {

		System.out.println(System.getProperty("user.dir"));
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs); 
		XSSFSheet sheet = workbook.getSheet("testing");

		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rownum][columnnum];
		for(int i = 1 ; i < rownum ; i++) {
			for(int j = 0 ; j <columnnum ; j++) {

				data[i-1][j] = sheet.getRow(i).getCell(j);

			}
		}
		workbook.close();
		return data;




	}

	@DataProvider(name = "dp1")
	public Object[] getData1() throws IOException {

		System.out.println(System.getProperty("user.dir"));
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs); 
		XSSFSheet sheet = workbook.getSheet("testing");

		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();

		Object[] data  = new Object[rownum];
		Map<String, String> map;


		for(int i = 1 ; i <=rownum ; i ++) {
			map = new HashMap<>();

			for(int j = 0 ; j <columnnum ; j++) {


				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key,value);
				data[i-1] = map;
			}
		}
		return data;




	}
}
