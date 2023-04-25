package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonactions.Browser;
import pattern.UiStrategy;

public class UiLoginPage {

	private static UiLoginPage instance;
	private Browser browser = new Browser();

	private static By searchbox = By.id("twotabsearchtextbox");
	private static By priceTags = By.className("a-price-whole");

	public static UiLoginPage getInstance() {

		if (instance == null) {

			synchronized (UiLoginPage.class) {

				if (instance == null) {

					instance = new UiLoginPage();
				}

			}

		}
		return instance;

	}

	public void getCurrentUrl() {

		//System.out.println(UiStrategy.driver.getCurrentUrl() + "url");

	}

	public void shopping() {

		browser.click(searchbox);
		browser.enter(searchbox, "samsung mobiles");
		browser.enter(searchbox, Keys.RETURN);


		List<WebElement> pricelements = browser.getElements(priceTags);

		HashMap<WebElement, String> pricemap = new HashMap<WebElement, String>();

		for (WebElement webElement : pricelements) {
			
			

			String price = webElement.getText().replaceAll("\\D", "");
			//System.out.println(price);

			if(!price.equalsIgnoreCase(""))
			pricemap.put(webElement, price);

		}

		List<Entry<WebElement, String>> lst = new ArrayList<Entry<WebElement, String>>(pricemap.entrySet());
		
		
				
		Collections.sort(lst, new Comparator<Map.Entry<WebElement, String>>() {

			public int compare(Entry<WebElement, String> o1, Entry<WebElement, String> o2) {

				if (Integer.parseInt(o1.getValue()) > Integer.parseInt(o2.getValue()))
					return 1;
				else if (Integer.parseInt(o1.getValue()) < Integer.parseInt(o2.getValue()))
					return -1;

				return 0;
			}

		});

		for (Entry<WebElement, String> Entry : pricemap.entrySet()) {

			System.out.println(Entry.getKey() + " " + Entry.getValue());

		}
		
		
		
		System.out.println("sorted list having map");
		
		System.out.println("lowest price is" + lst.get(0).getValue());
		
        JavascriptExecutor js = (JavascriptExecutor)browser.driver;
		
		js.executeScript("window.scrollBy(0,250)", "");
		
		Actions action = new Actions(browser.driver);

		
		
		
		action.keyDown(Keys.COMMAND).click(lst.get(0).getKey()).release(lst.get(0).getKey()).perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lst.get(0).getKey().click();
		
		
		Set<String> windowHandles = browser.getActiveWindows();
		List<String> wList = new ArrayList<String>();
		
		wList.addAll(windowHandles);
		
		browser.switchToWindow(wList.get(1));
		
		browser.click(By.id("buy-now-button"));
		
		
		Set<String> windowHandles2 = browser.getActiveWindows();
		
	List<String> wList2 = new ArrayList<String>();
		
		wList2.addAll(windowHandles2);
		
		browser.switchToWindow(wList2.get(2));
		
		
		 WebElement continue_btn = browser.driver.findElement( By.id("continue"));

		
		action.click(continue_btn).perform();
		
		
		
	}

}
