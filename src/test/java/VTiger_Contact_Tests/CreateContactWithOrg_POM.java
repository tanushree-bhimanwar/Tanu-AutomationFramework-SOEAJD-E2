package VTiger_Contact_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebdriverUtility;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg_POM {

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
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		// Create organization
		// Step 5: Click on Organizations Link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 6: click on Create Organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 7: create Organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		// step 8: validate for organization
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("Organization Created");
			System.out.println(OrgHeader);
		} else {
			System.out.println("Fail");
		}

		/* Create Contact using Organization */

		// step 9: click on contacts link
		hp.clickOnContactsLink();
		
		// Step 10: Navigate to create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// step 11: Create a contact with mandatory information
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);

		// Step 12: Validate for contact
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
