package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class CreateNewOrganizationPage extends WebdriverUtility{
	
	// Rule 1-- create a seperate POM class for every web page
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement TypeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}
	

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//Business Library
	/** 
	 * This method will create Organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create Organization with Industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
	    handleDropDown(IndustryDropDown, INDUSTRY);
	    SaveBtn.click();
		
	}
	
	public void createOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		OrgNameEdt.sendKeys(ORGNAME);
	    handleDropDown(IndustryDropDown, INDUSTRY);
	    handleDropDown(TypeDropDown, TYPE);
	    SaveBtn.click();
		
	}
	
	}
	
	
	


