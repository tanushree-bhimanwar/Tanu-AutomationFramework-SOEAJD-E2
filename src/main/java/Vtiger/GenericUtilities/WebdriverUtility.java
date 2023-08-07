package Vtiger.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/** 
 * This class consists of all the reusable methods realated to 
 * web driver actions
 * @author Tanushree
 *
 */
public class WebdriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	//-------------------------------------------------------------------------
	// wait statements
	
	/**
	 * This method will wait for all the findElement and findElements 
	 * operations to be performed
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for specified element to be visible in DOM 
	 * @param driver
	 * @param element
	 */
	public void waitForElementsToBeVisible(WebDriver driver, WebElement element)
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	//-------------------------------------------------------------------------------------------
	// Drop down handling
	
	/**
	 * This method will handle drop down by using index value
	 * @param element
	 */
	public void handleDropDown(WebElement element, int index)
	{
	Select	sel=new Select(element);
	sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
	Select	sel=new Select(element);
	sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element)
	{
	Select	sel=new Select(element);
	sel.selectByVisibleText(text);;
	}
	
	//----------------------------------------------------------------------------------------
	// Action class methods
	
	/** 
	 * This method will perform mouse hover action on target element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverActions(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will double click anywhere in web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will double click on web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	/**
	 * This method will perform drag and drop actions
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
		
	}
	/**
	 * This method will perform click action anywhere in web page
	 * @param driver
	 */
	public void clickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
		
	}
	
	/**
	 *  This method will perform click action on given web element
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
		
	}
	
	
	/**
	 * This method is used to move the cursor anywhere in web page based on offset values
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	
	public void mouseAcrossWebPage(WebDriver driver, int xOffset, int yOffset )
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOffset, yOffset);
	}
	
	//------------------------------------------------------------------------------------------
	// Scrolling methods
	/**
	 * This method will scroll vertically for 500 pixel
	 * @param driver
	 */
	public void scrollActions(WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0, 500);", "");
	}
	
	/**
	 *  This method will scroll vertically until element reference
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver, WebElement element)
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 int y=element.getLocation().getY();
		 js.executeScript("window.scrollBy(0, "+y+");", element);
		 
		//  js.executeScript("argument[0].scrollIntoView();", element);
	}
	/**
	 * This method will click and hold mouse cursor on anywhere on the web page
	 * @param driver
	 */
	
	public void clickAndHoldAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.clickAndHold().perform();
	}
	
	/**
	 * This method will click and hold mouse cursor on web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	/**
	 * This method will release the control 
	 * @param driver
	 */
	public void releaseAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.release().perform();
		
	}
	/**
	 * This method will release control from web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
		
	}
	
	//-------------------------------------------------------------------------------------------
	// Alert popup
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel confirmation pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter the text in prompt pop up 
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture the Alert message and return to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	//-------------------------------------------------------------------------------------------
	// Frame pop up
	/**
	 * This method will handle frame based on frame index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on value of name or ID attribute
	 * @param driver
	 * @param nameOrID
	 */
	
	public void handleFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/** 
	 * This method will help the control switch back to immediate parent frame 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will help the control switch back to current page
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch selenium control from parent to child or
	 * from child to parent based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		// step 1-- capture all the window IDs
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		// step 2 -- iterate through indivisual IDs
		for(String winID:allWindowIDs)
		{
		
		// step 3--switch to each ID and capture the title
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
		
		// step 4-- compare the title with required reference
		if(currentTitle.contains(partialWinTitle)) {
			break;
		}
	}
	}
	
	/** 
	 * This method will take screen shot and return the path of it
	 * @param driver
	 * @param screenShotName
	 * @return path
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ screenShotName+".png");
		Files.copy(src, dst); // This class is from common IO tool
		
		return dst.getAbsolutePath();// attach the screen shot to extent report 
	}
	
	
	
	
	
	

}
