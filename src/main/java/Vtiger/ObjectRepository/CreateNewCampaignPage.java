package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class CreateNewCampaignPage extends WebdriverUtility {
// Declaration
	@FindBy(name="campaignname")
	private WebElement CampaignNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="campaigntype")
	private WebElement CampaignTypeDropDown;
	
	@FindBy(name="campaignstatus")
	private WebElement CampaignStatusDropDown;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ProductLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement ProductSearchEdt;
	
	@FindBy(name="search")
	private WebElement ProductSearchBtn;
	
// Initialization
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	public WebElement getCampaignNameEdt() {
		return CampaignNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCampaignTypeDropDown() {
		return CampaignTypeDropDown;
	}

	public WebElement getCampaignStatusDropDown() {
		return CampaignStatusDropDown;
	}
	
public WebElement getProductLookUpImg() {
		return ProductLookUpImg;
	}

	// Business Library
/**
 * This method will create Campaign with mandatory fields
 * @param CAMPAIGNNAME
 */
	public void createCampaign(String CAMPAIGNNAME )
	{
		CampaignNameEdt.sendKeys(CAMPAIGNNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create Campaign with Type, Status and Product
	 * @param driver
	 * @param CAMPAIGNNAME
	 * @param TYPE
	 * @param STATUS
	 * @param PRODUCTNAME
	 */
	public void createCampaign(WebDriver driver, String CAMPAIGNNAME, String TYPE, String STATUS, String PRODUCTNAME)
	{
		CampaignNameEdt.sendKeys(CAMPAIGNNAME);
		handleDropDown(CampaignTypeDropDown, TYPE);
		handleDropDown(CampaignStatusDropDown, STATUS);
		ProductLookUpImg.click();
		switchToWindow(driver, "Products");
		ProductSearchEdt.sendKeys(PRODUCTNAME);
		ProductSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+PRODUCTNAME+"']")).click();
		switchToWindow(driver, "Campaigns");
		SaveBtn.click();
	}
	

	
	

	
}
