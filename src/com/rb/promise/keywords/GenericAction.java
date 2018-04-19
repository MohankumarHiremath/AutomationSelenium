package com.rb.promise.keywords;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rb.promise.base.BaseTest;
import com.rb.promise.handlers.LocatorHandler;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class GenericAction {

	private static Logger logger = Logger.getLogger(GenericAction.class.getName());	
	public static LocatorHandler loc = new LocatorHandler();

	
	public static  void click(WebDriver driver, String object){
		logEntry();
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(object)));
			driver.findElement(loc.autoLocator(object)).click();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			logger.warning("Error When click on object.");
			System.out.println("Exception in click method" +e.getCause());
		}		
	}	
	
	public static void sendKeys(WebDriver driver, String object, String keys){
		logEntry();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(object)));
			element.sendKeys(keys);
//			driver.findElement(loc.autoLocator(object)).sendKeys(keys);
			
		} catch (Exception e) {
			logger.warning("Error When click on object.");
			System.out.println("Exception in sendKeys" +e.getCause());
		}		
	}		
	
	public static void selectCheckBox(WebDriver driver, String object, boolean flag){
		logEntry();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(object)));
			WebElement element = driver.findElement(loc.autoLocator(object));
			if(flag){
				if(!element.isSelected() == true){
					element.click();
				}
			}else if(!flag){
				if(element.isSelected() == true){
					element.click();
				}
			}			
		} catch (Exception e) {
			logger.warning("Error When clickOn CheckBox object.");
			System.out.println("Exception in clickOnCheckBox Method "+e.getCause());
		}		
	}
	
	public static void selectDropDownByLabel(WebDriver driver, String object, String label){
		logEntry();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(object)));
			WebElement element = driver.findElement(loc.autoLocator(object));
		
			Select sel = new Select(element);
			List<WebElement> list = sel.getOptions();
			for(WebElement ele : list){
			//System.out.println("Options "+ele.getText());
			System.out.println("Options "+label.trim());
				if(ele.getText().trim().equals(label.trim())){
					ele.click();
					TimeUnit.SECONDS.sleep(5);		
					break;						
				}
			}
		} catch (Exception e) {
			logger.warning("Error when selecting a drop down option");
			System.out.println("Exception in selectDropDownByLabel Method "+e.getCause());
		}		
	}
	
	public static void mouseOverClick(WebDriver driver,String element,String menuElement){
		  try {
			  if(element!=""){
	                String url = driver.getCurrentUrl();
	                 if(BaseTest.BrowserName.equalsIgnoreCase("firefox") || BaseTest.BrowserName.equalsIgnoreCase("GoogleChrome")) {
	                   WebElement ele = driver.findElement(loc.autoLocator((element)));
	                   Thread.sleep(1000);
	                   new Actions(driver).moveToElement(ele).perform();                 
	                   } else {
	                Selenium selenium = new WebDriverBackedSelenium(driver, url);
	                Thread.sleep(2000);
	                GenericAction.doesElementExist(driver, element, true);
	                selenium.mouseOver(element);
	                driver = ((WebDriverBackedSelenium) selenium).getWrappedDriver();
	                         }
	                }
			  GenericAction.click(driver, menuElement);
			  TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			logger.warning("Error when mouseOver and click on object");
			System.out.println("Exception in mouseOverClick Method "+e.getCause());
		}
	}
	 
	
	 
	public static boolean verifySpecifiedObject(WebDriver driver,String locator,boolean flag) throws Exception {
		logEntry();
		boolean flagValue = false;
		try{
		if(!locator.isEmpty()){
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);		
				if(flag==true){
					WebElement element = wait.until(visibilityOfElementLocated(loc.autoLocator(locator)));
						if(element!=null){
							if(element.isDisplayed()){
								flagValue = true;
							}
						}
						else {
							flagValue = false;
						}
			return flagValue;
		}
		else if(flag==false){
				WebElement element = wait.until(visibilityOfElementLocated(loc.autoLocator(locator)));
				if(element==null){
					flagValue = true;
				}
				else {
					flagValue = false;
				}

			}
		}
	  }catch(Exception e){
			logger.warning("Error When performing verifySpecifiedObject.");
			System.out.println("Exception in verifySpecifiedObject"  +e.getCause());
		}
		return flagValue;
	}
	
	public static void clear(WebDriver driver, String Object) throws Exception{
		logEntry();
		try {		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(Object)));
		if(GenericAction.doesElementExist(driver, Object, true)){
		  driver.findElement(loc.autoLocator(Object)).clear();
		}
		} catch (Exception e) {
			logger.warning("Error When performing clear.");
			System.out.println("Exception in clear"  +e.getCause());
		}
	}
	
	
	
	public static String getAttributeValue(WebDriver driver, String element, String attribute) throws Exception{
		logEntry();
		String value = null;
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement ele  = wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(element)));
			value = ele.getAttribute(attribute);			
		} catch (Exception e) {
			logger.warning("Error When performing getAttributeValue.");
			System.out.println("Exception in getAttributeValue"  +e.getCause());
		}
		return value;
	}
	
	public static void closeCurrentWindow(WebDriver driver){
		  driver.switchTo().window(driver.getWindowHandle()).close();
	}
	
	public static void clickViaJavaScript(WebDriver driver,String element){		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(element)));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", loc.autoLocator(element)); 
	}	 
	
	
	public static String getText(WebDriver driver, String element) throws Exception{
		logEntry();
		String value = null;
		try {			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement ele  = wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(element)));
			value = ele.getText();			
		} catch (Exception e) {
			logger.warning("Error When performing getText.");
			System.out.println("Exception in getText"  +e.getCause());
		}
		return value;
	}
	
	 public static String handlePopUpWindow(WebDriver driver, String parentWindowId) throws Exception {
		 String popUpWindowId = null;
         if(parentWindowId!=null) {
        	 TimeUnit.SECONDS.sleep(5);
             Set<String> windowIds = driver.getWindowHandles();
             while(windowIds.size() == 1) {
            	 windowIds = driver.getWindowHandles();
            	 }
             for(String currentWindowId : windowIds) {
            	 if(!currentWindowId.equalsIgnoreCase(parentWindowId)) {
            		 popUpWindowId = currentWindowId;
            		 }
            	 }
             TimeUnit.SECONDS.sleep(5);
             driver.switchTo().window(popUpWindowId);
        }
        return popUpWindowId;
     }	
	
	
	/**
     * Find out if an element is stale or not.
     *
     * @param element - An element locator
     * @return boolean - True if element exists, otherwise false.
	 * @throws Exception 
     * @throws Exception
     */
    public static boolean doesElementExist(WebDriver driver,String element,boolean flag) throws Exception {
       	try{
    
    	if(flag==true){
            if (driver.findElements(loc.autoLocator(element)).size() > 0) {
                flag =  true;
            } else {
                flag =  false;
            }
    	}
    	else if(flag==false){
            if (driver.findElements(loc.autoLocator(element)).size()== 0) {
                flag = true;
            } else {
                flag = false;
            }
    	 }
    	
    	}catch(NullPointerException nex){
    		flag=false;
    	}
    	return flag;
    }
	
     public static void mouseOverAnObject (WebDriver driver,String obj) throws Exception{
         if(obj!=""){
               String url=driver.getCurrentUrl();
                if(!BaseTest.BrowserName.equalsIgnoreCase("firefox")){
                     WebElement ele = driver.findElement(loc.autoLocator((obj)));
                  Thread.sleep(1000);
                  new Actions(driver).moveToElement(ele).perform();                 
                        }else{
               Selenium selenium = new WebDriverBackedSelenium(driver, url);
               Thread.sleep(2000);
               GenericAction.doesElementExist(driver, obj, true);

              
                selenium.mouseOver(obj);                   
                
               driver = ((WebDriverBackedSelenium) selenium).getWrappedDriver();
               
                        }
               }
         }
     
     public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
         return new ExpectedCondition<WebElement>() {
           public WebElement apply(WebDriver driver) {
             WebElement element = driver.findElement(by);
             return element.isDisplayed() ? element : null;
           }
         };
       }

 	/**
 	 * This process will wait for a specified object until either the specified object appears on the window or
 	 * until the timeOut limit is reached.
 	 */

 	public void waitForObject(WebDriver driver,String element,long timeOut){
 		
 		try{
 			Wait<WebDriver> waitFor = new WebDriverWait(driver, timeOut);
 			waitFor.until(visibilityOfElementLocated(loc.autoLocator(element)));
 		}
 		catch(Exception e){
 			
 			System.out.println("Exception in WaitForObject" + e.getCause());
 		}
 	}

 	/**
 	 * This Keyword will wait to load.
 	 * @param driver : WebDriver instance.
 	 */
 	public boolean waitForPageToLoad(WebDriver driver){
 	    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
 	      public Boolean apply(WebDriver driver) {

 	        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
 	      }
 	    };

 	    WebDriverWait wait = new WebDriverWait(driver, 1);
 	    try {
 	            wait.until(expectation);
 	    } catch(Throwable error) {
 	            System.out.println("Timeout waiting for Page Load Request to complete.");
 	    }
 	    return wait.until(expectation);
 	}
	
 	/**
	 * This Keyword will verify that an object of the specified name and type either exists or does not exist on the current window.
	 *  @param locator should be the element to verify
	 *  @param driver is an instance of WebDriver
	 *  @param farmeName should be the name(s) of the frame where the element is located.
	 */
	public boolean verifySpecifiedObject(String locator,boolean flag,WebDriver driver) throws Exception,NoSuchElementException,NoSuchElementException {
		
		boolean flagValue = false;
		try{
		if(!locator.isEmpty()){
			Wait<WebDriver> wait = new WebDriverWait(driver, 60);
				if(flag==true){

					WebElement element = wait.until(visibilityOfElementLocated(loc.autoLocator("")));
						if(element!=null){
							if(element.isDisplayed()){
								flagValue = true;
							}
						}
						else {
							flagValue = false;
						}
			return flagValue;
		}
		else if(flag==false){
				WebElement element = wait.until(visibilityOfElementLocated(loc.autoLocator(locator)));
				if(element==null){
					flagValue = true;
				}
				else {
					flagValue = false;
				}

			}
		}
		}
		catch(NoSuchElementException e){
		
			System.out.println("Exception in verifySpecifiedObject"  +e.getCause());
		}
		return flagValue;
	}
	/**
	 * This process will VERIFY that the specified TEXT is located on the page or is not located on the page.
	 * If textExists is set to Exists then it will look for that text on the window.
	 * If textExists is set to Does Not Exists then it will verify that the text is not on the window.
	 * For text to be verified, wildcards are not used. Instead just enter the part of a string you wish to verify exists (or does not exist).
	 * As long as that text appears somewhere in a string of text on the page, it will be verified (with a few exceptions).
	 * @param textToVerify must be the text to verify on the page.
	 * @param textExists must be either "true" or "false".
	 */
	public boolean verifySpecifiedText(WebDriver driver, String textToVerify,boolean textExists) {
		
		boolean flag = false;
		try{
			if(!textToVerify.isEmpty()){
				Wait<WebDriver> wait = new WebDriverWait(driver, 60);
				if(textExists==true){
					if(driver.getPageSource().contains(textToVerify)){
						flag = true;
					}
					else {
						flag = false;
					}
				}
				else if(textExists==false){
					if(!driver.getPageSource().contains(textToVerify)){
						flag = true;
					}
					else{
						flag = false;
					}
				}

			}
		}
		catch(NoSuchElementException e){
		
			System.out.println("Exception in VerifySpecified Text" + e.getCause());
		}
		return flag;

	}
	/**
	 * This process will VERIFY that the specified TEXT is located on the page or is not located on the page.
	 * If textExists is set to Exists then it will look for that text on the window.
	 * If textExists is set to Does Not Exists then it will verify that the text is not on the window.
	 * For text to be verified, wildcards are not used. Instead just enter the part of a string you wish to verify exists (or does not exist).
	 * As long as that text appears somewhere in a string of text on the page, it will be verified (with a few exceptions).
	 * @param textToVerify must be the text to verify on the page.
	 */
	public boolean verifySpecifiedText(WebDriver driver, String textToVerify) {
	
		boolean flag = false;
		try{
			if(!textToVerify.isEmpty()){
				Wait<WebDriver> wait = new WebDriverWait(driver, 60);
					if(driver.getPageSource().contains(textToVerify)){
						flag = true;
					}
					else {
						flag = false;
					}
				}
		}
		catch(NoSuchElementException e){
		
			System.out.println("Exception in VerifySpecified Text" + e.getCause());
		}
		return flag;
	}
	

	/**
	 * Entry log level
	 */
	public static final Level ENTRY_LOG_LEVEL = Level.FINE;

			    
	/**
	 * Log the entry to a method.
	 */
	public static void logEntry()
	{
		if( logger.isLoggable(ENTRY_LOG_LEVEL))
		{
			Throwable t = new Throwable();
			StackTraceElement[] ste = t.getStackTrace();
			String methodName = ste[1].getMethodName();
			if (methodName != null)
			{
				logger.log(ENTRY_LOG_LEVEL, "ENTRY: " + methodName);
			}
		}
	}

	/**
	 * Exit log level
	 */
	public static final Level EXIT_LOG_LEVEL = Level.FINEST;

	/**
	 * Log the exit from a method.
	 */
	public void logExit()
	{
		if( logger.isLoggable(EXIT_LOG_LEVEL))
		{
			Throwable t = new Throwable();
			StackTraceElement[] ste = t.getStackTrace();
			String methodName = ste[1].getMethodName();
			if (methodName != null)
			{
				logger.log(EXIT_LOG_LEVEL, "EXIT: " + methodName);
			}
		}
	}

}

