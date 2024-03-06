package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccountNumberPage 
{
	
	//declaration
	@FindBy(name="account_no")
	private WebElement CustomerAccNO;
	
	@FindBy(name="submit_view")
	private WebElement Submit;
	
	
	//initialization
	
	public ViewCustomerByAccountNumberPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

//utilization
	public WebElement getCustomerAccNO() {
		return CustomerAccNO;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	//Business Logic
	public void viewCustByAccNo(String AccNo)
	{
		CustomerAccNO.sendKeys(AccNo);
		Submit.click();
	}

}
