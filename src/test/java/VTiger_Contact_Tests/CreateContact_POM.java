package VTiger_Contact_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebdriverUtility;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_POM {

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
		
		// step 4-- Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		// step 5-- click on Contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		// step 6-- click on contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// step 7-- create contact with mandatory fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME);
		
		// step 8-- validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(ContactHeader);
		} else {
			System.out.println("Fail");
		}
		
		//Logout
		hp.logoutOfApp(driver);
		System.out.println("Logout successfully");
		

	}

}
