package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import hooks.Hooks;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="resource/features",
		glue= {"steps","hooks"},
		plugin= {"pretty","html:target/cucumberreport.html"},
		monochrome=true)
public class TestRunner {
	
}
