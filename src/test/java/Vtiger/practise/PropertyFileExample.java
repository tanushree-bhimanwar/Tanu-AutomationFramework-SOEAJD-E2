package Vtiger.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileExample {

	public static void main(String[] args) throws Throwable {
		//step 1-- Load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//step2-- Create object of Properties class from java.util
		Properties pro = new Properties();
		
		//step 3-- Load the file into properties class
		pro.load(fis);
		
		// step 4-- provide the key and get the value
		String data = pro.getProperty("url");
		System.out.println(data);
		
	}

}
