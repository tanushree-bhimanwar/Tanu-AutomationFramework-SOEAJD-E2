package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebdriverUtility;

public class CreateNewProductPage extends WebdriverUtility{
	// Declaration
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement VendorLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement VendorSearchEdt;
	
	@FindBy(name="search")
	private WebElement VendorSearchBtn;
	
	// Initialization
	public  CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getVendorLookUpImg() {
		return VendorLookUpImg;
	}

	public WebElement getVendorSearchEdt() {
		return VendorSearchEdt;
	}

	public WebElement getVendorSearchBtn() {
		return VendorSearchBtn;
	}
	
	//Business Library
	/**
	 * This method will create Product with mandatory fields
	 * @param PRODUCTNAME
	 */
	
	public void createProduct(String PRODUCTNAME)
	{
		ProductNameEdt.sendKeys(PRODUCTNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create Product with Vendor
	 * @param driver
	 * @param PRODUCTNAME
	 * @param VENDORNAME
	 */
	public void createProduct(WebDriver driver, String PRODUCTNAME, String VENDORNAME)
	{
		ProductNameEdt.sendKeys(PRODUCTNAME);
		VendorLookUpImg.click();
		switchToWindow(driver, "Vendors");
		VendorSearchEdt.sendKeys(VENDORNAME);
		VendorSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).click();
		switchToWindow(driver, "Products");
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}


