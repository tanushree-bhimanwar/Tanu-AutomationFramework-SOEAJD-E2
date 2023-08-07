package VTiger_Contact_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_DDT {

	public static void main(String[] args) throws Throwable {
WebDriver driver=null;
		
		Random r=new Random();
		int random=r.nextInt(1000);
		// step 1-- Read all the neccessary data
		// Read data from property file-- common data
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pro = new Properties();
		pro.load(fisp);
	String BROWSER = pro.getProperty("browser");
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD= pro.getProperty("password");

	//Read data from Excel sheet-- Test data
        FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\VtigerData.xlsx");
       Workbook book = WorkbookFactory.create(fise);
       Sheet sh = book.getSheet("Contacts");
       String LastName = sh.getRow(4).getCell(2).getStringCellValue()+random;
       String OrgName=sh.getRow(4).getCell(3).getStringCellValue();
       
       //step 2-- Launch the browser- driver is acting based runtime data-Runtime polymorphism
       if(BROWSER.equalsIgnoreCase("chrome"))
       {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
    	   System.out.println(BROWSER+ "Browser Launched");
    	   }
       else if(BROWSER.equalsIgnoreCase("Edge"))
       {
    	   WebDriverManager.edgedriver().setup();
    	   driver=new ChromeDriver();
    	   System.out.println(BROWSER+ "Browser Launched"); 	   
       }
       else
       {
    	   System.out.println("Invalid browser name");
       }
       
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       // step 3-- Load the url
       driver.get(URL);
       
       // step 4--Login to the application
       driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       driver.findElement(By.id("submitButton")).click();
       
     //Step 5: Click on Organizations Link
     		driver.findElement(By.linkText("Contacts")).click();
     		
     //Step 6: click on Create Organization look up image
     		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
     		
     // Step 7: create contact with mandatory field
     		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
     		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(OrgName);
     		
     		//Step 7: save 
    		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    		
    		//Step 8: Validate
    		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    		if(ContactHeader.contains(LastName))
    		{
    			System.out.println("PASS");
    			System.out.println(LastName);
    		}
    		else
    		{
    			System.out.println("Fail");
    		}
    		
    		//Step 9: Logout of Application
    		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    		Actions act = new Actions(driver);
    		act.moveToElement(AdminImg).perform();
    		
    		driver.findElement(By.linkText("Sign Out")).click();
    		
    		System.out.println("Logout successfull");
    		
       

	}

}
