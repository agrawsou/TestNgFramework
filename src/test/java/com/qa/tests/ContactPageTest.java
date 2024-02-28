package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactUsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactUsPage contactUsPage;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactUsPage = homePage.clickOnContactUsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void contactPageLabelTest() {
		Assert.assertTrue(contactUsPage.isContactLabelExist());
	}
	
	@Test(priority=2)
	public void contactPageContactEmailAddressTest() {
		String actualEmailAddress = contactUsPage.getContactEmailAddress();
		Assert.assertEquals(actualEmailAddress, "hello@softwaretestingboard.com");
	}

}
