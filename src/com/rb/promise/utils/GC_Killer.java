package com.rb.promise.utils;

public class GC_Killer {

	 @SuppressWarnings("unused")
	public static void kill_GCProcesses() {   
		 try {
			 String command = "TASKKILL /F /IM \"chrome.exe\"";	
			 String command1 = "TASKKILL /F /IM \"chromedriver_win32_latest.exe\"";	
			 Runtime rt = Runtime.getRuntime();
			 Runtime rt1 = Runtime.getRuntime();
			 Process pr = rt.exec(command);
			 Process pr1 = rt1.exec(command1);
		} catch (Exception e) {
			System.out.println("Exception in while killing GC browser "+e.getStackTrace());
		}
	 }
}
