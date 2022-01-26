package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		// ExtentsReports, ExtentSparkReporter
				String path = System.getProperty("user.dir") + "/extent-reports/index.html";
				
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				extent= new ExtentReports();
				
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Anish S");
				
				return extent;
	}

}
