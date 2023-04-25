package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonactions.Browser;
import io.cucumber.junit.CucumberOptions;

public class Sample {

	ChromeOptions options = new ChromeOptions();
	public static RemoteWebDriver driver;
	

	@BeforeSuite
public void bs() {
	System.out.println("before suite");
}	

	@BeforeTest
public void bt() {
	System.out.println("before test");
}
	
	@BeforeClass
public void bc() {
	System.out.println("before class");
}

	@BeforeMethod
public void bm() {
	System.out.println("before method");
	
}

	@DataProvider
public void dp() {
	System.out.println("dataprovider");
}
	
	
@Test(priority =-1,invocationCount=2)
public void testNg() {
	
	
	System.out.println("priority in 1");
}



@Test	(priority =0)
public void testNg2() {
	
	
	System.out.println("priority in 2");
}
	

@AfterSuite
public void as() {
	System.out.println("after suite");
}	

@AfterTest
public void at() {
	System.out.println("after test");
}
	
@AfterClass
public void ac() {
	System.out.println("after class");
}

@AfterMethod
public void am() {
	System.out.println("after method");
	
}
	
}
