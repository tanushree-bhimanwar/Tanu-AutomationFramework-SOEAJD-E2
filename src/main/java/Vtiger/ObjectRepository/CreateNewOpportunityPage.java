package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class CreateNewOpportunityPage extends WebdriverUtility {
	// Declaration
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement OpportunityNameEdt;
	
	@FindBy(xpath="//select[@name='related_to_type']")
	private WebElement RelatedToDropDown;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ContactsLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewOpportunityPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return RelatedToDropDown;
	}

	public WebElement getContactsLookUpImg() {
		return ContactsLookUpImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	// Business Library
	/**
	 * This method will create Opportunity with mandatory fields
	 * @param driver
	 * @param OPPORTUNITYNAME
	 * @param LASTNAME
	 * @param RELATEDTO
	 */
	public void createOpportunity(WebDriver driver, String OPPORTUNITYNAME, String LASTNAME, String RELATEDTO)
	{
		OpportunityNameEdt.sendKeys(OPPORTUNITYNAME);
		handleDropDown(RelatedToDropDown, RELATEDTO);
		ContactsLookUpImg.click();
		switchToWindow(driver, "Contacts");
		SearchEdt.sendKeys(LASTNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+LASTNAME+"']")).click();
		switchToWindow(driver, "Potentials");
		SaveBtn.click();
		
		
	}
	
	
	
}
