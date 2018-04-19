package com.rb.promise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class OtherUtils {
	 
	 public static String readPropertiesFile(String fileName, String property){
		 String value = null;
		 try {
			 FileInputStream inputFile = new FileInputStream(new File(".\\Config\\"+fileName));
			 Properties config = new Properties();
			 config.load(inputFile);
			 value = config.getProperty(property);
		} catch (Exception e) {
			System.out.println("Exception in readPropertiesFile "+e.getStackTrace());
		}
		return value;
	 }	        
}
