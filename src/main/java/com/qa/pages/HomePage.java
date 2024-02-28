package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	// PageFactory
	@FindBy(css = ".logged-in")
	WebElement welcomeUser;

	@FindBy(xpath = "//a[text()='Contact us']")
	WebElement contactUs;

	@FindBy(xpath = "//span[text()='Sale']")
	WebElement sale;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserWelcome() {
		return welcomeUser.getText();
	}

	public ContactUsPage clickOnContactUsLink() {
		contactUs.click();
		return new ContactUsPage();
	}

	public SalePage clickOnSaleLink() {
		sale.click();
		return new SalePage();
	}

}
