package com.jakim.automation.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jakim.automation.pageobects.HomePage;
import com.jakim.automation.pageobects.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	public static WebDriver driver;
	public static HomePage homePage;
	public static LoginPage loginPage;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dir.bg");
	}

	@Given("^the login page is opened$")
	public void openLoginPage() throws Throwable {
		homePage = new HomePage(driver);
		loginPage = homePage.openLoginPage();
	}

	@When("^I enter (.+) email in the email field$")
	public void enterLoginEmail(String emailType) throws Throwable {
		if (emailType.contains("invalid")) {
			loginPage.enterEmail("!@#$^$#%^");
		} else if (emailType.contains("unregistered")) {
			loginPage.enterEmail("asd321@asd.adg");
		} else if (emailType.contains("registered")) {
			loginPage.enterEmail("ivanchoooo@abv.bg");
		}
	}

	@When("^I enter (.+) password in the password field$")
	public void enterWrongPassword(String passwordType) throws Throwable {
		if (passwordType.contains("invalid")) {
			loginPage.enterPassword("......");
		} else if (passwordType.contains("wrong")) {
			loginPage.enterPassword("asd321@asd.adg");
		} else if (passwordType.contains("correct")) {
			loginPage.enterPassword("ivanchoooo@abv.bg");
		}
	}

	@When("^I submit$")
	public void submitLoginForm() throws Throwable {
		loginPage.submitLogin();
	}

	@Then("^an error text displays$")
	public void checkWrongLoginMessages() throws Throwable {
		String errorMessage = loginPage.getLoginAlertMessage();
		Assert.assertEquals(errorMessage,
				"Грешно потребителско име или парола!", errorMessage);
	}

	@Then("^I'm not logged in$")
	public void checkLoginStatus() throws Throwable {
		Assert.assertTrue(true);
	}

	@After
	public void cleanUp() {
		driver.quit();
	}
}
