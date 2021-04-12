package com.hrs.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrs.qa.base.TestBase;
import com.hrs.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginpageTitle();
		Assert.assertEquals(title, "HRS | ClinicianConnect");
	}

	@Test(priority=2)
	public void InvalidLoginTest() {
		String error_message = loginpage.invalidLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(error_message, "Username and/or password invalid");
	}
	
	@Test(priority=3)
	public void HRSLogoImageTest() {
		Boolean flag = loginpage.validateHRSLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=4)
	public void ShowHidePasswordButtonTest() {
		Boolean flag = loginpage.validateShowHidePasswordButton();
		Assert.assertTrue(flag);
	}

	@Test(priority=5)
	public void ForgotPasswordLinkTest() {
		Boolean flag = loginpage.validateForgotPasswordLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=6)
	public void HealthRecoverySolutionLinkTest() {
		Boolean flag = loginpage.validateHealthRecoverySolutionLink();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
