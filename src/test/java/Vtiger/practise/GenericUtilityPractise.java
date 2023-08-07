package Vtiger.practise;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractise {

	public static void main(String[] args) throws Throwable {
		JavaUtility ju = new JavaUtility();
		int value = ju.getRandomNumber();
		System.out.println(value);
		System.out.println(ju.getSystemDate());
		System.out.println(ju.getSystemDateInFormat());
		
		// property file
		PropertyFileUtility putil = new PropertyFileUtility();
		String brows = putil.getDataFromPropertyFile("browser");
		System.out.println(brows);
		String URL = putil.getDataFromPropertyFile("url");
		System.out.println(URL);
		String UN = putil.getDataFromPropertyFile("username");
		System.out.println(UN);
		String PW = putil.getDataFromPropertyFile("password");
		System.out.println(PW);
		
		//Excel file
		// read data from sheet
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.getDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		
		// write data into sheet
		
		eUtil.writeDataIntoSheet("Demo", 2, 3, "BatMan");
		System.out.println("data updated");
		



		
	}

}
