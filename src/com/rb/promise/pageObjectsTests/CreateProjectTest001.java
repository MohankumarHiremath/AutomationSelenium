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

public class CreateProjectTest001 extends BaseTest {
	
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
		//*For ContinuationProject/projectPage.createProject(driver, createProject.ContinuationProject, CreateUpdateDeleteProjectTestData[0]);
		projectPage.createProject(driver, createProject.NewProject, CreateUpdateDeleteProjectTestData[0]);
		homePage.logOut(driver);
		
		
		HomePageObject homePage2= loginPage.login(driver, LoginTestData.get("TC001.ChooseProvider"), LoginTestData.get("TC001.UserName"), LoginTestData.get("TC001.Password"));
		ProjectsPageObject projectPage2= homePage.clickProjectsLink(driver);
	    projectPage.createModifyProject(driver, CreateUpdateDeleteProjectTestData[0]);
	    homePage.logOut(driver);
	    
	
	    HomePageObject homePage3= loginPage.login(driver, LoginTestData.get("TC003.ChooseProvider"), LoginTestData.get("TC003.UserName"), LoginTestData.get("TC003.Password"));
	    ProjectsPageObject projectPage3= homePage3.clickProjectsLink(driver);
		projectPage3.createApproveProject(driver, CreateUpdateDeleteProjectTestData[0]);
	    homePage3.logOut(driver);
	    

	    HomePageObject homePage4=loginPage.login(driver, LoginTestData.get("TC002.ChooseProvider"), LoginTestData.get("TC002.UserName"), LoginTestData.get("TC001.Password"));
	    ProjectsPageObject projectPage4=homePage.clickProjectsLink(driver);
	    projectPage.createGrmApproveProject(driver, CreateUpdateDeleteProjectTestData[0]);
		homePage.logOut(driver);
		
		
		HomePageObject homePage5=loginPage.login(driver, LoginTestData.get("TC005.ChooseProvider"), LoginTestData.get("TC005.UserName"), LoginTestData.get("TC005.Password"));
		ProjectsPageObject projectPage5=homePage.clickProjectsLink(driver);
		projectPage.createDHApproveProject(driver, CreateUpdateDeleteProjectTestData[0]);
		homePage.logOut(driver);
		System.out.println("happyflow is done");
	}

}
