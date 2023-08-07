package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateVendorLookUpImg;
	
	//Initialization
	public  VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCreateVendorLookUpImg() {
		return CreateVendorLookUpImg;
	}
	//Business library
	/**
	 * This method will click on createVendorLookUp image
	 */
	public void clickOnCreateVendorLookUpImg()
	{
		CreateVendorLookUpImg.click();
	}
	
	
}
