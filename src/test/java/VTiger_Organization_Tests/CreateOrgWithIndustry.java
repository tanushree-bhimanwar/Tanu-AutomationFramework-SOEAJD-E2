package VTiger_Organization_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;


@Test(groups = "ReggressionSuite")
public class CreateOrgWithIndustry extends BaseClass {
	@Test
	public void createOrgWithIndustryTest() throws Throwable
	{
		
	
	
		/* Read data from Excel data-- Test data */
		String ORGNAME=eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber(); 
		String INDUSTRY=eUtil.getDataFromExcel("Organization", 4, 3);
				
		// step 5--click on organization link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLink();
				
		// step 6-- click on organization look up image
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
		// step 7-- create new organization with mandatory field
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME, INDUSTRY);
				
		// step 8-- validate
				
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String OrgHeader = oip.getHeaderText();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
}		

@Test
public void sample()
{
	System.out.println("Sample");
}

}
