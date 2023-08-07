package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class CreateNewVendorPage extends WebdriverUtility {
//Declaration
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement VendorNameEdt;
	
	@FindBy(xpath="//select[@name='glacct']")
	private WebElement GLAccountDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
// Initialization
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getGLAccountDropDown() {
		return GLAccountDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	// Business library
	/**
	 * This method will create new vendor with mandatory field
	 * @param VENDORNAME
	 */
	public void createVendor(String VENDORNAME)
	{
		VendorNameEdt.sendKeys(VENDORNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create new vendor with GL Account
	 * @param VENDORNAME
	 * @param GLACCOUNT
	 */

	public void createVendor(String VENDORNAME, String GLACCOUNT)
	{
		VendorNameEdt.sendKeys(VENDORNAME);
		handleDropDown(GLAccountDropDown, GLACCOUNT);
		SaveBtn.click();
	}


	
	
	
	
	
	
	
	
	
	
	
}
