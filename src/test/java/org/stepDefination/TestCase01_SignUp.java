package org.stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.test.pom.CreateAccountPage;
import org.test.pom.SignUpPage;
import org.testng.Assert;
import org.utility.ExcelDataMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase01_SignUp {
	public static WebDriver driver;
	public SignUpPage webelement;
	public ExcelDataMethods excelData;
	public CreateAccountPage createAccountElements;
	@Given("User is on SignUp Page")
	public void user_is_on_sign_up_page() {
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions option=new ChromeOptions();
	    option.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(option);
		driver.get("https://www.automationexercise.com/signup");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("User Enters Username and Password")
	public void user_enters_username_and_password() throws Exception {
	  webelement= new SignUpPage(driver);
	  excelData =new ExcelDataMethods();
	  excelData.getExcelFileName();
	  webelement.username(excelData.getStringValue("LoginSignUpPage", 1, 0));
	  webelement.password(excelData.getStringValue("LoginSignUpPage", 1, 1));
	}

	
	
	@And("User click on SignUp button")
	public void user_click_on_sign_up_button() {
		webelement.signup();
	}

	@And("User click on createAccount button")
	public void user_click_on_create_account_button() {
	    createAccountElements.clickonbutton();
	}
	
	@Then("User Navigate on Create account page")
	public void user_navigate_on_create_account_page() {
		String actualvalue=webelement.getText();
		String expectedValue="ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(actualvalue, expectedValue);
		System.out.println("Test Case Passed...!!");
		
	}
	
	@Then("User Enters all the Data")
	public void user_enters_all_the_data() throws Exception {
		createAccountElements=new CreateAccountPage(driver);
		createAccountElements.genderSelect();
		createAccountElements.setPassword(excelData.getStringValue("CreateAccountPage", 1, 0));
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		createAccountElements.setDay(Integer.toString((int) excelData.getNumericValue("CreateAccountPage", 1, 1)));
		createAccountElements.setMonth(excelData.getStringValue("CreateAccountPage", 1, 2));
		createAccountElements.setYear(Integer.toString((int) excelData.getNumericValue("CreateAccountPage", 1, 3)));
		createAccountElements.checkBox1();
		createAccountElements.checkBox2();
		createAccountElements.setFirstName(excelData.getStringValue("CreateAccountPage", 1, 4));
		createAccountElements.setLastName(excelData.getStringValue("CreateAccountPage", 1, 5));
		createAccountElements.setCompany(excelData.getStringValue("CreateAccountPage", 1, 6));
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		createAccountElements.setAddress(excelData.getStringValue("CreateAccountPage", 1, 7));
		createAccountElements.setCountry(excelData.getStringValue("CreateAccountPage", 1, 8 ));
		createAccountElements.setState(excelData.getStringValue("CreateAccountPage", 1, 9));
		createAccountElements.setCity(excelData.getStringValue("CreateAccountPage", 1, 10));
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		createAccountElements.setZip(Integer.toString((int) excelData.getNumericValue("CreateAccountPage", 1, 11)));
		createAccountElements.setMobile(Integer.toString((int) excelData.getNumericValue("CreateAccountPage", 1, 12)));
	}
	
	@Then("User Navigate on account created page")
	public void user_navigate_on_account_created_page() {
	    String actualText=createAccountElements.getCreateAccountText();
	    String expectedText="ACCOUNT CREATED!";
	    Assert.assertEquals(actualText, expectedText);
	    System.out.println("Second test Case Passed");
	    driver.quit();
	}


}
