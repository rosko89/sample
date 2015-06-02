package com.jakim.automation.pageobects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasePageObject {
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		driver = new FirefoxDriver();
		this.driver = driver;
	}

	public HomePage navigateToHomePage(WebDriver driver) {
		return new HomePage(driver);
	}

}
