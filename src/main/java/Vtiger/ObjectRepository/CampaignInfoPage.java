package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement CampaignHeaderText;
	
	//initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getCampaignHeaderText() {
		return CampaignHeaderText;
	}
	
	// Business Library
	/**
	 * This method will capture Campaign header text and return it to caller
	 * @return
	 */
	public String getCampaignHeader()
	{
		return CampaignHeaderText.getText();
	}
	

}
