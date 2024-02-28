package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AccountPage extends TestBase {
	
	@FindBy(css = "div[role='alert'] div div")
	WebElement successfulRegistrationMsg;

	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public String getRegistrationMsg() {
		return successfulRegistrationMsg.getText();
	}

}
