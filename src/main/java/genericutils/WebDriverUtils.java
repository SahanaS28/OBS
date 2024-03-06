package genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebDriverUtils 
{
	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver )
	{
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void miniimizeWindow(WebDriver driver )
	{
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public Select dropdownObj(WebElement element)
	{
		Select sel=new Select(element);
		return sel;
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		dropdownObj(element).selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		dropdownObj(element).selectByValue(value);
	}
	/**
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		dropdownObj(element).selectByVisibleText(text);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @throws InterruptedException 
	 */
	public void mouseHover(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
	    act.moveToElement(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
				act.dragAndDrop(src, dst);
	}
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
		
	}
	
	public void rightclick(WebDriver driver,WebElement element )
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKey() throws Throwable 
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	public void enterRelease() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrld)
	{
		driver.switchTo().frame(nameOrld);
	}
		
	public void switchToWindow(WebDriver driver, String expWind)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			if(currentTitle.contains(expWind))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancleAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable 
	{
		
		JavaUtils jlib=new JavaUtils();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+" "+jlib.getSystemDateInFormat()+".png";
		File dst = new File(path);
		String scrpath=dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;
		
		
	}
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	public void scrollByAction(WebDriver driver, int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	
	public String getText(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String text=alt.getText();
		return text;
	}
}
































//Point location = element.getLocation();
//System.out.println(location.getX()+"-----"+location.getY());
//JavascriptExecutor jse = (JavascriptExecutor)driver;
//jse.executeScript("arguments[0].scrollIntoView()", element);
