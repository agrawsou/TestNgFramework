package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class ContactUsPage extends TestBase {

	// PageFactory
	@FindBy(xpath = "//h2[text()='Contact']")
	WebElement contactLabel;

	@FindBy(xpath = "//h2[text()='Email us']/../../following-sibling::div//a")
	WebElement emailAddress;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public boolean isContactLabelExist() {
		return contactLabel.isDisplayed();
	}
	
	public String getContactEmailAddress() {
		return emailAddress.getText();
	}

}
