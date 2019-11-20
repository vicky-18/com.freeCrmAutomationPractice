package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Base()
	{
		prop = new Properties();
		try
		{
			FileInputStream fis = new FileInputStream("D:\\Selenium Project\\com.freeCrmAutomationPractice"
					              + "\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("File is not Loaded"+e.getMessage());
		}
	}
	
	public static void browseInit()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Project\\com.freeCrmAutomationPractice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Selenium Project\\com.freeCrmAutomationPractice\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("internetExplorer"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Selenium Project\\com.freeCrmAutomationPractice\\Drivers\\IEDriverServer.exe");
			InternetExplorerOptions opt = new InternetExplorerOptions();
			opt.ignoreZoomSettings();
			driver = new InternetExplorerDriver(opt);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
