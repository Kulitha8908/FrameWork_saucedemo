package com.swaglabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		// load excel file 
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		 catch (Exception e) {
			System.out.println("Unable To Read excel data file "+e.getMessage());
		}
	}
	
	//get sheet string data 
	//          get sheetname
	public  String getStringdata(String sheetname,int row,int cell)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	//          get sheetname by id 
	public String getStringdata(int sheetindex,int row,int cell)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
	}
	//get numeric data 
	public double getNumericData(String sheetname,int row,int cell)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		
	}
}
