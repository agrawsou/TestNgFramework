package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="send2")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[contains(@src,'logo')]")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Create an Account']")
	WebElement createAct;
	
	//Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String userName, String pass) {
		email.sendKeys(userName);
		password.sendKeys(pass);
		signInBtn.click();
		
		return new HomePage();
	}
	
	public SignUpPage launchCreateAccountPage() {
		createAct.click();
		return new SignUpPage();
	}
	
}
