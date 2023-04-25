package commonactions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import hooks.Hooks;
import pattern.UiStrategy;

public class Browser extends Hooks {

	public static RemoteWebDriver driver;
	
	public Browser() {
			// TODO Auto-generated constructor stub
	}

	public void click(By ele) {

		try {
			driver.findElement(ele).click();
			test.pass("clicked " + ele + "successfully",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot()).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.fail("click failed for " + ele);
		}

	}

	public void enter(By ele, String text) {
		
		
		try {
			driver.findElement(ele).sendKeys(text);
			test.pass("Entered text " + text );
		} catch (Exception e) {

			test.fail("enter failed");
			
		}
	}

	public void enter(By ele, Keys key) {
		driver.findElement(ele).sendKeys(key);

	}

	public List<WebElement> getElements(By ele) {

		return driver.findElements(ele);

	}

	public Set<String> getActiveWindows() {

		return driver.getWindowHandles();
	}

	public void switchToWindow(String win) {

		driver.switchTo().window(win);
	}

	
	public String getScreenShot() throws  IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String dest = "screenshots/image.jpeg";
		try {
			FileUtils.copyFile(source, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] byteArray = IOUtils.toByteArray(new FileInputStream(dest));
		return Base64.getEncoder().encodeToString(byteArray);
		
		
	}
	
	
	public boolean matches(String pattern,String text) {
		
		return Pattern.matches(pattern, text);
		
	}
	
	
	
	
}
