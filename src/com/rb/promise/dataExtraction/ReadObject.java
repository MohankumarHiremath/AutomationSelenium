package com.rb.promise.dataExtraction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadObject {	
	
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public static HashMap getModulesobject( String sheetName) throws IOException
			{
			 FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\ObjectRepository\\samp.xlsx");
					 HashMap objects = new HashMap();
			 if (file != null) {				
					XSSFWorkbook wb = new XSSFWorkbook(file);
					XSSFSheet sheet = wb.getSheet(sheetName);
					int rowsize = sheet.getLastRowNum();
					for(int i =1; i <=rowsize;i++)
					{
						XSSFRow rowi = sheet.getRow(i);
						XSSFCell cellij = rowi.getCell(0); 
						String strCellvalue0 = cellij.getStringCellValue();
						XSSFCell celli = rowi.getCell(1); 
						String strCellvalue = celli.getStringCellValue();					
						objects.put(strCellvalue0, strCellvalue);
					}
			    }
				return objects;
		}
	 public static String getPageObject(String sheetName, String objectName){		
			String locator = null;
			try {				
				HashMap<String,String> object = new HashMap<String,String>();
				object = getModulesobject(sheetName);
				locator =  object.get(objectName).toString();
			} catch (IOException e) {
				System.out.println("Exception in getLoginPageObject Method "+e.getMessage());
			}			
			System.out.println(locator);
			return locator;
		}
	
	
	 public static String getCommonPageObject(String objectName){		
			String locator = null;
			try {
				@SuppressWarnings("rawtypes")
				HashMap<String,String> object = new HashMap<String,String>();
				object = getModulesobject("CommonObjects");
				locator =  object.get(objectName).toString();
			} catch (IOException e) {
				System.out.println("Exception in getLoginPageObject Method "+e.getMessage());
			}			
			System.out.println(locator);
			return locator;
		}
	 
	 public static void main(String[] args) {
		 ReadObject.getPageObject("ProjectPageObjects", "ProForwardToPMBtn");
		
		System.out.println(ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
	}
}

