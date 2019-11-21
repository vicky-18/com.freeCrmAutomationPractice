package com.qa.lib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader 
{
	XSSFWorkbook wb;
	public ExcelReader()
	{
		File src = new File("./TestData/AppData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("This is "+e.getMessage());
		}
	}
	
	public String getData(int SheetIndex, int row, int column)
	{
		String data = wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String SheetName, int row, int column)
	{
		String data = wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
