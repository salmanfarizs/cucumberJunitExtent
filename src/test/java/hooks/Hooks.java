package hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonactions.Browser;
import database.WriteToSql;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pattern.UiStrategy;

public class Hooks {

	public static ExtentReports extent = new ExtentReports();

	public static ExtentTest test;

	public static String scenarioname;
	public static String scnearioStatus;


	@Before
	public static void beforeScenario(Scenario scenario) {

		scenarioname=scenario.getName().replace("\"", "");
		ExtentSparkReporter spark = new ExtentSparkReporter("target//index.html");
		extent.attachReporter(spark);
		Hooks.test = Hooks.extent.createTest(scenario.getName()).assignAuthor("Salman")
				.assignCategory("smoke tests").assignDevice("Windows");

	}

	@After
	public static void afterScenario(Scenario scenario) {

		scnearioStatus = scenario.getStatus().toString();
		
		System.out.println("status = " +scnearioStatus);
		WriteToSql.updateMetrics();
		
		Browser.driver.quit();
		extent.flush();

	}

}
