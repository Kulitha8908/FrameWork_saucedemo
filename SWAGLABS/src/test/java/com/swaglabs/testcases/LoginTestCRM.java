package com.swaglabs.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.swaglabs.pages.BaseClass;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utility.BrowserFactory;
import com.swaglabs.utility.ExcelDataProvider;

public class LoginTestCRM extends BaseClass {

	@Test
	public void loginToApplication() {

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginToApp(excel.getStringdata("Credentials", 0, 0), excel.getStringdata("Credentials", 0, 1));

	}

}
