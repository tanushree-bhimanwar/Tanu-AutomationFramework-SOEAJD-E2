package VTiger_Campaigns_Tests;

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
import Vtiger.ObjectRepository.CampaignInfoPage;
import Vtiger.ObjectRepository.CampaignsPage;
import Vtiger.ObjectRepository.CreateNewCampaignPage;
import Vtiger.ObjectRepository.CreateNewProductPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.ProductInfoPage;
import Vtiger.ObjectRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithTypeStatusProductTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createCampaignWithTypeStatusProduct() throws Throwable
	    {
		
		/* Read data from Excel data-- Test data */
		String PRODUCTNAME=eUtil.getDataFromExcel("Products", 1, 2)+jUtil.getRandomNumber();
		String CAMPAIGNNAME=eUtil.getDataFromExcel("Campaigns", 4, 2)+jUtil.getRandomNumber(); 
		String TYPE=eUtil.getDataFromExcel("Campaigns", 4, 3);
		String STATUS=eUtil.getDataFromExcel("Campaigns", 4, 4);
		
		// create product
		
		// step - click on Product link
		HomePage hp=new HomePage(driver);
					hp.clickOnProductsLink();
					
			// step -- click on createNewProduct Look up image
				ProductPage pp = new ProductPage(driver);
				pp.clickOnCreateNewProductLookUpImg();
			
				
			// step 11-- create product with mandatory details
				CreateNewProductPage cnpp = new CreateNewProductPage(driver);
				cnpp.createProduct(PRODUCTNAME);
				
			// step 12-- validate for Product
				ProductInfoPage pip = new ProductInfoPage(driver);
		    	String ProductHeader=	pip.getProductHeader();
		    	Assert.assertTrue(ProductHeader.contains(PRODUCTNAME));
		    	System.out.println( ProductHeader);
		    	
		    	// step-- click on camapaign link
		    	hp.clickOnCampaigns(driver);
		    	
		    	// step-- click on Campaign lookup image
		    	CampaignsPage cp=new CampaignsPage(driver);
		    	cp.clickOnCreateCampaignLookUpImg();
		    	
		    	//step-- create new campaign with Type, status and Product
		    	CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
		    	cncp.createCampaign(driver, CAMPAIGNNAME, TYPE, STATUS, PRODUCTNAME);
		    	
		    	// step-- validate Campaign header info
		    	
		    	CampaignInfoPage cip=new 	CampaignInfoPage(driver);
		    	String CampaignHeader=cip.getCampaignHeader();
		    	Assert.assertTrue(CampaignHeader.contains(CAMPAIGNNAME));
		    	System.out.println(CampaignHeader);
		    	
				

	
				
			/*	Navigate to campaigns link
				Click on Create new campaign
				Create a campaign with following details:
				Choose campaign type as 'Webinar'
				Choose campaign status as 'Active'
				choose a product 
				save campaign and verify */


	}

}
