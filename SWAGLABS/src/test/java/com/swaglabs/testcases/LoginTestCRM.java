package com.swaglabs.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.utility.BrowserFactory;

public class LoginTestCRM {
	
WebDriver driver;	
@Test	
public void loginToApplication()
{
	driver = BrowserFactory.StartApplication(driver,"Chrome", "https://www.saucedemo.com/");
	
	LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
	loginpage.loginToApp("standard_user", "secret_sauce");
	
	BrowserFactory.quitBrowser(driver);
	}
	
	
}
