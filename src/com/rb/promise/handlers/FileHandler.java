package com.rb.promise.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	public static void writeToFile(String text){		
		try {
			//BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Temp\\Log.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\bosch_workspace\\TestngPromise\\projectID.txt"));
			out.write(text);
			out.close();

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("resource")
	public static String readFromFile(){
		String val="";
		//BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Temp\\Log.txt"));
		BufferedReader read = null;
		try {
			read = new BufferedReader(new FileReader("D:\\bosch_workspace\\TestngPromise\\projectID.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String readStr="";
		while(readStr!=null){
			try {
				val=read.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return val;
	}

}
