package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppotunitiesPage {
	
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement OpportunitiesLookUpImg;

	//Initialization
	public OppotunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	// Utilization
	public WebElement getOpportunitiesLookUpImg() {
		return OpportunitiesLookUpImg;
	}
	
	/**
	 * This method will click on Opportunities Look Up image 
	 */
	// Business Library
	public void clickOnOpportunitiesLookUpImg()
	{
		OpportunitiesLookUpImg.click();	
	}
	
	
}
