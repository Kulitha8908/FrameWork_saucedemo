package com.swaglabs.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	@SuppressWarnings("deprecation")
	public static WebDriver StartApplication(WebDriver ldriver, String browserName, String url) {
		if (browserName.equals("Chrome")) {
			System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
			ldriver = new ChromeDriver();
		}
		ldriver.manage().window().maximize();
		ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ldriver.get(url);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return ldriver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}

}
