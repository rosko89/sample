package com.jakim.automation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.jakim.automation.pageobects.BasePageObject;
import com.jakim.automation.pageobects.HomePage;


public class Start2 {
	private WebDriver driver;
	private BasePageObject basePageObject;

	@Before
	public void init(){
		this.basePageObject = new HomePage(this.driver);
	}
	
	@Test
	public void test1(){
		this.basePageObject.navigateToHomePage(this.driver).getNewsSection().getLinks().get(1).click();
	}
}
