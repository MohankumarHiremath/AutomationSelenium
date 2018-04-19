package  com.rb.promise.utils;

import java.io.*;

public class IE_Killer{
	
	public static void kill_IEProcess() 
	{
		try{
			String command = "TASKKILL /F /IM \"iexplore.exe\"";	
			String command2 = "TASKKILL /F /IM \"mshta.exe\"";	
//			String command1 = "TASKKILL /F /IM \"IEDriverServerX64.exe\"";
			String command1 = "TASKKILL /F /IM \"IEDriverServer.exe\"";
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec(command);
			Process pr1 = rt.exec(command1);
			Process pr2 = rt.exec(command2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}