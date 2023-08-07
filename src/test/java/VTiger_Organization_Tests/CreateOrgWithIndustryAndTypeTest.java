package VTiger_Organization_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
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

public class CreateOrgWithIndustryAndTypeTest extends BaseClass {
	
	@Test(groups = "SmokeSuit")
	public void createOrgWithIndustryAndType() throws Throwable
	{
	
	/* Read data from Excel data-- Test data */
	String ORGNAME=eUtil.getDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber(); 
	String INDUSTRY=eUtil.getDataFromExcel("Organization", 7, 3);
	String TYPE= eUtil.getDataFromExcel("Organization", 7, 4);

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
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			System.out.println(OrgHeader );

}
	
	@Test
	public void demoTest()
	{
		System.out.println("Demo");
	}
}
