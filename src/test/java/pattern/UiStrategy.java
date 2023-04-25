package pattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import commonactions.Browser;
import hooks.Hooks;
import io.cucumber.java.Scenario;
import pages.UiLoginPage;;

public class UiStrategy implements Capability   {

	UiLoginPage uilogin = UiLoginPage.getInstance();

	//ChromeOptions options = new ChromeOptions();

	

	public void login() {
		
		

		
		//options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		Browser.driver = new ChromeDriver();
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Browser.driver.get("https://www.amazon.in/");

		Browser.driver.manage().window().maximize();
	}

	public void getCurrentWindow() {
		// TODO Auto-generated method stub
		uilogin.getCurrentUrl();
	}

	public void shopping() {
		// TODO Auto-generated method stub

		uilogin.shopping();

	}
	
	

}
