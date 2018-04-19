package com.rb.promise.keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rb.promise.dataExtraction.ReadObject;
import com.rb.promise.handlers.EnumHandler.FilterBlockOptions;
import com.rb.promise.handlers.FileHandler;
import com.rb.promise.handlers.LocatorHandler;

public class Promise {

	public static LocatorHandler loc = new LocatorHandler();

	public static void searchFilterBlock(WebDriver driver, FilterBlockOptions opt, String fieldObject, String fieldText){
		try {
			if(opt.toString().equals("Filter")){
				GenericAction.click(driver, fieldObject);
				GenericAction.clear(driver, ReadObject.getCommonPageObject("FilterTxtBox"));
				GenericAction.sendKeys(driver, ReadObject.getCommonPageObject("FilterTxtBox"), fieldText);
				GenericAction.click(driver, ReadObject.getCommonPageObject("FilterBtn"));

			}else if (opt.toString().equals("Clear")) {
				GenericAction.click(driver, fieldObject);
				GenericAction.click(driver, ReadObject.getCommonPageObject("FilterBtn"));				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in searchFilterBlock method "+e.getMessage());
		}
	}

	public static void datePickerFormat(WebDriver driver, String pickerImageObject, String date) {
		try {
			GenericAction.click(driver, pickerImageObject);			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if(!date.equalsIgnoreCase("today")){
				GenericAction.selectDropDownByLabel(driver, ReadObject.getCommonPageObject("DatePickerMonthDropDwn"), date.split("_")[1]);	
				GenericAction.selectDropDownByLabel(driver, ReadObject.getCommonPageObject("DatePickerYearDropDwn"), date.split("_")[2]);	
				wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getCommonPageObject("DatePickerDate").replace("$", date.split("_")[0])))).sendKeys(Keys.RETURN);
				//				if(GenericAction.doesElementExist(driver, ReadObject.getCommonPageObject("DatePickerDoneBtn"), true)){
				//					wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getCommonPageObject("DatePickerDoneBtn")))).click();	
				//				}				
			}else{
				wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getCommonPageObject("DatePickerTodayBtn")))).click();
			}	
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in datePickerFormat method "+e.getMessage());
		}
	}

	public static void getProjectID(WebDriver driver ,String proObject) throws Exception{

		try {

			String proID=GenericAction.getText(driver, proObject);
			System.out.println(proID.subSequence(19,28));
			String str=(String) proID.subSequence(19,28);
			
			FileHandler.writeToFile(str);
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in getProjectID method "+e.getMessage());
		}
	}
		

		public static void inputProjectID(WebDriver driver ,String proObject) throws Exception{

			try {

				
				FileHandler.readFromFile();
				

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in inputProjectID method "+e.getMessage());
			}


		
	}
	
	
	
	
	
	
	
	
	

	

	public static void SelectFromAvailableList(WebDriver driver,String SearchListObject, FilterBlockOptions opt, String fieldObject, String fieldText){
		try {
			GenericAction.click(driver, SearchListObject);

			if(opt.toString().equals("Filter")){
				GenericAction.click(driver, fieldObject);
				//GenericAction.clear(driver, ReadObject.getCommonPageObject("FilterTxtBox"));
				GenericAction.sendKeys(driver, ReadObject.getCommonPageObject("FilterTxtBox"), fieldText);
				GenericAction.click(driver, ReadObject.getCommonPageObject("FilterBtn"));

			}else if (opt.toString().equals("Clear")) {
				GenericAction.click(driver, fieldObject);
				GenericAction.click(driver, ReadObject.getCommonPageObject("FilterBtn"));				
			}		
			GenericAction.click(driver, ReadObject.getCommonPageObject("FormSearchRadioBtn").replace("$", fieldText));
			GenericAction.click(driver, ReadObject.getCommonPageObject("FormSearchAddBtn"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in searchFilterBlock method "+e.getMessage());
		}


	}

}
