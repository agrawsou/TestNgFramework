package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactUsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactUsPage contactUsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Home Page");
	}
	
	@Test(priority=2, enabled=false)
	public void loginPageLogoTest() {
		String actualWelcomeMsg = homePage.verifyUserWelcome();
		Assert.assertEquals(actualWelcomeMsg, "Welcome, Sourabh Agrawal!");
	}
	
	@Test(priority=3)
	public void clickContactUsTest() {
		contactUsPage = homePage.clickOnContactUsLink();
	}

}
