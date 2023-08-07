package VTiger_Contact_Tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int random = r.nextInt(100);
		// step 1--Launch Browser
		WebDriver driver;
		WebDriverManager.chromedriver();
		driver= new ChromeDriver();
		
       driver.get("http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=3&viewname=0&start=");
        
		// step 2--Login to application with valid credentials
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
       driver.findElement(By.xpath("//input[@id='submitButton']")).click(); 
   
		// step 3--Navigate to Contacts link
       driver.findElement(By.xpath("//a[text()='Contacts']")).click();
       
		// step 4--Click on Create contact look Up Image
       driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
       
		// step 5--Create Contact with Mandatory fields
       WebElement text = driver.findElement(By.xpath("//select[@name='salutationtype']"));
       Select sel = new Select(text);
       sel.selectByVisibleText("Mrs.");
      
	String firstName="Tanushree"+random;
       driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bhimanwar");
       driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("TCS");
       WebElement data = driver.findElement(By.xpath("//select[@name='leadsource']"));
       Select sel1 = new Select(data);
       sel1.selectByVisibleText("Other");
         
         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("bhimanwartv13@gmail.com");
         
       
		// step 6--Save
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         
       // step 7--verify
         String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
         if(contactName.contains("Bhimanwar Tanushree"))
         {
         	System.out.println("Pass");
         	System.out.println(contactName);
         }
         else
         {
         	System.out.println("fail");
         }
         
		// step 8--logout of Application
         Thread.sleep(4000);
         WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Thread.sleep(4000);
         Actions act = new Actions(driver);
         act.moveToElement(AdminImg).perform();
         Thread.sleep(4000);
         driver.findElement(By.xpath("//a[.='Sign Out']")).click();
         //driver.findElement(By.linkText("Sign Out")).click();
         System.out.println("Logout successfuly");


	}

}
