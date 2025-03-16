package VMS_Visitor_PO;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestNG;

public class Visitor_MasterNew_PO extends TestNG
{
	
	public Visitor_MasterNew_PO (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Find the Elements
	
	//@FindBy (xpath = "//span[text() ='Visitor']")
	
	@FindBy(xpath="/html[1]/body[1]/form[1]/div[4]/nav[1]/ul[1]/li[4]/a[1]")
	WebElement visitor;
	
//	@FindBy (xpath = "//a[@href = '../Residential/Visitor_Master_New.aspx']")
	@FindBy(xpath="/html[1]/body[1]/form[1]/div[4]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]")
	WebElement masternew;
	
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_TabVisitor_TabContainer_tabGenerateOtp_ContactRB")
	WebElement mobbutton;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_TabVisitor_TabContainer_tabGenerateOtp_txtContactNo")
	WebElement mobno;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_TabVisitor_TabContainer_tabGenerateOtp_txtappid")
	WebElement appid;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_TabVisitor_TabContainer_tabGenerateOtp_linkskips")
	WebElement skipotp;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_TabVisitor_TabContainer_tabGenerateOtp_lnkGenerateOtP")
	WebElement generateotp;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVisitorID")
	WebElement visitid;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVisitDate")
	WebElement visitdate;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVisitTIme")
	WebElement visittime;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVisitorName")
	WebElement visitorname;
	
	@FindBy (xpath = "//select[@id='ctl00_ContentPlaceHolder1_DDLVisitorGender']")
	WebElement gender;
	
	@FindBy (xpath = "//select[@id='ctl00_ContentPlaceHolder1_ddlVisitorCategory']")
	WebElement category;
	
	@FindBy (xpath = "//select[@id='ctl00_ContentPlaceHolder1_ddlVisitorType']")
	WebElement type;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVisitorComingFrom")
	WebElement comingfrom;
	
	@FindBy (xpath = "//select[@id='ctl00_ContentPlaceHolder1_ddlVisitorpupose']")
	WebElement purpose;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtLocation")
	WebElement location;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicalNo")
	WebElement vehicleno;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_lnkItems")
	WebElement items;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtItemname")
	WebElement itemname;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtItemQuantity")
	WebElement itemqty;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_units")
	WebElement itemunits;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtItemBarcodeNo")
	WebElement barcode;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtItemRemark")
	WebElement remarks;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_btnItemSave")
	WebElement itemsave;
	
	@FindBy (xpath = "//img[@src='../img/closebox.png']")
	WebElement itemclose;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_Image1")
	WebElement upload;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_lnkVehicle")
	WebElement vehicletab;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicleNo")
	WebElement tabvehicle;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicleMake")
	WebElement vehiclemake;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicleType")
	WebElement vehicletype;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicleColor")
	WebElement vehicolor;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtVehicleModel")
	WebElement modelno;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txttag")
	WebElement cardtag;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_btnVehicleSave")
	WebElement vehiclesave;
	
	@FindBy (xpath = "//img[@onclick=\"hide('light_Vehicle','fade');\"]")
	WebElement vehicleclose;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txt_enabledate")
	WebElement enabledate;
	
	@FindBy (xpath = "//select[@id='ctl00_ContentPlaceHolder1_Durationddl']")
	WebElement duration;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_btnReadeCard")
	WebElement readcard;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtOwnerNAme1")
	WebElement owner;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_radio1_1")
	WebElement empbtn;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtEmpNAme")
	WebElement employee;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtSocietyNAme")
	WebElement socname;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_txtIntercomNo")
	WebElement  intercom;
	
	@FindBy (xpath = "//input[@id='ctl00_ContentPlaceHolder1_txt_enabledate']")
	WebElement enabledt;
	
	@FindBy (xpath = "//input[@id='ctl00_ContentPlaceHolder1_txt_expirydate']")
	WebElement expirydt;
	
	@FindBy (xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ac_TabContainer_TabMainAccessGroup_gvmaingrp1\"]")
	//@FindBy (xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ac_TabContainer_TabMainAccessGroup_gvmaingrp1\"]")
	WebElement agtable;
	
	@FindBy (xpath ="//a[@id='ctl00_ContentPlaceHolder1_LinkButton5']")
	WebElement generatebtn;

	@FindBy (id = "ctl00_ContentPlaceHolder1_rbtn_active")
	WebElement activebtn;	
	
	//Methods
	
	public void Visitor ()
	{
		visitor.click();
	}
	
	public void VisitorMaster ()
	{
		masternew.click();
	}
	
	public void MobileNo (String mobn)
	{
		mobno.sendKeys(mobn);
	}
	
	public void SkipOTP()
	{
		skipotp.click();
	}
	
	public void VisitorName (String vname)
	{
		if(!vname.isBlank())
		{
		visitorname.sendKeys(vname);
		}
	}
	
	public void Gender (String gendr)
	{
		if(!gendr.isBlank())
		{
			selectmethod(gender, gendr); 	
		}
	}
	
	public void Category (String categ)
	{
		if(!categ.isBlank()) 
		{
			selectmethod(category, categ);
			}
	}
	
	public void Type (String typen)
	{
		if(!typen.isBlank())
		{
			selectmethod(type, typen);	
			}
	}
	
	public void ComingFrom (String coming)
	{
		if(!coming.isBlank()) 
		{
			comingfrom.sendKeys(coming);
		}
	}
	
	public void Purpose (String purpos)
	{
		if(!purpos.isBlank())
		{
			selectmethod(purpose, purpos);
		}
	}
	
	public void Location (String locn)
	{
		if(!locn.isBlank())
		{
			location.sendKeys(locn);
			}
	}
	
	public void VehicleNo (String vehcl)
	{
		if(!vehcl.isBlank())
		{
			vehicleno.sendKeys(vehcl);
		}
	}
	
	public void Items (String itemn, String qtyn, String barcodn, String remarkn) throws InterruptedException
	{
		if(!itemn.isBlank())
		{
		items.click();
		Thread.sleep(300); 
		
		try {
			itemname.sendKeys(itemn); 
			 Thread.sleep(300); 
			 } 
		catch (StaleElementReferenceException e) 
		{	
			itemname.sendKeys(itemn); 
			Thread.sleep(300);	
				 }
		
		if(!qtyn.isBlank())
		{
		itemqty.clear();	
		String[] qty = qtyn.split(" ");
		itemqty.sendKeys(qty[0]);
		Thread.sleep(300);
		itemunits.sendKeys(qty[1]);
		Thread.sleep(300); 
		}
		
		if(!barcodn.isBlank())
		{
		barcode.sendKeys(barcodn);
		Thread.sleep(300);
		}
		
		if(!remarkn.isBlank()) 
		{
		remarks.sendKeys(remarkn);
		Thread.sleep(300);
		}
		itemsave.click();
		Thread.sleep(300);
		itemclose.click();
		Thread.sleep(300); 
		}
	}
	
	public void Vehicle (String vehicleno, String maken, String typen, String colorn, String modeln, String tagno) throws InterruptedException
	{
		if(!vehicleno.isBlank()) 
		{
		vehicletab.click();
		Thread.sleep(300);
		
		if(!maken.isBlank())
		{
		vehiclemake.sendKeys(maken);
		Thread.sleep(300); 
		}
		
		if(!typen.isBlank())
		{
		vehicletype.sendKeys(typen);
		Thread.sleep(300);
		}
		
		if(colorn.isBlank())
		{
		vehicolor.sendKeys(colorn);
		Thread.sleep(300);
		}
		
		if(!modeln.isBlank()) 
		{
		modelno.sendKeys(modeln);
		Thread.sleep(300);
		}
		
		if(!tagno.isBlank())
		{
		cardtag.sendKeys(tagno);
		Thread.sleep(300);
		}
		
		vehiclesave.click();
		Thread.sleep(600);
		
		vehicleclose.click();
		Thread.sleep(300);
		}
	}
	
	public void EnableDate (String enable)
	{
		if(!enable.isBlank())
		{
			String[] datime = enable.split(" ");				
			enabledt.sendKeys(datime[0], Keys.TAB, datime[1]+datime[2] );
		}
	}
	
	public void Duration (String dura)
	{
		selectmethod(duration, dura);
	}
	
	public void ExpiryDate (String expiry)
	{
		expirydt.sendKeys(expiry);
	}
	
	public void Owner (String ownn) throws InterruptedException, AWTException
	{
		if(!ownn.isBlank())
		{
			owner.sendKeys(ownn);
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(4000);			
			}
	}	
	
	
	public void Employee (String ownn) throws InterruptedException, AWTException
	{
		empbtn.click();
		Thread.sleep(200);
		if(!ownn.isBlank())
		{
			employee.sendKeys(ownn);
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(4000);			
			}
	}
	
	
//	public void selectAG(String ag)
//	{
//		selectCheckboxByName(ag,agtable);
//	}
	
	public void SelectAG()
	{
		SelectLastAG(agtable);
	}
	
	
	public void generte()
	{
		generatebtn.click();
	}	
	
	public void MobButton ()
	{
		mobbutton.click();
	}
	
	public void Active()
	{
		activebtn.click();
	}
	
}
