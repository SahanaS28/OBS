package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage
{
	//declaration
	@FindBy(name="staff_id")
	private WebElement StaffID;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(name="staff_login-btn")
	private WebElement Login;
	
	//initialization
	 public StaffLoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }

	//utilization
	public WebElement getStaffID() {
		return StaffID;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin() {
		return Login;
	}
	
	//Business Logic
	public void stafflogin(String STAFF,String PASSWORD)
	{
		StaffID.sendKeys(STAFF);
		Password.sendKeys(PASSWORD);
		Login.click();
		
	}
	
	
	
	

}
