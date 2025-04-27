/**
 * 
 */
package com.qa.reportutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ketan Tiwari
 *
 */
public final class ReportManager {

	private ReportManager() {
		// TODO Auto-generated constructor stub
	}	
	
	private static String reportFolderName;
	
	public static String getTimeStamp() {
		LocalDateTime objDateTime = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm-ss");
		return objDateTime.format(date);
	}
	


	public static String getReportFolderName() {
		reportFolderName = "Report_" + getTimeStamp();
		return reportFolderName;
	}

}
