package com.bookswagon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bookswagan.qa.pages.LoginPage;
import com.bookswagan.qa.pages.MyaccountPage;
import com.bookswagon.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	MyaccountPage myaccountPage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage= new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals("title", "Online BookStore India,By Books Online ");
	}
	
	@Test(priority=2)
	public void bookswagonLogoTest() {
		boolean img =loginPage.validateBookswagonImage();
		Assert.assertTrue(img);
	}
	@Test(priority=3)
	public void loginTest() {
		myaccountPage=loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
