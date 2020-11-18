package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	static ExtentReports reports;
	public static ExtentReports getExtentReportObject()
	{
		String path=System.getProperty("user.dir")+"\\extent reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Web Automation Reports");
		reporter.config().setReportName("Automation report");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		return reports;
	}

}
