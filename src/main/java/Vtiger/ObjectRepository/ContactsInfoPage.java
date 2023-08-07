package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Business library
	/**
	 *  This method will capture contact header text and return it to caller
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}
	

}
