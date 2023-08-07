package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	// Rule 1-- create a seperate POM class for every web page
	
			// Rule 2--Identify the web elements using @FindBy, @FindBys, @FindAll
	@FindBy(className="dvHeaderText")
	private WebElement OrgHeaderText;
	
	// Rule 3-- create constructor to initialize web elements
	public OrganizationInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	// Rule 4-- Provide Getters to access these web elements

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	
	}
	
}
