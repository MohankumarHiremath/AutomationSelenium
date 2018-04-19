package com.rb.promise.dataExtraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadTestCaseData {
 
	public  String objectFrom(final HSSFCell cell){
		String cellValue= null;
		try {			
			if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
				cellValue = cell.getRichStringCellValue().toString();
			} else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
				cellValue = Integer.toString((int)cell.getNumericCellValue());
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}finally{
			if(cell == null){
				cellValue = null;
			}
		}
		return cellValue;
	}	
	
	/** Method which returns HasMap with the TestCase name and Field name separated with 
	 *  a delimiter dot, as Key and corresponding data map location file as Value
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, String>[] testCaseData(String sheetName) throws Exception, IOException{		
		Hashtable<String, String>[] CreateUserData = null ;
		try{
			HSSFRow row1 = null;
		    HSSFRow tempRow = null;
		    HSSFSheet hssfSheet = null;		
		    int sheetRows = 0;
		    HSSFCell cell = null;
			File test = new File(System.getProperty("user.dir")+"\\TestData\\TestData.xls");
			FileInputStream fileInputStream = new FileInputStream(test.getAbsoluteFile());
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			hssfSheet = workBook.getSheet(sheetName);			
			sheetRows = hssfSheet.getPhysicalNumberOfRows();		
			String value = null;	
			row1= hssfSheet.getRow(0);			
			CreateUserData = new Hashtable[(sheetRows-1)];
			for(int la=0;la<(sheetRows-1);la++){	
				CreateUserData[la] = new Hashtable<String, String>();
				Hashtable<String, String> dataMaplocation = new Hashtable<String, String>();
			for(int j=1;j<row1.getPhysicalNumberOfCells();j++) {
				tempRow = hssfSheet.getRow(la+1);				
				try {
					cell = tempRow.getCell(j);
				} catch (Exception e) {
						// TODO Auto-generated catch block						
				}finally{
					if(cell == null){
						cell = null;
					}
				}				
				value = objectFrom(cell);
				if(value == null){
					value = " ";
				}
				dataMaplocation.put(row1.getCell(j).getStringCellValue(), value);									
			}			
			CreateUserData[la] = dataMaplocation;				
		 }
	}catch(NullPointerException npe){
		System.out.println("NullPointer Excpeiton " + npe.getCause());	
	}catch(FileNotFoundException fne){
		System.out.println("NullPointer Excpeiton " + fne.getCause());		
	}catch(IOException ioe){
		System.out.println("NullPointer Excpeiton " + ioe.getCause());				
	}
	return CreateUserData;
	}

	public static void main(String[] args) throws IOException, Exception {
		ReadTestCaseData readData = new ReadTestCaseData();
		Hashtable<String, String> [] testData = readData.testCaseData("Login");
		System.out.println(testData.length);
		for (int i=0;i<testData.length;i++)
		System.out.println(testData[i]);
	}
}
