package com.rb.promise.pageObjectsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rb.promise.base.BaseTest;
import com.rb.promise.keywords.GenericAction;
import com.rb.promise.pageObjects.HomePageObject;
import com.rb.promise.pageObjects.LoginPageObject;
import com.rb.promise.pageObjects.ProjectsPageObject;

public class CreateSubProjectTest extends BaseTest{
	
	
LoginPageObject loginPage = PageFactory.initElements(driver, LoginPageObject.class);	
	
	@BeforeSuite
	public void beforeSuite(){
		BaseTest.getBrowser();
	}
	
	
	@AfterSuite
	public void afterSuite(){
		
	}
	@Test
	public void CreateSubProject001Test(){
		//
		HomePageObject homePage = loginPage.login(driver, LoginTestData.get("TC001.ChooseProvider"), LoginTestData.get("TC001.UserName"), LoginTestData.get("TC001.Password"));
		//
		ProjectsPageObject projectPage = homePage.clickProjectsLink(driver);
		
		System.out.println(CreateUpdateDeleteSubProjectTestData[0]);
		
		projectPage.creatSubProject(driver, CreateUpdateDeleteSubProjectTestData[0]);
		homePage.logOut(driver);
		loginPage.login(driver, LoginTestData.get("TC001.ChooseProvider"), LoginTestData.get("TC002.UserName"), LoginTestData.get("TC002.Password"));
		
    //Assert.assertEquals(actual, expected, "");
	}

}
