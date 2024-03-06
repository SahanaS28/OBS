package genericutils;

import static org.testng.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;

import com.mysql.cj.jdbc.Driver;

public class Baseclass 
{
  public DatabaseUtils dlib=new DatabaseUtils();
  public ExcelUtils elib=new  ExcelUtils();
  public FileUtils flib=new FileUtils();
  public JavaUtils jlib=new JavaUtils();
  public  WebDriverUtils wlib=new WebDriverUtils();
  
  
  public static WebDriver driver;
  public static WebDriver sdriver;
  
  @BeforeSuite(alwaysRun = true)
  public void connectToDB() throws SQLException
  {
	  dlib.connectToDB();
	  System.out.println("--connect to db------");
  }
 //Parameters("BROWSER")
  @BeforeClass(alwaysRun = true)
  public void launchBrowser() throws IOException
  {
	String BROWSER=flib.readDataFromPropetyFile("browser");
	  String URL=flib.readDataFromPropetyFile("url");
	  
	  if(BROWSER.equalsIgnoreCase("chrome"))
	  {
		  driver=new ChromeDriver();
		  System.out.println("chrome browser is launched");
	  }
	  else  if(BROWSER.equalsIgnoreCase("firefox"))
	  {
		  driver=new FirefoxDriver();
		  System.out.println("firefox browser is launched");
	  }
	  else  if(BROWSER.equalsIgnoreCase("edge"))
	  {
		  driver=new EdgeDriver();
		  System.out.println("edge browser is launched");
	  }
	  else
	  {
		  System.out.println("----invalid browser------");
	  }
//	  String exp="chrome";
//	   driver=new ChromeDriver();
//	  assertEquals(BROWSER, exp);
	  
	  wlib.maximizeWindow(driver);
	  driver.get(URL);
	  wlib.waitForPageLoad(driver, 10);
	  
	  sdriver=driver;
  }
  
  @BeforeMethod(alwaysRun = true)
  public void loginToApp() throws IOException
  {

	  System.out.println("login to application");
  }
  @AfterMethod(alwaysRun = true)
  public void logoutfromApp()
  {

	  System.out.println("-----logout from appl----");
  }
  
  @AfterClass(alwaysRun = true)
  public void closebrowser()
  {
	  driver.close();
	  System.out.println("--------browser closed----");
  }
  
  @AfterSuite(alwaysRun = true)
  public void closeDB() throws SQLException
  {
	  dlib.disconnectDB();
	  System.out.println("disconnected from database");
  }
  
  
  
  
  
}
