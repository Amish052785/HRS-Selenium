package com.hrs.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrs.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//i[@class='fa fa-eye']")
	WebElement showhidepassword_button;
		
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotpassword_link;
	
	@FindBy(xpath="//button[@id='loginSubmitButton']")
	WebElement Signin_button;
	
	@FindBy(xpath="//img[@class='qa-login--img-hrs_logo']")
	WebElement loginheader_logo;
	
	@FindBy(xpath="//a[contains(text(),'Health Recovery Solutions')]")
	WebElement healthrecoverysolution_link;
	
	//Initializing the Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHRSLogo() {
		return loginheader_logo.isDisplayed();
	}
	
	public boolean validateShowHidePasswordButton() {
		return showhidepassword_button.isDisplayed();
	}
	
	public boolean validateForgotPasswordLink() {
		return forgotpassword_link.isDisplayed();
	}
	
	public boolean validateHealthRecoverySolutionLink() {
		return healthrecoverysolution_link.isDisplayed();
	}
	
	public String invalidLogin(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Signin_button.click();
		
		//return error message text
		WebElement err_msg =  driver.findElement(By.xpath("//div//span[@class='ng-scope']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(err_msg));

		return err_msg.getText();
	}

	
	
}
