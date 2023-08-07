package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // Rule 1-- create a seperate POM class for every web page
	
	// Rule 2--Identify the web elements using @FindBy, @FindBys, @FindAll
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Rule 3-- create constructor to initialize web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
// Rule 4-- Generate getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Buisness Library----- project specific generic method
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		userPasswordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	

}
