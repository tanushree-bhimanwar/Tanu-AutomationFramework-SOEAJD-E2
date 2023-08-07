package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	/** This class consist of all Generic methods related to Property file
	 * @author Tanushree  
	 * @throws Throwable 
	 */
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		/** This method reads data from property file based on given key
		 * @parameter key
		 * @return value
		 * @throws Throwable
		 * 
		 */
		
	FileInputStream fis = new	FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String value = pro.getProperty(key);
	return value;
	}

}
