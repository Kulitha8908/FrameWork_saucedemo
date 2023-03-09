package com.swaglabs.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.swaglabs.utility.BrowserFactory;
import com.swaglabs.utility.ConfigDataProvider;
import com.swaglabs.utility.ExcelDataProvider;
import com.swaglabs.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupSuit() {
		Reporter.log("Setting up reports and Test",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CRM"+Helper.getsystemDateandTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done - test can be started --",true);
	}
	
	@Parameters({"browser","urlTobeTested"})
	@BeforeClass
	public void setUp(String browser,String url) {
		//public void setUp(String browser,String url)
		driver = BrowserFactory.StartApplication(driver, browser, url);
		//driver = BrowserFactory.StartApplication(driver, config.getBrowser(), config.getUrl());
		//driver = BrowserFactory.StartApplication(driver, "Chrome", "https://www.saucedemo.com/");

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult test) throws IOException
	{
		if(test.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenShot(driver);	
			//add screen shot to report
			logger.pass("Test Faild", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(test.getStatus()==ITestResult.SUCCESS)
		{
			Helper.captureScreenShot(driver);
			logger.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
			
		
	}
	
	
	

}
