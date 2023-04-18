package runner;

import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

	
	
	@Test
	public void report() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target//spark.html");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Salman");
		test.info("details");
		extent.flush();
	}
	
	
	
}
