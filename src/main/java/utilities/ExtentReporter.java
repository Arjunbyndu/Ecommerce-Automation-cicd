package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReporter 
{
	public static  ExtentReports extentReports() 
	{
		String path = System.getProperty("user.dir") + "//ExtentReports//file.html";
		ExtentSparkReporter report1 = new ExtentSparkReporter(path);
		report1.config().setDocumentTitle("Ecomerce Test Report");
		report1.config().setReportName("Web Automation result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report1);
		extent.setSystemInfo("QA Engneer", "Arjun A B");
		return extent;
		
	}
}
