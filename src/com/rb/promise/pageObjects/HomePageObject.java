package com.rb.promise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rb.promise.base.BaseTest;
import com.rb.promise.dataExtraction.ReadObject;
import com.rb.promise.handlers.LocatorHandler;
import com.rb.promise.keywords.GenericAction;

public class HomePageObject {
	
	public static WebDriverWait wait=new WebDriverWait(BaseTest.driver,30);
	public static LocatorHandler loc=new LocatorHandler();
	
	
	public String readPageObject(String SheetName, String objectName){
		String locator =null;
		try {
			locator = ReadObject.getPageObject(SheetName, objectName);
		} catch (Exception e) {
			System.out.println("Exception in readPageObject method "+e.getMessage());
		}
		System.out.println(locator);
		return locator;
	}
	
	public void logOut(WebDriver driver){
		try {			
			GenericAction.click(driver, readPageObject("HomePageObjects","LogoutToggleLink"));
			GenericAction.click(driver, readPageObject("HomePageObjects","UserImg"));
			GenericAction.click(driver, readPageObject("HomePageObjects","LogoutLink"));			
		} catch (Exception e) {
			System.out.println("Exception in logOutOPL method "+e.getMessage());
		}
	}
	
	public ProjectsPageObject clickProjectsLink(WebDriver driver){
		try {
			GenericAction.click(driver, readPageObject("HomePageObjects", "ProjectsLink"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in clickProjectsLink method "+e.getMessage());
		}
		return PageFactory.initElements(driver, ProjectsPageObject.class);
	}
	
	
	public ProjectsPageObject clickHomeLink(WebDriver driver){
		try {
			GenericAction.click(driver, readPageObject("HomePageObjects","HomeLink"));
			
		} catch (Exception e) {
			// TODO: handle exception
		   System.out.println("Exception in ClickHomeLink method " +e.getMessage());
		}
		return PageFactory.initElements(driver, ProjectsPageObject.class);
	}
	
	
	
	public AdminPageObject clickAdmiLink(WebDriver driver){
		try {
			GenericAction.click(driver, readPageObject("HomePageObjects", "ProjectLink"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in clickAdmiLink method "+e.getMessage());
		}
		return PageFactory.initElements(driver, AdminPageObject.class);
	}
	

}
