package Vtiger_POM_practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebdriverUtility;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToApplication {

	public static void main(String[] args) throws Throwable {
		//Create object of required Utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebdriverUtility wUtil = new WebdriverUtility();

		WebDriver driver = null;

// step 1-- Read the neccessary data
/* Read data from property file  -- common data*/

String BROWSER=pUtil.getDataFromPropertyFile("browser");
String URL=pUtil.getDataFromPropertyFile("url");
String USERNAME=pUtil.getDataFromPropertyFile("username");
String  PASSWORD=pUtil.getDataFromPropertyFile("password");

/* Read data from Excel data-- Test data */
String LASTNAME=eUtil.getDataFromExcel("Contacts", 4, 2);
String ORGNAME=eUtil.getDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber(); 

// step 2-- driver is acting based runtime data-- runtime polymorphism
if(BROWSER.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	System.out.println(BROWSER+ "----Browser is launched");
}
else if(BROWSER.equalsIgnoreCase("Edge"))
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	System.out.println(BROWSER+ "----Browser is launched");
}
else
{
	System.out.println("Invalid browser name");
}
wUtil.maximizeWindow(driver);
wUtil.waitForElementsToLoad(driver);

// step 3--Load the url
driver.get(URL);
// Step 4: Login to the Application
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/


// way 1 for POM class
       LoginPage lp=new LoginPage(driver) ;
        /*	 lp.getUserNameEdt().sendKeys(USERNAME);
         lp.getUserPasswordEdt().sendKeys(PASSWORD);
         lp.getLoginBtn(); */
    //   driver.findElement(by.)

// way 2 for POM class

         lp.loginToApp(USERNAME, PASSWORD);


	}

}
