package com.swaglabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;
	public ConfigDataProvider()
	{
		// Load config file 
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}  catch (Exception e) {
			System.out.println("Unable to load config file"+e.getMessage());
		}
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
				
	}
	
	public String getUrl()
	{
		return pro.getProperty("Url");
	}
}
