package VTiger_Organization_Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	
	  @Test(dataProvider="getData")
	    public void createMultipleOrg(String ORG, String INDUSTRY)  throws Throwable {
			
	      /* Read Data from Excel sheet - Test data */
	      String ORGNAME = ORG + jUtil.getRandomNumber();
	      
	      // Step 5: Click on Organizations Link
	      HomePage hp = new HomePage(driver);
	      hp.clickOnOrgLink();

	      // Step 6: click on Create Organization look up image
	      OrganizationsPage op = new OrganizationsPage(driver);
	      op.clickOnCreateOrgLookUpImg();

	      // Step 6: create Organization
	      CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	      cnop.createOrganization(ORGNAME, INDUSTRY);

	      // Step 8: Validate
	      OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	      String OrgHeader = oip.getHeaderText();
	      if (OrgHeader.contains(ORGNAME)) {
	        System.out.println("PASS");
	        System.out.println(OrgHeader);
	      } else {
	        System.out.println("Fail");
	      }

	  
	    }

	    @DataProvider
	    public Object[][] getData() throws Throwable, IOException {
	      return eUtil.readMultipleData("MultipleOrg");
	    }

	  }



