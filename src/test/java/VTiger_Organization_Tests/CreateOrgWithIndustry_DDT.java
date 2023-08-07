package VTiger_Organization_Tests;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustry_DDT {

	public static void main(String[] args) throws Throwable {
WebDriver driver=null;
		
		Random r=new Random();
		int random=r.nextInt(1000);
		// step 1-- Read all the necessary data
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
   Sheet sh = book.getSheet("Organization");
   String ORGNAME= sh.getRow(1).getCell(2).getStringCellValue()+random;
   
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	// step 3--Load the url
	driver.get(URL);
	
 		//step 5--Login to application with valid credentials
        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//input[@id='submitButton']")).click(); 
    
 		//step 6--Navigate to Organizations link
        driver.findElement(By.linkText("Organizations")).click();
        
 		//step 7--Click on Create Organization look Up Image
        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        
 		//step 8--Create Organization with Mandatory fields
     
        driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
       
 		//step 9--Select "Chemical" in the industry drop down
        WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
        Select sel1=new Select(industryDropDown);
        sel1.selectByValue("Chemicals");
        
      //step 10-Save 
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
 		//step 8--Verify
        
      String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
         Thread.sleep(3000);
        if(orgHeader.contains(ORGNAME))
        {
     	   System.out.println("Pass");
     	   System.out.println(orgHeader);
        }
        else
        {
     	   System.out.println("Fail");
        }   
 		//step 9--logout of Application
        
 	      WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 	      Thread.sleep(2000);
 	      Actions act = new Actions(driver);
 	      act.moveToElement(AdminImg).perform();
 	     // Thread.sleep(4000);
 	     // driver.findElement(By.xpath("//a[.='Sign Out']")).click();
 	      driver.findElement(By.linkText("Sign Out")).click();
 	      System.out.println("Logout successfuly");
 	            
       
		
	}

}
