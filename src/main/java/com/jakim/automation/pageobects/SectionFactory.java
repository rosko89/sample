package com.jakim.automation.pageobects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionFactory {
	
	public static Section getNewsSection(final WebDriver driver){
		Section section = new Section(){
			@Override
			public String getTitle() {
				return driver.findElement(By.xpath(("//div[@id='dnes_main']//h2/a"))).getText();
			}

			@Override
			public List<WebElement> getLinks() {
				return driver.findElements(By.xpath(("//div[@id='live-dnes-news']/a")));
			}

			@Override
			public WebElement getImage() {
				// TODO Auto-generated method stub
				return driver.findElement(By.id(("dnesimage")));
			}
			
		};
		
		return section;
	}
}
