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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg_GU {

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Create organization
		// Step 5: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 7: create Organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		// step 8: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     
		// step 9: validate for organization
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("Organization Created");
			System.out.println(OrgHeader);
		} else {
			System.out.println("Fail");
		}

		/* Create Contact using Organization */

		// step 10: click on contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 11: Navigate to create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step 12: Create a contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();

		// Step 13: switch to child window
		wUtil.switchToWindow(driver, "Accounts");

		// Step 14: search for Organisation
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);

		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath

		// Step 15: switch the control back to parent window
		wUtil.switchToWindow(driver, "Contacts");
		
		// Step 14: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 15: Validate for contact
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(ContactHeader);
		} else {
			System.out.println("Fail");
		}
		
		//Logout
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverActions(driver, AdminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");
		

	}

}
