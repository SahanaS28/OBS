package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class flipkart 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	///to fetch the data from the webpage and store in excel file
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iphones");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	List<WebElement> name = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.createSheet("phones3");
	
      for(int i=0;i<name.size();i++)
      {
    	  Row row=sh.createRow(i);
    	  for(int j=0;j<1;j++)
    	  {
    		  row.createCell(j).setCellValue(name.get(i).getText());
    		  row.createCell(j+1).setCellValue(price.get(i).getText());
    	  }
      }
			
				FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\test.xlsx");
				wb.write(fout);
				wb.close();

		
	}
}
