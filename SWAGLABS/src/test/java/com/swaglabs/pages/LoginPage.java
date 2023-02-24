package com.swaglabs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@name='user-name']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement pword;
	@FindBy(xpath="//input[@name='login-button']") WebElement submit;

	public void loginToApp(String userName,String passWord)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(userName);
		pword.sendKeys(passWord);
		submit.click();
	}
}
