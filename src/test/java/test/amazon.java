package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text()='Samsung']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		int count = 0;
		for (WebElement price1 : price) {
			String p = price1.getText().replace(",", "");
			int p1 = Integer.parseInt(p);
			if (p1 < 30000) {
				System.out.println(ele.get(count).getText()+"--------"+p1);
			}
			count++;
		}
	}

}
