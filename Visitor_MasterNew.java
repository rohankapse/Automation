package VMS_Visitor;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import VMS_Visitor_PO.Visitor_MasterNew_PO;
import appModule.BaseClass;
import appModule.SignIn_Action;
import utility.Constant;
import utility.ExcelUtils;

public class Visitor_MasterNew extends BaseClass
{

	static Visitor_MasterNew_PO vm;
		
	static String Ex1 = "Visitor Details Registered Successfully!";	
	static String Ex2 = "";
	
//	static int row = 1;
	
	@Test (dataProvider= "ExcelData1")
	public void insertdata (int row) throws Exception
	{
		
	try
	 {
		vm = new Visitor_MasterNew_PO(driver); 
		SignIn_Action.SignIn(1,driver);
		
		ExcelUtils.setExcelFile(Constant.Path_TestData2 + Constant.Visitor_TestData ,"Master");
		ArrayList<String> ar = new ArrayList<String>();
		
		for(int i=1;i<=25;i++)
		{
			ar.add(ExcelUtils.getCellData(row, i));
		}
		
		
		vm.Visitor();
		Thread.sleep(300);
		
		vm.VisitorMaster();
		Thread.sleep(300);
		
		vm.MobButton();
		Thread.sleep(300);
		
		vm.MobileNo(vm.randomno(10));
		Thread.sleep(300);
		
		vm.SkipOTP();
		Thread.sleep(800); //time require before scroll
		
		vm.OuterScrollBack250(driver);
		Thread.sleep(300);
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		vm.VisitorName(vm.randomname());
		Thread.sleep(300);
		
		vm.Gender(ar.get(1));
		Thread.sleep(300);
		
		vm.Category(ar.get(2));
		Thread.sleep(500);
		
		vm.Type(ar.get(3));
		Thread.sleep(300);
		
		vm.Purpose(ar.get(5));
		Thread.sleep(300);		
				
		vm.VehicleNo(ar.get(7));
		Thread.sleep(300);
		
		vm.ComingFrom(ar.get(4));
		Thread.sleep(300);
	
		vm.Location(ar.get(6));
		Thread.sleep(300);
		
		vm.Items(ar.get(8), ar.get(9), ar.get(10), ar.get(11));
		Thread.sleep(300);
		
		vm.Vehicle(ar.get(7),ar.get(12), ar.get(13), ar.get(14), ar.get(15), ar.get(16));
		Thread.sleep(300);		
		
		vm.outerscroll500(driver);
		Thread.sleep(300);
		
		vm.EnableDate(vm.DateTimeNow());
		Thread.sleep(300);
		
		vm.Duration(ar.get(17));
		Thread.sleep(300);
		
		//vm.outerscroll250(driver);

		vm.SelectAG();	
		Thread.sleep(1000);
		
		vm.Active();
		Thread.sleep(300);
		
		vm.outerscroll500(driver);		
		Thread.sleep(300);			
		
		//vm.Owner(ar.get(19));
		vm.Employee(ar.get(19));
		Thread.sleep(300);
		
		vm.outerscroll500(driver);
		Thread.sleep(500);
		
		vm.generte();
		Thread.sleep(500);
		
		//vm.outerscroll500(driver);
		//Thread.sleep(5000);		
		
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		String alert =driver.switchTo().alert().getText();

	if(alert.equals(Ex1))
		{
		//	log.info("Test case passed");
				
			driver.switchTo().alert().accept();
			ExcelUtils.setCellData("Pass", row, 5, Constant.Master_TestData);
			Thread.sleep(4000);
			
		//	driver.switchTo().newWindow(WindowType.TAB);
			Thread.sleep(4000);
			Assert.assertTrue(true);
		} 
	 
	else{
		
		//	log.info("Test case failed");
	     	vm.Screenshot(driver, "VisitorM.png");
        //	vm.Screenshot(driver, "Indenting-delete.png");
		//	log.info("Screenshot captured");
			ExcelUtils.setCellData("Fail", row, 5, Constant.Master_TestData);
			Assert.fail();
		}
 }	
catch(Exception e)
	{
	//	log.info("Test case failed");
     	vm.Screenshot(driver, "VisitorM.png");
    //	vm.Screenshot(driver, "Indenting-delete.png");
	//	log.info("Screenshot captured");     	
     	e.printStackTrace();
		ExcelUtils.setCellData("Failed in Exception", row, 5, Constant.Master_TestData);
		Assert.fail();	
		
	
		}
	
	}
}
