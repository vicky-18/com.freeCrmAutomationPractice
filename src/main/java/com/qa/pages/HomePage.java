package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Base;

public class HomePage extends Base
{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains (text(),'Sign Up')]") 
    WebElement signUpLink;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingLink;
	
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement featuresLink;
	
	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customersLink;
	
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	
	public void clickOnSignUpLink() 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			signUpLink.click();
		}	
	}
	
	public void clickOnPricingLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			pricingLink.click();
		}
	}
	
	public void clickOnFeaturesLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			featuresLink.click();
		}
	}
	
	public void clickOnCustomersLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			customersLink.click();
		}
	}
	
	public void clickOnContactLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			contactLink.click();
		}
		}
	
	public boolean clickOnCrmLogoLink()
	{
		boolean logo = false;
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(invisible)
		{
			 logo = crmLogo.isDisplayed();
			crmLogo.click();
		}
		return logo;
	}

}
