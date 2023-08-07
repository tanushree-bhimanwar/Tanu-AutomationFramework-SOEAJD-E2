package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//Declaration
			@FindBy(xpath="//span[@class='lvtHeaderText']")
			private WebElement ProductHeaderText;
			
		//initialization
			public ProductInfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
      // Utilization
			public WebElement getProductHeaderText() {
				return ProductHeaderText;
			}
			
			//Business Library
			
			/**
			 *  This method will capture contact header text and return it to caller
			 * @return
			 */
			public String getProductHeader()
			{
				return ProductHeaderText.getText();
			}		

			

}
