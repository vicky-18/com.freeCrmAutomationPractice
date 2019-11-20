package com.qa.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	static XSSFWorkbook wb;
	
	public Excel()
	{
		File src = new File("");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Sheet could not be loaded"+e.getMessage());
		} 
		  
		}
	
	public static String getData(int sheetIndex, int row, int col)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}
	
	public static String getData(String sheetName, int row, int col)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}
	
	public static int getNumericData(int sheetIndex, int row, int col)
	{
		int data = (int)wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
		
		return data;
	}
	
	public static int getNumericData(String sheetName, int row, int col)
	{
		int data = (int)wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		
		return data;
	}
		 
		 
		
	}


