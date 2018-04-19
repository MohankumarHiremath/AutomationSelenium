package com.rb.promise.keywords;

import org.openqa.selenium.WebDriver;

public class Browser{

	/**
	 * Browser Back: Performs Browser back operation on the current web page
	 **/
	public static void browserBack(WebDriver driver){
		try{
			driver.navigate().back();
	}
		catch(Exception e){
			System.out.println("Exception in browserBack" + e.getCause());
		}
	}

	/**
	 * Browser Forward: Forward browser to the next page.
	 */
	public static void browserForward(WebDriver driver){
		try{
		driver.navigate().forward();
		}
		catch(Exception e){
			System.out.println("Exception in browserForward" + e.getCause());
		}
	}

	/**
	 * Browser Refresh:Performs Refresh on the web page.
	 */
	public static void browserRefresh(WebDriver driver){
		try{
		driver.navigate().refresh();
		}
		catch(Exception e){
			System.out.println("Exception in browserRefresh" + e.getCause());
		}
	}

	/**
	 * Browser Title:Retrieves the web page Title.
	 */
	public static String browserTitle(WebDriver driver){
		String title="";
		try{
			title  = driver.getTitle();
		}
		catch(Exception e){
			System.out.println("Exception in browserTitle" + e.getCause());
		}
		return title;
	}

	
}
