package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	//Declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement VendorHeaderText;
		
	//initialization
		public VendorInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getVendorHeaderText() {
			return VendorHeaderText;
		}
		
		//Business Library
	
		/**
		 *  This method will capture contact header text and return it to caller
		 * @return
		 */
		public String getVendorHeader()
		{
			return VendorHeaderText.getText();
		}		

}
