package org.stepDefination;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.pom.HomePage;
import org.testng.Assert;
import org.utility.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TestCase03_DeleteAccount extends BaseTest {

	public HomePage homePageElements = null;

	@And("user click on delete acoount")
	public void user_click_on_delete_acoount() {
		try {
			homePageElements = new HomePage(BaseTest.driver);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Wait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement deleteButton = (WebElement) wait
				.until(ExpectedConditions.elementToBeClickable(homePageElements.clickOnDeleteAccount()));
		deleteButton.click();
	}

	@Then("user navigate to account deleted page")
	public void user_navigate_to_account_deleted_page() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.automationexercise.com/delete_account";
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Delete Account Test Case Passed....");
		driver.quit();
	}
}
