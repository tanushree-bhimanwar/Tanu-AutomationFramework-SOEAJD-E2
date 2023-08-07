package VTiger_Organization_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebdriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryAndType_POM {

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
String ORGNAME=eUtil.getDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber(); 
String INDUSTRY=eUtil.getDataFromExcel("Organization", 7, 3);
String TYPE= eUtil.getDataFromExcel("Organization", 7, 4);

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
		
// step 5--click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		
// step 6-- click on organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
// step 7-- create new organization with mandatory field
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY, TYPE);
		
// step 8-- validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("Organization Created");
			System.out.println(OrgHeader);
		} 
		else {
			System.out.println("Fail");
		}

// step 9-- logout of application
		hp.logoutOfApp(driver);
	}

}
