package VTiger_Products_Tests;

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
import Vtiger.ObjectRepository.CreateNewProductPage;
import Vtiger.ObjectRepository.CreateNewVendorPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.ProductInfoPage;
import Vtiger.ObjectRepository.ProductPage;
import Vtiger.ObjectRepository.VendorInfoPage;
import Vtiger.ObjectRepository.VendorsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithVendor_TestAssert extends BaseClass {
	
	@Test
	public void createProductWithVendor() throws Throwable
	{

	/* Read data from Excel data-- Test data */
	String VENDORNAME = eUtil.getDataFromExcel("Vendors", 1, 2)+jUtil.getRandomNumber();
	String GLACCOUNT=eUtil.getDataFromExcel("Vendors", 1, 3);
	String PRODUCTNAME= eUtil.getDataFromExcel("Products", 1, 2)+jUtil.getRandomNumber();
	
	
			//Create vendor
			// step 5--Click on vendors link inside more drop down
			HomePage hp=new HomePage(driver);
			hp.clickOnVendors(driver);
			
			// step 6-- click on create new vendors look up image
			VendorsPage vp=new VendorsPage(driver);
			vp.clickOnCreateVendorLookUpImg();
			
			// step 7-- create new vendor with GL account
			CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
			cnvp.createVendor(VENDORNAME, GLACCOUNT);
			
			// step 8-- validate for Vendor header
			VendorInfoPage vip = new VendorInfoPage(driver);
			String VendorHeader = vip.getVendorHeader();
		     Assert.assertTrue(VendorHeader.contains(VENDORNAME));
		     
	// create product with vendor
	// step 9-- click on Products link
			hp.clickOnProductsLink();
			
	// step 10-- click on createNewProduct Look up image
		ProductPage pp = new ProductPage(driver);
		pp.clickOnCreateNewProductLookUpImg();
		
	// step 11-- create product with vendor	
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.createProduct(driver, PRODUCTNAME, VENDORNAME);
		
	// step 12-- validate for Product
		ProductInfoPage pip = new ProductInfoPage(driver);
    	String ProductHeader=	pip.getProductHeader();
    	Assert.assertTrue(ProductHeader.contains(PRODUCTNAME));
    	System.out.println( ProductHeader);
    	
	}
}
