package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {

//declaration
	@FindBy(xpath="//a[text()='Home']")
	private WebElement CustomerHome;
	
	@FindBy(name="home")
	private WebElement StaffHome;
	
	@FindBy(name="logout_btn")
	private WebElement StaffLogout;
	
	@FindBy(name="viewdet")
	private WebElement ViewActiveCustomer;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement ViewCustomerbyAccountNumber;
	
	@FindBy(name="apprvac")
	private WebElement ApproveAccount;
	
	@FindBy(name="del_cust")
	private WebElement DeleteAccount;
	
	@FindBy(name="credit_cust_ac")
	private WebElement CreditCustomerAccount;
	
	//initialization
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerHome() {
		return CustomerHome;
	}

	public WebElement getStaffHome() {
		return StaffHome;
	}

	public WebElement getStaffLogout() {
		return StaffLogout;
	}

	public WebElement getViewActiveCustomer() {
		return ViewActiveCustomer;
	}

	public WebElement getViewCustomerbyAccountNumber() {
		return ViewCustomerbyAccountNumber;
	}

	public WebElement getApproveAccount() {
		return ApproveAccount;
	}

	public WebElement getDeleteAccount() {
		return DeleteAccount;
	}

	public WebElement getCreditCustomerAccount() {
		return CreditCustomerAccount;
	}
    
	//Business Logic
	
	public void customerhome()
	{
		CustomerHome.click();
	}
	
	public void staffhome()
	{
		StaffHome.click();
	}
	public void viewActivecustomer()
	{
		
		ViewActiveCustomer.click();
	}
	
	public void viewCustomerbyAccNo()
	{
		ViewCustomerbyAccountNumber.click();
	}
	
	public void approveAccount()
	{
		
		ApproveAccount.click();
	}
	public void creditAccount()
	{
		CreditCustomerAccount.click();
	}
	
	public void logout()
	{
		StaffLogout.click();
	}
	
}
