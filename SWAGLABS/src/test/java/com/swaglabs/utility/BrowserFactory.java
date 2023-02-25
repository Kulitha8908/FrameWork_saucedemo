package com.swaglabs.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swaglabs.pages.BaseClass;

public class BrowserFactory extends BaseClass{

	@SuppressWarnings("deprecation")
	public static WebDriver StartApplication(WebDriver driver, String browserName, String url) {
		if (browserName.equals("Chrome")) {
			System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}

}
