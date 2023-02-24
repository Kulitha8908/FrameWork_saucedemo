package com.swaglabs.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.utility.BrowserFactory;

public class LoginTestCRM {
	
WebDriver driver;

@BeforeClass
public void setUp()
{
	driver = BrowserFactory.StartApplication(driver,"Chrome", "https://www.saucedemo.com/");
	
}

@Test	
public void loginToApplication()
{
	
	
	LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
	loginpage.loginToApp("standard_user", "secret_sauce");
	
	
	}

@AfterClass
public void tearDown()
{
	BrowserFactory.quitBrowser(driver);
}
	
}
