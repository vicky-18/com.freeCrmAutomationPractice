package com.qa.test;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.lib.Helper;
import com.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class LoginTest extends Base
{
	ExtentReports reports;
    ExtentTest logger;
    LoginPage loginPage;
    
    public LoginTest()
	{
		super();
	}
    
  @Test(dataProvider = "getData")
  public void veriyLogin(String user , String pass) 
  {
	  
	  loginPage.loginPage1(user,pass);
	  
	 String title =  driver.getTitle();
	 
	 Assert.assertEquals(title,"CRMPRO");
	  
  }
  @DataProvider(name = "getData")
  public Object[][] passData()
  {
	  Object[][] obj = new Object[3][2];
	  obj[0][0] = "Vikash1717";
	  obj[0][1] = "vicky@123";
	  
	  obj[1][0] = prop.getProperty("username");
	  obj[1][1] = prop.getProperty("password");
	  
	  obj[2][0] = "vicky1818";
	  obj[2][1] = "vikash@123";
	  
	  return obj;
	  
  }
  @BeforeMethod
  public void setUp()
  {
	  reports = new ExtentReports("D:\\Selenium Project\\com.freeCrmAutomationPractice\\reports\\LoginTest.html",true);
	  logger = reports.startTest("Login with valid caredentials");
	  
	  browseInit();
	  
	  loginPage = new LoginPage();
	  
  }

  @AfterMethod
  public void tearDown(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  Helper.screenShot(driver, result.getName());
	  }
	  
	  reports.endTest(logger);
	  reports.flush();
	  driver.quit();
	  
	  
  }

}
