/**
 * 
 */
package RoughSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tiwar
 *
 */
public class DataProviderTest {

	@Test(dataProvider = "getData")
	public void logintest(Map<String, String> map) throws IOException {
		
		
		System.out.println(map.get("username"));
		
//		System.out.println(excelreader("TESTDATA").toString());
		
		System.out.println(map);
		
	}
	
	@Test(dataProvider = "getData")
	public void newTest(Map<String, String> map) throws IOException {
		
		
		System.out.println(map.get("username"));
		System.out.println(map.get("execute"));
		
//		System.out.println(excelreader("TESTDATA").toString());
		
		System.out.println(map);
		
	}
	
	
	
	
	@DataProvider
	static Object[] getData(Method m) throws IOException {
		
		List<Map<String, String >> list_all = excelreader("TESTDATA");
		
		List<Map<String, String>> small_list = new ArrayList<Map<String,String>>();
		
		for(int i = 0 ; i<list_all.size() ; i++) {
			
			if(m.getName().equalsIgnoreCase(list_all.get(i).get("testname"))) {
				if(list_all.get(i).get("execute").equalsIgnoreCase("yes")) {
					small_list.add(list_all.get(i));
				}
			}
			
		}
		
		Object[] data = small_list.toArray();
		
		
		
		
		return data;	
		
		
		
	
	}
	
	
	
	
	static List<Map<String, String>> excelreader(String sheet) throws IOException {
		
		List<Map<String , String>> list = new ArrayList<Map<String,String>>() ;
		Map<String, String> map = null;
		
		FileInputStream fis = new FileInputStream("C:\\Workspace_2025\\DD\\Automation-Framework\\src\\test\\resources\\excel\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(sheet);
		
		
		int row = ws.getLastRowNum();
		int col = ws.getRow(0).getLastCellNum();
		
		System.out.println(row);
		System.out.println(col);
		
		for(int i =1 ; i <=row ; i++) {
			
			map = new HashMap<String, String>();
			
			for(int j = 0 ; j < col ; j++) {
				
				String key  = ws.getRow(0).getCell(j).getStringCellValue();
				String value = ws.getRow(i).getCell(j).getStringCellValue();
				
				map.put(key, value);
				
				
				
			}
			
			list.add(map);
			
			
		}
		
		wb.close();
		
		
		
		
		
		return list;
		
	}
	
	
	
	
}
