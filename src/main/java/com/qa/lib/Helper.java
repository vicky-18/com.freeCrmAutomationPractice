package com.qa.lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.Base;

public class Helper extends Base
{
	
	public static void screenShot(WebDriver driver ,String name)
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenShot/"+name+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void frameHandle(int frameIndex)
	{
		 driver.switchTo().frame(frameIndex);
		
	}
	
	public static void frameHandle(String frameName)
	{
		 driver.switchTo().frame(frameName);
		
	}
	
	public static void frameHandle(WebElement web)
	{
		 driver.switchTo().frame(web);
		
	}
	
}
