package com.qa.listners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.qa.constants.FrameworkConstants;
import com.qa.utilities.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {
   
	/*
	 * - This listner is regitered(injcted) in testng.xml  
	 * - When TestNG starts executing the suite,

		-It first registers the listener (MethodInterceptor),

		-Then before running tests, it calls your intercept() method, 
	 * 
	 * 
	 * here it gets the data of test to be ran from the RUNMANAGER sheet.
	 * testNG first collects methods of the class declared in testNG.xml
	 * 
	 * now the collected method are stored in List<ImethodInstances> methods .
	 * 
	 * now we will get the method from from the list ad comare it with the Excel if it matches and the execute colum is yes then the 
	 * operations happen and the methods gets aded to the returner list<iMethodInstance>
	 * 
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context)  {
		
		List<IMethodInstance> result = null; 
	try {
		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerSheet());
		result = new ArrayList<>();
		
		for(int i =0 ; i<methods.size(); i++) {
			for(int j =0 ; j<list.size() ; j ++) {
				
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))) {
					if(list.get(j).get("execute").equalsIgnoreCase("yes")) {
						
						methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						
						result.add(methods.get(i));
					}
				}
				
				
			}
		}
		
	
	
		
	} catch (Exception e) {
		
		throw new RuntimeException("Something went wrong while Method Interseption" , e);

	}
			
		
		return result;
	}
	
	
	

}
