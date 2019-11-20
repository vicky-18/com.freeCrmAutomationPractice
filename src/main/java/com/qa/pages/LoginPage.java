package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Base;

public class LoginPage extends Base
{
	
     public LoginPage()
{
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath = "//input[@name = 'username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@class = 'btn btn-small']")
	WebElement loginBtn;
	
	
	
	public void loginPage1(String user, String pass)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean bool = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'preloader']")));
		if(bool)
		{
			username.sendKeys(user);
			password.sendKeys(pass);
			loginBtn.click();
			
		}
		
	}

}
