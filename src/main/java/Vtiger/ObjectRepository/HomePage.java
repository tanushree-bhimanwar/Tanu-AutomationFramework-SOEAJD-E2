package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class HomePage extends WebdriverUtility{
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="More")
	private WebElement MoreLink;
	
	@FindBy(linkText="Vendors")
	private WebElement VendorsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  //Rule 4------Provide getters to access these web elements
	
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	
	public WebElement getMoreLink() {
		return MoreLink;
	}
	

	public WebElement getVendorsLink() {
		return VendorsLink;
	}
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	
	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	// Buisness Library
	/**
	 * This method will click on Organization link
	 */
	public void clickOnOrgLink()
	{
		OrganizationsLink.click();
	
	}
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will click on Vendors link
	 * @param driver
	 * @throws Throwable
	 */
	public void clickOnVendors(WebDriver driver) throws Throwable
	{
		mouseHoverActions(driver, MoreLink);
		Thread.sleep(1000);
		VendorsLink.click();
		
	}
	
	/**
	 * This method will click on Campaigns link
	 * @param driver
	 * @throws Throwable
	 */
	public void clickOnCampaigns(WebDriver driver) throws Throwable
	{
		mouseHoverActions(driver, MoreLink);
		Thread.sleep(1000);
		CampaignsLink.click();
		
	}
	/**
	 * This method will click on Products link
	 */
	public void clickOnProductsLink()
	{
		 ProductsLink.click();
	}
	
	public void clickOnOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverActions(driver, AdministratorImg);
		Thread.sleep(2000);
		SignOutLink.click();
	}
	
}
