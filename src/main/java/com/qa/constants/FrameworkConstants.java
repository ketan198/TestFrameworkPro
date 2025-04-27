/**
 * 
 */
package com.qa.constants;



import com.qa.reportutil.ReportManager;

/**
 * @author Ketan Tiwari
 *
 */
public final class FrameworkConstants {
	

	private FrameworkConstants() {
		
	}

	
	private static final String CONFIGFILE =  System.getProperty("user.dir")+ "/src/test/resources/properties/config.properties"; 
	private static final String EXTENT_REPORTS = System.getProperty("user.dir")+ "";
	private static final String JSON_CONFIG_ALLTESTS_FILE_PATH = "src/test/resources/extentconfigs/extentconfig-spark-all.json";
	private static final String JSON_CONFIG_ONLYFAILED_FILE_PATH = "src/test/resources/extentconfigs/extentconfig-spark-onlyfailed.json";
	
	private static final int EXPLICIT_WAIT =  10;
	
	private static final String TESTDATASHEET_PATH = System.getProperty("user.dir")+"/src/test/resources/excel/TestData.xlsx";
	


	private static final String RUNMANAGERSHEET_PATH = System.getProperty("user.dir")+"/src/test/resources/excel/RunManager.xlsx";
	
	private static final String TESTDATA_SHEET= "TESTDATA";
	
	private static final String RUNMANAGER_SHEET = "RUNMANAGER";
	
	
	

	private static String alltestreportpath =  "test-reports/"  + ReportManager.getReportFolderName() + "/reports/report_alltests.html";
	private static String failedreportpath = "test-reports/" + ReportManager.getReportFolderName()
	+ "/reports/report_onlyfailedtests.html";
	private static String screenshotsFolderPath = "test-reports/" + ReportManager.getReportFolderName()
	+ "/screenshots";
	
	
	public static String getTestdataSheet() {
		return TESTDATA_SHEET;
	}
	public static String getRunmanagerSheet() {
		return RUNMANAGER_SHEET;
	}

	public static String getTestdatasheetPath() {
		return TESTDATASHEET_PATH;
	}
	public static String getRunmanagersheetPath() {
		return RUNMANAGERSHEET_PATH;
	}
	
	public static String getConfigfile() {
		return CONFIGFILE;
	}
	public static String getAlltestreportpath() {
		return alltestreportpath;
	}
	public static String getScreenshotsFolderPath() {
		return screenshotsFolderPath;
	}
	public static String getJsonConfigAlltestsFilePath() {
		return JSON_CONFIG_ALLTESTS_FILE_PATH;
	}
	public static String getJsonConfigOnlyfailedFilePath() {
		return JSON_CONFIG_ONLYFAILED_FILE_PATH;
	}
	public static String getFailedreportpath() {
		return failedreportpath;
	}
	public static String getExtentReports() {
		return EXTENT_REPORTS;
	}
	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	
	
	
}
