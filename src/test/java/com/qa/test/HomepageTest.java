package com.qa.test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.lib.Helper;
import com.qa.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomepageTest extends Base 
{
	ExtentReports reports;
    ExtentTest logger;
    HomePage home;
    
    public HomepageTest()
    {
    	super();
    }
	
	@BeforeMethod
	public void setUp()
	{
		reports = new ExtentReports("D:\\Selenium Project\\com.freeCrmAutomationPractice\\reports\\Homepage.html",true);
		logger = reports.startTest("Homepage Link Verification");
		
		browseInit();
		
		home = new HomePage();
		
		logger.log(LogStatus.INFO, "Application is up and Running");
	}
	@Test(priority = 1)
	public void signUpLinkTest()
	{
		 home.clickOnSignUpLink();
		 
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"Cogmento CRM");
		
		System.out.print(title);
		 
		 logger.log(LogStatus.INFO, "SignUp Link Working Properly");
		
	}
	@Test(priority = 2)
	public void contactLinkTest()
	{
		home.clickOnContactLink();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"CRMPRO Professional CRM Contact Us");
		
		System.out.print(title);
		
		logger.log(LogStatus.INFO, "Contact Link Working Properly");
	}
	@Test(priority = 3)
	public void customersLinkTest()
	{
		home.clickOnCustomersLink();
		
		String title = driver.getTitle();
		
		Assert.assertTrue(title.contains("CRMPRO Professional CRM Customers"));
		
		System.out.print(title);
		
		logger.log(LogStatus.INFO, "Customers Link Working Properly");
	}
	@Test(priority = 4)
	public void pricingLinkTest()
	{
		home.clickOnPricingLink();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "CRMPRO PRICING");
		
		System.out.print(title);
		
		logger.log(LogStatus.INFO, "Pricing Link Working Properly");
	}
	@Test(priority = 5)
	public void featuresLinkTest()
	{
		home.clickOnFeaturesLink();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("CRM Pro Best Features and CRM Value "));
		
		System.out.print(title);
		
		logger.log(LogStatus.INFO, "Features Link Working Properly");
		
	}
	@Test(priority = 6)
	public void crmLogoTest()
	{
		boolean bool = home.clickOnCrmLogoLink();
		Assert.assertTrue(bool);
		
		logger.log(LogStatus.PASS, "CRMLOGO is Displayed");
		
		home.clickOnCrmLogoLink();
	}
	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.screenShot(driver, result.getName());
		}
			logger.log(LogStatus.INFO,"Closing Browser");
		reports.endTest(logger);
		reports.flush();
		driver.quit();
	}

}
