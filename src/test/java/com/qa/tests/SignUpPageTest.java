package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;
import com.qa.utils.ExcelReader;

public class SignUpPageTest extends TestBase {
	
	LoginPage loginPage;
	SignUpPage signUpPage;
	AccountPage accountPage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		signUpPage = loginPage.launchCreateAccountPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "userProvider")
	public Object[][] getUserData() throws IOException{
		return ExcelReader.getDataFromSheet("src\\main\\java\\com\\qa\\testData\\TestData.xlsx", "user");
	}
	
	@Test(priority=1, dataProvider = "userProvider")
	public void createNewUsers(String fName, String lName, String mail, String pass) throws InterruptedException {
		accountPage = signUpPage.createNewUser(fName, lName, mail, pass);
		Thread.sleep(5000);
		String actualRegistrationMsg = accountPage.getRegistrationMsg();
		Assert.assertEquals(actualRegistrationMsg, "Thank you for registering with Main Website Store.");
	}

}
