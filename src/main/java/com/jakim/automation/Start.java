package com.jakim.automation;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jakim.automation.pageobects.HomePage;

public class Start {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://dir.bg");
/*		WebElement news = driver.findElement(By.id("live-dnes-news"));
		System.out.println(news.toString());
		System.out.println(news.getTagName());
		System.out.println(news.getText());
		news.findElement(By.xpath(".//a[1]")).click();*/
		
		HomePage homePage = new HomePage(driver);
		
		String newsSectionTitle = homePage.getNewsSection().getTitle();
		Assert.assertEquals(newsSectionTitle, "Днес", newsSectionTitle);
		
		int news = homePage.getNewsSection().getLinks().size();
		Assert.assertEquals(homePage.getNewsSection().getLinks().size(), 4, news);
		
		homePage.getNewsSection().getLinks().get(1).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
