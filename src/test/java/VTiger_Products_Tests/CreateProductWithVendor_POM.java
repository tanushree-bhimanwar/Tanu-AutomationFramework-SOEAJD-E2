package VTiger_Products_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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

public class CreateProductWithVendor_POM {

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
		String VENDORNAME = eUtil.getDataFromExcel("Vendors", 1, 2)+jUtil.getRandomNumber();
		String GLACCOUNT=eUtil.getDataFromExcel("Vendors", 1, 3);
		String PRODUCTNAME= eUtil.getDataFromExcel("Products", 1, 2)+jUtil.getRandomNumber();
		
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
				
				// step 4-- Login to application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
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
				if(VendorHeader.contains(VENDORNAME))
				{
					System.out.println("Vendor created");
					System.out.println(VendorHeader );
				}
				else
				{
					System.out.println("Fail");
				}
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
        	if(ProductHeader.contains(PRODUCTNAME))
        	{
        		System.out.println("Product created");
        		System.out.println(ProductHeader);
        	}
        	else
        	{
        		System.out.println("Fail");
        	}
			
		// step 13-- Logout of application
        	hp.logoutOfApp(driver);
        	System.out.println("Logout successfully");
	}

}
