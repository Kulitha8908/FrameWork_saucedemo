package com.swaglabs.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
// Screenshot,syncissue,Datatime
	
	public static String captureScreenShot(WebDriver driver)
	{
		String screenShotpath = System.getProperty("user.dir")+"/ScreenShots/"+getsystemDateandTime()+".png";
		//capture and store screen shot in scr as file 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy screen shot to local screen shot folder
		try {
			FileHandler.copy(src,new File(screenShotpath) );
		
		} catch (Exception e) {
			System.out.println("Unable to capture screen shot "+e.getMessage());
			
		}
		return screenShotpath;
		
	}
	
	public static String getsystemDateandTime()
	{
		DateFormat currentformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date current = new Date(); 
		return currentformat.format(current);
				
	}
	
	
}
