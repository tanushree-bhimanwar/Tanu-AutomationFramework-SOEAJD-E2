package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	// Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateNewProductLookUpImg;
	
	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
// Utilization

	public WebElement getCreateNewProductLookUpImg() {
		return CreateNewProductLookUpImg;
	}

	//Business library
	public void clickOnCreateNewProductLookUpImg()
	{
		CreateNewProductLookUpImg.click();
	}
	
	

}
