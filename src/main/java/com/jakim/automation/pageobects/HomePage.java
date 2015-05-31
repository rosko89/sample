package com.jakim.automation.pageobects;

import org.openqa.selenium.WebDriver;

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


}
