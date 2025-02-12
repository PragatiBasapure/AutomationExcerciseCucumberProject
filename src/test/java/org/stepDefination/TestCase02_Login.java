package org.stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.test.pom.SignUpPage;
import org.testng.Assert;
import org.utility.BaseTest;
import org.utility.ExcelDataMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase02_Login extends BaseTest {

	public SignUpPage loginElements;
	public ExcelDataMethods excelDataProvider;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get("https://www.automationexercise.com/signup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("user enters email and password")
	public void user_enters_email_and_password() throws Exception {
		loginElements = new SignUpPage(driver);
		excelDataProvider = new ExcelDataMethods();
		excelDataProvider.getExcelFileName();
		loginElements.loginemail(excelDataProvider.getStringValue("LoginSignUpPage", 1, 1));
		loginElements.setPassword(excelDataProvider.getStringValue("LoginSignUpPage", 1, 2));

	}

	@And("click on login button")
	public void click_on_login_button() {
		loginElements.clickOnLogin();
	}

	@Then("user navigate on homepage")
	public void user_navigate_on_homepage() {
		String expectedUrl = "https://www.automationexercise.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Login test case passed..!!");
	}
}
