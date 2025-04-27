package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.Exceptions.InvalidExcelPathException;
import com.qa.constants.FrameworkConstants;

public final class ExcelUtils {
	
	/**
	 * 
	 * This Method returns a List of map where the value from excel are stored in Key , value pairs.
	 * 
	 * 
	 * @param Sheet
	 * @return
	 */
	
	public static List<Map<String, String>> getTestDetails(String Sheet) {
		
		List<Map<String, String>> list =null;
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(FrameworkConstants.getTestdatasheetPath());
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(Sheet);
		
		
		
		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();
		
		list = new ArrayList<>();
		
		Map<String, String> map = null ; 
		for(int i =1 ; i <=rownum ; i ++) {
			map = new HashMap<>();
			for(int j = 0 ; j < columnnum ; j++ ) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				
				}
			list.add(map);
			
		}
		if(Objects.nonNull(fis))
		{
		workbook.close();
		}
		
		
	
	} catch (FileNotFoundException e) {
		throw new InvalidExcelPathException("Excel file path is incorrect" , e);
	} catch (IOException e) {
		throw new InvalidExcelPathException("Something went wrong in Loading workbok " , e);
	} 
		
		return list;
		
}	

}
