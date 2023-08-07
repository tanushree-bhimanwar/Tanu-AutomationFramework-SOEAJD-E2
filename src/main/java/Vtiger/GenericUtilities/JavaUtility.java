package Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class is consist of all Generic Methods related to java
 * @author Tanushree
 *
 */

public class JavaUtility {
/**
 * This method will return a random number for every execution
 * @return
 */
	public int getRandomNumber() {
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
		
	}
	public String getSystemDate()
	{
		/**
		 * This method will generate System date
		 */
		Date d = new Date();
		String date = d.toString();
		return date;
		
	}
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		return currentDate+"_"+month+"_"+year+"_"+time;
			
	}
		
}
