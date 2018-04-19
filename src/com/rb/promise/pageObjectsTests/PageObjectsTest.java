package com.rb.promise.pageObjectsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rb.promise.base.BaseTest;
import com.rb.promise.pageObjects.LoginPageObject;

public class PageObjectsTest extends BaseTest{
	
	
LoginPageObject loginPage = PageFactory.initElements(driver, LoginPageObject.class);	
	
	@BeforeSuite
	public void beforeSuite(){		
		BaseTest.getBrowser();
	}
	
	@BeforeMethod
	public void setUp(){
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		
	}
	
	@AfterSuite
	public void afterSuite(){
		
	}
	@Test
	public void test(){
		System.out.println("sample");
	}

}
