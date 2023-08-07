package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactLookUpImg;
	
//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
// Utilization

	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	//Business library
	public void clickOnCreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}

}
