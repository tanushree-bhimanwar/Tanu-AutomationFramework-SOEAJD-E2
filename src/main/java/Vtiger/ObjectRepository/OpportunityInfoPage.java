package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	// Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OpprtunityHeadetText;
	
	//Initialization
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getOpprtunityHeadetText() {
		return OpprtunityHeadetText;
	}
	
	// Business Library
	/**
	 *  This method will capture Opportunities header text and return it to caller
	 * @return
	 */
	public String getOpportunityHeader()
	{
		return OpprtunityHeadetText.getText();
	}
	
	
	
	

}
