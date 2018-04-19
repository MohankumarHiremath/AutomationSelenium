package com.rb.promise.pageObjectsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rb.promise.base.BaseTest;
import com.rb.promise.pageObjects.HomePageObject;
import com.rb.promise.pageObjects.LoginPageObject;
import com.rb.promise.pageObjects.ProjectsPageObject;
import com.rb.promise.pageObjects.ProjectsPageObject.createProject;

public class CreateProjectTest extends BaseTest {
	
	LoginPageObject loginPage=PageFactory.initElements(driver, LoginPageObject.class);
	
	@BeforeSuite
	public void beforeSuite(){
		BaseTest.getBrowser();
	}
	@AfterSuite
	public void afterSuite(){
		
	}
	@Test
	public void CreateProject001Test(){
		

		HomePageObject homePage = loginPage.login(driver, LoginTestData.get("TC002.ChooseProvider"), LoginTestData.get("TC002.UserName"), LoginTestData.get("TC001.Password"));
		
		ProjectsPageObject projectPage=homePage.clickProjectsLink(driver);
		//*For ContinuationProject*//projectPage.createProject(driver, createProject.ContinuationProject, CreateUpdateDeleteProjectTestData[0]);
		projectPage.createProject(driver, createProject.NewProject, CreateUpdateDeleteProjectTestData[0]);
		
		
		
		//tr[@class='gfr']/td/span[starts-with(text(),'VasanthRao M')]
		//span[starts-with(text(),'Requested By')]/parent::nobr[1]/parent::span[1]/following-sibling::span[@title='Select from Available List'][1]
		//span[starts-with(text(),'Customer')]/parent::nobr[1]/parent::span[1]/following-sibling::span[@title='Select from Available List'][1]
		//span[starts-with(text(),'Project Name')]/parent::nobr[1]/parent::span[1]/following-sibling::span[@title='Tooltip not available for the field'][1]
	
	}

}
