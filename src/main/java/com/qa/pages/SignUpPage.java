package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SignUpPage extends TestBase {

	// PageFactory
	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "email_address")
	WebElement email;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(id = "password-confirmation")
	WebElement confirmPass;

	@FindBy(xpath = "//span[text()='Create an Account']")
	WebElement createAccountBtn;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public AccountPage createNewUser(String fName, String lName, String mail, String password) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(mail);
		pass.sendKeys(password);
		confirmPass.sendKeys(password);
		createAccountBtn.click();
		return new AccountPage();
	}

}
