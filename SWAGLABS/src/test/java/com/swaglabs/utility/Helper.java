package com.swaglabs.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
// Screenshot,syncissue,Datatime
	
	public static void captureScreenShot(WebDriver driver)
	{
		//capture and store screen shot in scr as file 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy screen shot to local screen shot folder
		try {
			FileHandler.copy(src,new File("./ScreenShots/login.png") );
		} catch (Exception e) {
			System.out.println("Unable to capture screen shot "+e.getMessage());
			
		}
		
	}
	
	
}
