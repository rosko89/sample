package com.jakim.automation.pageobects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	public Section newsSection;
	
	public HomePage(WebDriver driver){
		if (!driver.getTitle().equals("Dir.bg - Българският Интернет портал!")){
			throw new IllegalStateException("This is not Home Page of logged in user, current page" +
                                        " is: " + driver.getTitle());
		}else{
			this.driver = driver;
		}
		
	}

	public Section getNewsSection() {
		return SectionFactory.getNewsSection(this.driver);
	}

	public LoginPage openLoginPage() {
		WebElement loginButton = this.driver.findElement(By.cssSelector("#lenta-login>a"));
		loginButton.click();
		return new LoginPage(this.driver);
	}

}
