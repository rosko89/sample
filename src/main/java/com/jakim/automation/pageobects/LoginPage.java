package com.jakim.automation.pageobects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		if (!driver.getTitle().equals("My.dir.bg")) {
			throw new IllegalStateException(
					"This is not Login Page, current page" + " is: "
							+ driver.getTitle());
		} else {
			this.driver = driver;
		}
	}

	public void enterEmail(String email) {
		WebElement emailFieldInput = this.driver.findElement(By
				.id("login_name"));
		emailFieldInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordFieldInput = this.driver.findElement(By
				.id("login_pass"));
		passwordFieldInput.sendKeys(password);
	}

	public void submitLogin() {
		WebElement loginButton = this.driver.findElement(By.id("submit_but"));
		loginButton.click();
	}
	
	public String getLoginAlertMessage(){
		return this.driver.findElement(By.cssSelector(".fpBlockBody2>b")).getText();
	}

}
