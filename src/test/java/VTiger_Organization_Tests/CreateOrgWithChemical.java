package VTiger_Organization_Tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithChemical {

	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(1000);
		
		// step 1--- Launch browser
		WebDriver driver;
		WebDriverManager.chromedriver();
		driver= new ChromeDriver();
		
       driver.get("http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=3&viewname=0&start=");
        
        // step 2---login to application 
		
        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='submitButton']")).click(); 
    
        // step 3--Navigate to organization link
       driver.findElement(By.linkText("Organizations")).click();
        
        // step 4--click on create org look up img
       driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        
        // step 5--create org with mandatory fields
       String OrgName = "L&T"+random;
        driver.findElement(By.name("accountname")).sendKeys(OrgName);
        driver.findElement(By.className("detailedViewTextBox")).sendKeys("www.L&T.com");
        
        // step 6--select "chemical" in the industry drop down
       WebElement industryDropDown = driver.findElement(By.name("industry"));
       Select sel = new Select(industryDropDown);
      sel.selectByVisibleText("Chemicals");
       
        // step 7--save 
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
      //  step 8--validate
/*       String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("L&T"))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}     */
       
     //    step 9 logout of application
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
