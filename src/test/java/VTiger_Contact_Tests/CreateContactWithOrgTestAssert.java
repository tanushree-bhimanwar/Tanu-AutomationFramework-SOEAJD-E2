package VTiger_Contact_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
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
import Vtiger.practise.GenericUtilityPractise;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(Vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrgTestAssert extends BaseClass {
	@Test(groups="SmokeSuite")
	public void createContactWithOrg() throws Throwable
	{
		
/* Read data from Excel data-- Test data */
String LASTNAME=eUtil.getDataFromExcel("Contacts", 4, 2);
String ORGNAME=eUtil.getDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber(); 

		
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
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println( OrgHeader );

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
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader );
		
	}
	
	@Test
	public void demoTest()
	{
		System.out.println("demo");
	}

}
