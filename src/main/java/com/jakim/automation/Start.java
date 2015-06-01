package com.jakim.automation;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jakim.automation.pageobects.HomePage;
import com.jakim.automation.pageobects.LoginPage;

public class Start {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://dir.bg");
		/*
		 * WebElement news = driver.findElement(By.id("live-dnes-news"));
		 * System.out.println(news.toString());
		 * System.out.println(news.getTagName());
		 * System.out.println(news.getText());
		 * news.findElement(By.xpath(".//a[1]")).click();
		 */

		HomePage homePage = new HomePage(driver);

		String newsSectionTitle = homePage.getNewsSection().getTitle();
		Assert.assertEquals(newsSectionTitle, "����", newsSectionTitle);

		int news = homePage.getNewsSection().getLinks().size();
		Assert.assertEquals(homePage.getNewsSection().getLinks().size(), 4,
				news);

		// homePage.getNewsSection().getLinks().get(1).click();
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		LoginPage loginPage = homePage.openLoginPage();
		loginPage.enterEmail("pesho@abv.bg");
		loginPage.enterPassword("peshovaparola");
		loginPage.submitLogin();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String realMessage = loginPage.getLoginAlertMessage();
		Assert.assertEquals(realMessage,"������ ������������� ��� ��� ������!",realMessage);
		driver.quit();
	}

}
