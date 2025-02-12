package org.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage
{
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement userName;
	
	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement email;
	
	@FindBy(xpath = "//button[contains(text(),'Signup')]")
	private WebElement signUp;
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	   private WebElement text;
	
	public void username(String username)
	{
		userName.sendKeys(username);
	}
	
	public void password(String emailpass)
	{
		email.sendKeys(emailpass);
	}
	
	public void signup()
	{
		signUp.click();
	}
	
	public String getText()
	{
		return text.getText();
	}
	
	//***************************************************************
	//Login Elements
	
	@FindBy (xpath = "(//input[@type='email'])[1]")
	private WebElement loginEmail;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement login;
	
	public void loginemail(String email)
	{
		loginEmail.sendKeys(email);
	}
	
	public void setPassword(String password1)
	{
		password.sendKeys(password1);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
}
