package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.swaglabs.utility.BrowserFactory;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver = BrowserFactory.StartApplication(driver,"Chrome", "https://www.saucedemo.com/");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

}
