package com.rb.promise.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.rb.promise.dataExtraction.ReadData;
import com.rb.promise.utils.OtherUtils;

public class BaseTest {

	public FileInputStream inputFile = null; 
	public static WebDriver driver;
	public static String Environment;
	public static String BrowserName;
	public static String TestURL;		
	public static String QAURL;		
	public static String URL;		
	
	ReadData readData = new ReadData();
	public static Hashtable<String, String>  LoginTestData = null;
	public static Hashtable<String, String> [] CreateUpdateDeleteSubProjectTestData = null;
	public static Hashtable<String, String> [] CreateUpdateDeleteProjectTestData= null;//RRRRRRRRRR 
	public BaseTest() {
		try {			
				Environment = configValue("Environment");
				BrowserName = configValue("Browser");
										
				URL = configValue("URL");						
				try {					
			    LoginTestData = readData.testData("LoginTestData");	
			    CreateUpdateDeleteSubProjectTestData = readData.testCaseData("CreateUpdateDeleteSubProject");
			    CreateUpdateDeleteProjectTestData=readData.testCaseData("CreateUpdateDeleteProject");//RRRRRRR

						
					
				}catch(NullPointerException npe){
					System.out.println("NullPointer Excpeiton " + npe.getCause());	
				}catch(FileNotFoundException fne){
					System.out.println("NullPointer Excpeiton " + fne.getCause());		
				}catch(IOException ioe){
					System.out.println("NullPointer Excpeiton " + ioe.getCause());				
				}catch(Exception eoe){
					System.out.println("NullPointer Excpeiton " + eoe.getCause());	
				}				
		} catch (Exception e) {
			System.out.println("Exception in base "+e.getMessage());
		}		
	}	
	
	private String configValue(String key) {
		String value = null;
		try {
			value = OtherUtils.readPropertiesFile("config.properties", key);			
		} catch (Exception e) {
			System.out.println("Exception in method configValue "+e.getMessage());
		}
		return value;
	}

	public static void getBrowser()  {
		try {			
//			FF_Killer.kill_FFProcesses();
//			IE_Killer.kill_IEProcess();			
//			GC_Killer.kill_GCProcesses();
			if(BrowserName.equalsIgnoreCase("Firefox")){
				driver = new FirefoxDriver();
			}else if(BrowserName.equalsIgnoreCase("InternetExplorer")){	
//					if(System.getProperty("os.name").equalsIgnoreCase("Windows 7")){
//	                     File exe = new File("Exe/IEDriverServer_x64_2-44-0.exe");
//	                     System.setProperty("webdriver.ie.driver", exe.getAbsolutePath());
//				     }
//				     else if(System.getProperty("os.name").equalsIgnoreCase("Windows XP")){
				         File exe = new File("Exe/IEDriverServer_Win32_2-44-0.exe");
				         System.setProperty("webdriver.ie.driver", exe.getAbsolutePath());
//				     }				
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				    caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(caps);
			}else if(BrowserName.equalsIgnoreCase("GoogleChrome")){
				File input = new File("Exe\\chromedriver_2-21.exe");
				System.setProperty("webdriver.chrome.driver", input.getAbsolutePath());							
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
			}
//			if(Environment.equalsIgnoreCase("Test")){	
//				driver.navigate().to(TestURL);
//			}else if(Environment.equalsIgnoreCase("QA")){
//				driver.navigate().to(QAURL);
//			}else if(Environment.equalsIgnoreCase("UAT")){
//				driver.navigate().to(URL);
//			}
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("Exception in getBrowser "+e.getMessage());
		}		
	}			
}
