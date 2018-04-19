package com.rb.promise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rb.promise.dataExtraction.ReadObject;
import com.rb.promise.handlers.LocatorHandler;
import com.rb.promise.keywords.GenericAction;

public class LoginPageObject {
public static LocatorHandler loc = new LocatorHandler();
	
	
	public  HomePageObject  login(WebDriver driver, String chooseProvider, String userName, String Password){
		try {
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("LoginPageObjects","ProviderDropDwn"), chooseProvider);
			GenericAction.clear(driver, ReadObject.getPageObject("LoginPageObjects","UserNameTxtBox"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("LoginPageObjects","UserNameTxtBox"), userName);
			GenericAction.clear(driver, ReadObject.getPageObject("LoginPageObjects","PasswordTxtBox"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("LoginPageObjects","PasswordTxtBox"), Password);
			GenericAction.click(driver, ReadObject.getPageObject("LoginPageObjects","LoginBtn"));
			
		} catch (Exception e) {
			System.out.println("Exception in loginPromise method "+e.getMessage());
		}
		return PageFactory.initElements(driver, HomePageObject.class);	
	}	
	/*public void verifyLoginPage(WebDriver driver){
		try {
			Assert.assertTrue(GenericAction.doesElementExist(driver, readPageObject("PromiseLoginPageObjects", "Logo"), true), "LogoNotPresent ");
			Assert.assertEquals("Forgot password?", GenericAction.getText(driver, readPageObject("PromiseLoginPageObjects", "ForgetPasswordLink")), "Forgot password? txt not found");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/


}
