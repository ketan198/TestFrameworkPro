/**
 * 
 */
package com.qa.utilities;

/**
 * @author Ketan Tiwari
 *
 */
public class DynamicUtilityAllocator {
	
	

		private DynamicUtilityAllocator() {
		}

		
		public static String getXpath(String main, String replacement) {
			return String.format(main, replacement);
		}

		
		public static String getXpath(String main, String replacement1, String replacement2) {
			return String.format(main, replacement1, replacement2);
		}
	

}
