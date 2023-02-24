package com.swaglabs.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.swaglabs.utility.BrowserFactory;

public class LoginTestCRM {
	
WebDriver driver;	
@Test	
public void loginToApplication()
{
	BrowserFactory.StartApplication(driver,"Chrome", "https://www.saucedemo.com/");
	}
	
	
}
