package VTiger_Opportunities_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOpportunityPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OpportunityInfoPage;
import Vtiger.ObjectRepository.OppotunitiesPage;

public class CreateOpportunityWithContatctTest extends BaseClass{
	
	@Test
	public void createOpportunityWithContact() throws Throwable
	{
		//Read data from Excel file
		String LASTNAME=eUtil.getDataFromExcel("Contacts", 1, 2)+jUtil.getRandomNumber();
		String OPPORTUNITYNAME=eUtil.getDataFromExcel("Opportunities", 1, 2)+jUtil.getRandomNumber();
		String RELATEDTO=eUtil.getDataFromExcel("Opportunities", 1, 3);
		
		// create contact
		// step 1-- click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		// step 2-- click on Create contacts Look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// step 3-- create new contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME);
		
		// step 4--validate for contact
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactsHeader=cip.getContactHeader();
		Assert.assertTrue(contactsHeader.contains(LASTNAME));
		System.out.println(contactsHeader);
		
		// Create  opportunity
		// step 5--click on opportunities link
		hp.clickOnOpportunitiesLink();
		
		// step 6-- click on opportunities look up image
		OppotunitiesPage op=new OppotunitiesPage(driver);
		op.clickOnOpportunitiesLookUpImg();
		
		//step 7-- create new opportunity with mandatory fields
		CreateNewOpportunityPage cnop=new CreateNewOpportunityPage(driver);
		cnop.createOpportunity(driver, OPPORTUNITYNAME, LASTNAME, RELATEDTO);
		
		// step 8-- validate for Opportunity
		OpportunityInfoPage oip=new OpportunityInfoPage(driver);
		String opportunityHeader=oip.getOpportunityHeader();
		Assert.assertTrue(opportunityHeader.contains(OPPORTUNITYNAME));
		System.out.println(opportunityHeader);
	}
	

}
