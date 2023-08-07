package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {// Rule 1-- create a seperate POM class for every web page
	
	//Declaration
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookUpImg;
	
	//Initialization
	public  OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //Utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	// Business Library
	/**
	 * This method will click on create organization Look Up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
	
}
