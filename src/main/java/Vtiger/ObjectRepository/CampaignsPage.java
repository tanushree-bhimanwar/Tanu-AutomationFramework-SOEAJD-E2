package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement  CreateCampaignLookUpImg;
	
	//Initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	
	public WebElement getCreateCampaignLookUpImg() {
		return CreateCampaignLookUpImg;
	}
//Business Library
	public void clickOnCreateCampaignLookUpImg()
	{
		CreateCampaignLookUpImg.click();
	}

}
