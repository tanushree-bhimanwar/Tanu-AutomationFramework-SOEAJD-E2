package Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all the basic configuration annotations for 
 * all the common actions
 * @author Tanushree
 *
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebdriverUtility wUtil = new WebdriverUtility();
	
	public WebDriver driver = null;
	
	// Only used for Listeners to take screenshots
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite", "ReggressionSuite"})
	public void beforeSuiteConfig()
	{
		System.out.println("======db connection successfull");
	}
	
//	@Parameters("browser")  //---hold a value
//	@BeforeTest(alwaysRun = true)    //-----------for parallel execution
	@BeforeClass(alwaysRun = true)
	public void beforeClassConfig(/*String BROWSER  */) throws Throwable
	{
		//Read browser name and URL from property File
				String BROWSER = pUtil.getDataFromPropertyFile("browser");
				String URL = pUtil.getDataFromPropertyFile("url");
				
				if (BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println(BROWSER + " === Browser launched ===");

				} else if (BROWSER.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					System.out.println(BROWSER + " === Browser launched ===");
				} else {
					System.out.println("==== invalid Browser name ====");
				}

				wUtil.maximizeWindow(driver);
				wUtil.waitForElementsToLoad(driver);
				
				//Only used for Listeners to take screenshot
				
				sdriver=driver;

				//Load the URL
				driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethodConfig() throws Throwable
	{
		//read username and passowrd from property file
				String USERNAME = pUtil.getDataFromPropertyFile("username");
				String PASSWORD = pUtil.getDataFromPropertyFile("password");
				
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				System.out.println("==== Login Successful ====");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethodConfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
	}
	
//	@AfterTest    //-------------for parallel execution
	@AfterClass(alwaysRun = true)
	public void afterClassConfig()
	{
		driver.quit();
		System.out.println(" ========== Browser Closed ========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuiteConfig()
	{
		System.out.println("======db connection closed");
	}
	

}
