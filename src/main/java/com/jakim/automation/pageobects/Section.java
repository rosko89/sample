package com.jakim.automation.pageobects;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface Section {
	
	public String getTitle();
	public List<WebElement> getLinks();
	public WebElement getImage();
}
