package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class book 
{
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
		 driver.findElement(By.xpath("//a[text()='Movies']")).click();
		 driver.findElement(By.xpath("(//div[@class='sc-dv5ht7-0 fiAaps'])[1]")).click();
		;
	}

}
