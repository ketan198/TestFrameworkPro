package com.qa.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.qa.constants.FrameworkConstants;

public final class DataProviderClass {
	
	
	
	private DataProviderClass() {
		
	}
	
	/**
	 * Retuns a Object[] for map ,where each map repesents an invocation of the test method which injects this data provider.
	 * It feeds the test data one by one in the test method.
	 * 
	 * @param m
	 * @return
	 */
	
	@DataProvider(name= "dp" , parallel = true)
	public static Object[] getData(Method m) {
		
		
		
	  List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getTestdataSheet());
	  
	  List<Map<String, String>> smalllist = new ArrayList<>();
	  
	  for(int i = 0 ; i < list.size() ; i++) {
		  
		  if(m.getName().equalsIgnoreCase(list.get(i).get("testname"))) {
			  if(list.get(i).get("execute").equalsIgnoreCase("yes")) {
				  
				  smalllist.add(list.get(i));
				  
				  
			  }
			  
		  }
		  
	  }
	  
	  Object[] data = smalllist.toArray();
	  
		
		
		return data;
		
	}
	
	
	
	

}
