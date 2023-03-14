package com.bookswagan.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookswagon.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_lblUser")WebElement on;
	@FindBy(name="col-sm-2") WebElement loginp;
	@FindBy(id="ctl00_phBody_SignIn_txtEmail") WebElement username;
	@FindBy(id="ctl00_phBody_SignIn_txtPassword") WebElement password;
	@FindBy(id="ctl00_phBody_SignIn_btnLogin")WebElement login;
	@FindBy(id="ctl00_imglogo") WebElement logo;
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBookswagonImage() {
		return logo.isDisplayed();
	}
	
    public MyaccountPage logIn(String un,String pwd) {
    	Actions action = new Actions(driver);
    	action.moveToElement(on).perform();
    	
        loginp.click();
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	login.click();
    	
    	return new MyaccountPage();
    }
}
