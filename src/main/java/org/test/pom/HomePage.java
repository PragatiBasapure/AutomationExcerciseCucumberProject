package org.test.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//a[contains(text(),' Delete Account')]")
	private WebElement deleteAccount;
	
	
	
	public WebElement clickOnDeleteAccount()
	{
		return deleteAccount;
	}
	
	
}

