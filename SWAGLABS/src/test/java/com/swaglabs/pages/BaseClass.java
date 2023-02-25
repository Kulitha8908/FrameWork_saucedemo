package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.swaglabs.utility.BrowserFactory;
import com.swaglabs.utility.ConfigDataProvider;
import com.swaglabs.utility.ExcelDataProvider;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	@BeforeSuite
	public void setupSuit() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.StartApplication(driver, config.getBrowser(), config.getUrl());
		//driver = BrowserFactory.StartApplication(driver, "Chrome", "https://www.saucedemo.com/");

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

}
