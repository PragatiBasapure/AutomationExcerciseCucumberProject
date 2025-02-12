package org.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage{

	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Mrs']")
	private WebElement gender_Mrs;
	
	@FindBy(xpath = "//input[@value='Mr']")
	private WebElement gender_Mr;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "days")
	private WebElement days;
	
	@FindBy(id = "months")
	private WebElement months;
	
	@FindBy(id = "years")
	private WebElement years;
	
	@FindBy(xpath = "//label[text()='Sign up for our newsletter!']")
	private WebElement checkbox1;
	
	@FindBy(xpath = "//label[contains(text(),'Receive special offers from our partners!')]")
	private WebElement checkbox2;
	
	@FindBy(id = "first_name")
	private WebElement firstname;
	
	@FindBy(name = "last_name")
	private WebElement lastname;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "address1")
	private WebElement address;
	
	@FindBy(id = "country")
	private WebElement country;
	
	@FindBy(id = "state")
	private WebElement state;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(id = "zipcode")
	private WebElement code;
	
	@FindBy(id = "mobile_number")
	private WebElement number;
	
	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement createAccountButton;
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	private WebElement accountCreated;
	
	public void genderSelect()
	{
		gender_Mrs.click();
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setDay(String day)
	{
		new Select(days).selectByVisibleText(day);
	}
	
	public void setMonth(String month)
	{
		new Select(months).selectByVisibleText(month);
	}
	
	public void setYear(String year)
	{
		new Select(years).selectByValue(year);
	}
	
	public void checkBox1()
	{
		checkbox1.click();
	}
	
	public void checkBox2()
	{
		checkbox2.click();
	}
	
	public void setFirstName(String firstName)
	{
		firstname.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}
	
	public void setCompany(String companyName)
	{
		company.sendKeys(companyName);
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void setCountry(String countryname)
	{
		new Select(country).selectByValue(countryname);
	}
	
	public void setState(String statename)
	{
		state.sendKeys(statename);
	}
	
	public void setCity(String cityName)
	{
		city.sendKeys(cityName);
	}
	
	public void setZip(String zip)
	{
		code.sendKeys(zip);
	}
	
	public void setMobile(String mobile)
	{
		number.sendKeys(mobile);
	}
	
	public void clickonbutton()
	{
		createAccountButton.click();
	}
	
	public String getCreateAccountText()
	{
		return accountCreated.getText();
	}
}
