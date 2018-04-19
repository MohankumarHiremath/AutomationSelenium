package com.rb.promise.utils;

import java.io.*;

public class FF_Killer{
	
	@SuppressWarnings("unused")
	public static void kill_FFProcesses() 
	{
		try{
			String cmd_killFF = "TASKKILL /F /IM \"firefox.exe\"";
			String cmd_killPluginContainer = "TASKKILL /F /IM \"plugin-container.exe\"";
			String cmd_killCrashReporter = "TASKKILL /F /IM \"crashreporter.exe\"";
			Runtime rt = Runtime.getRuntime();
			Process pr1 = rt.exec(cmd_killFF);
			Process pr2 = rt.exec(cmd_killPluginContainer);
			Process pr3 = rt.exec(cmd_killCrashReporter);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}