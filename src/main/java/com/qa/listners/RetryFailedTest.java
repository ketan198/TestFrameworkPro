/**
 * 
 */
package com.qa.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author tiwar
 *
 */
public class RetryFailedTest implements IRetryAnalyzer {

	private int count = 0 ;
	private int retries = 1;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retries) {
			count++;
			return true;
		}
		
		return false;
	}

}
