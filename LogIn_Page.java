package appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestNG;


public class LogIn_Page extends TestNG
{
	
	public LogIn_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"txtUserId\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"lnkLogin\"]")
	WebElement btn_login;
	
	@FindBy(id = "ctl00_lblCompanyAlias")
	WebElement CheckLogin;
	
	@FindBy(id = "lblsignmsg")
	WebElement CheckInvalidLogin;
	
	@FindBy(id = "errUserID")
	WebElement CheckUserName;
	
	@FindBy(id = "errPassword")
	WebElement CheckPassword;
	
	@FindBy(id = "headerbardropdown")
	WebElement toptoggle;
	
	@FindBy(id = "ctl00_A3")
	WebElement clms;
	
	@FindBy (xpath = "/html[1]/body[1]/form[1]/div[4]/div[1]/div[1]/div[4]/a[1]/div[1]")
	WebElement vms;
	
	
//	 private static WebElement element;

    public void txtbx_UserName(String user)
    {
    	username.sendKeys(user);
    }

    public void txtbx_Password(String pass)
    {
		password.sendKeys(pass);
    }

    public void btn_LogIn()
    {
    	btn_login.click();
 	}
     
    public boolean checkLogin()
    {
    	return CheckLogin.isDisplayed();
    }
     
    public boolean checkInvalidlogin()
    {
    	return CheckInvalidLogin.isDisplayed();
    }

    public boolean checkUserName()
    {
    	return CheckUserName.isDisplayed();
    }
     
    public boolean checkPassword()
    {
    	return CheckPassword.isDisplayed();
    }
     
	public void txtbx_UserName1()
	{
		username.clear();
	}
	
	public void Togglebox ()
	{
		toptoggle.click();
	}
	
	public void CLMS ()
	{
		clms.click();
	}
	
	public void VMS ()
	{
		vms.click();
	}
	
	
}
