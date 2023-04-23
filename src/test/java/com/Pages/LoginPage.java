package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver pageDriver;
	
	//============================ Objects ======================================	
	
	@FindBy(name="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	

	@FindBy(name="login-button")
	WebElement loginBtn;
	
	//============================ Methods ==============================================
	
	public LoginPage(WebDriver driver) {
		
	//	this.driver = driver;
		pageDriver=driver;
		PageFactory.initElements(pageDriver, this);
	}
	
	public void LoginFunction(String UserNameVal,String PwdVal) throws InterruptedException {	
		userName.sendKeys(UserNameVal);Thread.sleep(3000);		
		password.sendKeys(PwdVal);	Thread.sleep(3000);
		loginBtn.click();Thread.sleep(3000);
		
	}

}
