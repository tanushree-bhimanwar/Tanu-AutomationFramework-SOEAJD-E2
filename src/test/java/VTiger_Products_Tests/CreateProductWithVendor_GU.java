package VTiger_Products_Tests;

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

public class CreateProductWithVendor_GU {

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
		String VendorName = eUtil.getDataFromExcel("Vendors", 1, 2)+jUtil.getRandomNumber();
		
		String ProductName = eUtil.getDataFromExcel("Products", 1, 2)+jUtil.getRandomNumber();
		
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

		// Create vendor
						// step 5: Navigate to vendor link inside more option
						
					WebElement moreOption = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
					Thread.sleep(2000);
						wUtil.mouseHoverActions(driver, moreOption);
						
			//Navigate to products link
						driver.findElement(By.linkText("Products")).click();
						
			//driver.findElement(By.linkText("Products")).click();
			//Click on Create New Product
			//Create new Product with A vendor
			//Choose 303-interest-income in GL Account Drop down
			//Save the product n verify.
						

	}

}
