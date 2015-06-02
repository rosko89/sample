package com.jakim.automation.pageobects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePageObject{
	public Section newsSection;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver.get("http://www.dir.bg");
	}

	public Section getNewsSection() {
		return SectionFactory.getNewsSection(this.driver);
	}

	public LoginPage openLoginPage() {
		WebElement loginButton = this.driver.findElement(By.cssSelector("#lenta-login>a"));
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage(this.driver);
	}

}
