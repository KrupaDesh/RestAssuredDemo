package com.restassured.get;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ReadConfig {
	
	public static String ExcelPath;

	
	public static File file ;
	public static FileInputStream fis ;
	public static Properties pro;
	public static BufferedReader br;
			
	public static void readConfigs() {
		try {

			br= new BufferedReader(new FileReader("config.properties"));
			Properties pro = new Properties();
			pro.load(br);			

			ExcelPath = pro.getProperty("ExcelPath");
			System.out.println("file Name:" + ExcelPath);

		} catch (Exception e) {
			System.out.println("Error in reading file" + e.getMessage());
		}
	}

}