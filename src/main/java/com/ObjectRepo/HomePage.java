package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutils.WebDriverUtils;



public class HomePage extends WebDriverUtils

{
	//declaration
	@FindBy(xpath="//a[text()='Home']")
	private WebElement Home;
	
	@FindBy(xpath="//a[text()='About Us']")
	private WebElement AboutUS;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement ContactUs;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement StaffLogin;
	
	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement OpenAccount;
	
	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement ApplyDebitCard;
	
	@FindBy(partialLinkText = "Internet Banking")
	private WebElement InternetBanking;
	
	@FindBy(xpath="//li[text()='Register']")
	private WebElement Register;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement IBLogin;
	
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement FundTransfer;
	
	
	
	
	
	//initialization
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization


	public WebElement getHome() {
		return Home;
	}

	public WebElement getAboutUS() {
		return AboutUS;
	}

	public WebElement getContactUs() {
		return ContactUs;
	}

	public WebElement getStaffLogin() {
		return StaffLogin;
	}


	public WebElement getOpenAccount() {
		return OpenAccount;
	}


	public WebElement getApplyDebitCard() {
		return ApplyDebitCard;
	}

	public WebElement getInternetBanking() {
		return InternetBanking;
	}

	public WebElement getRegister() {
		return Register;
	}


	public WebElement getIBLogin() {
		return IBLogin;
	}

	public WebElement getFundTransfer() {
		return FundTransfer;
	}
	
	//Business Logic
	
	public void Home()
	{
		Home.click();
	}
	
	public void openAccount()
	{
		OpenAccount.click();
	}
	public void staffLogin()
	{
		StaffLogin.click();
	}
	public void applyDebitCard()
	{
		ApplyDebitCard.click();
	}
	public void Register(WebDriver driver) 
	{
		mouseHover(driver,InternetBanking); 
		Register.click();

	}
	public void FundTransfer()
	{
		FundTransfer.click();
	}
	public void IBLogin(WebDriver driver) 
	{
		mouseHover(driver,InternetBanking); 
		IBLogin.click();
	}
	
	public void ContactUs()
	{
		ContactUs.click();
	}

}
