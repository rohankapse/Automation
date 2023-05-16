package appModule;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constant;
import utility.ExcelUtils;
import utility.TestNG;


public class SignIn_Action extends TestNG {
	
	
	static Logger log = LogManager.getLogger(SignIn_Action.class);
	static LogIn_Page lo;
	static Logout_Action LA;
	

	
	@Parameters("browser")
	@BeforeClass(groups = {"a"})
	public void initElements(String browser, WebDriver driver) {

//		TestNG tn = new TestNG();
	    if(browser.equalsIgnoreCase("chrome")) {
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://192.168.1.102/einsclms/loginpage.aspx");
		driver.manage().window().maximize();

	    }
	    
	   else if((browser.equalsIgnoreCase("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("http://192.168.1.102/einsclms/loginpage.aspx");
			driver.manage().window().maximize();
	    }
	    
	   else {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
			
    }

	@Test(groups = {"a"}, enabled = true)
    public static void Execute(WebDriver driver) throws Exception{
		
		
		 try {
			 
//				TestNG tn = new TestNG();
				
				lo = new LogIn_Page(driver); 
		SignIn_Action.SignIn(1,driver);
		log.info("signin action is compplete");
        Thread.sleep(5000);

      
        Assert.assertTrue(lo.checkLogin());
        log.info("login is successful");
        ExcelUtils.setCellData("pass", 1, 3, Constant.File_TestData);
        log.info("test case is passes");
        SignIn_Action.log_out(driver);
        }
        catch(Exception e){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File(Constant.File_Screenshot + "loginpage_Execute.png"));
        log.info("screenshot is captured");
        ExcelUtils.setCellData("fail", 1, 3, Constant.File_TestData);
        log.info("test case is failed");
        Assert.fail();
        }
   }
	
	@Test(groups = {"a"}, enabled = false)
	 public static void Execute01(WebDriver driver) throws Exception{
			  
		  try {
				  lo = new LogIn_Page(driver);
				SignIn_Action.SignIn(2,driver);
				log.info("signin action is compplete");
		        Thread.sleep(2000);
	        
	        	Assert.assertTrue(lo.checkInvalidlogin());
	        	log.info("invalid login complete");
	            ExcelUtils.setCellData("pass", 2, 3, Constant.File_TestData);
	            log.info("test case is passes");
	            }
	         catch(Exception e) {
	        	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshotFile , new File(Constant.File_Screenshot + "loginpage_Execute01.png"));
	            log.info("screenshot is captured");
	            ExcelUtils.setCellData("fail", 2, 3, Constant.File_TestData);	
	            log.info("test case is failed");
	            Assert.fail();
	            }

	        }
	
	@Test(groups = {"a"}, enabled = false)
	 public static void Execute02(WebDriver driver) throws Exception{
			
		  try {  
				  lo = new LogIn_Page(driver);
				SignIn_Action.SignIn(3,driver);
				log.info("signin action is complete");
			    Thread.sleep(2000);
	       
	            Assert.assertTrue(lo.checkUserName());
	            log.info("invalid login complete");
	            Assert.assertTrue(lo.checkPassword());
	            log.info("test case is passes");
	            ExcelUtils.setCellData("pass", 3, 3, Constant.File_TestData);
	            log.info("test case is passes");
	           
		  }
	        catch(Exception e) {
	        	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshotFile , new File(Constant.File_Screenshot + "loginpage_Execute02.png"));
	            log.info("screenshot is captured");
	            ExcelUtils.setCellData("fail", 3, 3, Constant.File_TestData);
	            log.info("test case is failed");
	            Assert.fail();
	            }

	        }
	
    public static WebDriver SignIn(int row, WebDriver driver) throws Exception{
			

		lo = new LogIn_Page(driver);
		
		for(int i= row;i<=row;i++) {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		String sUserName = ExcelUtils.getCellData(i, 1);
		log.info("username saved in variable from excel");
		String sPassword = ExcelUtils.getCellData(i, 2);
		log.info("password saved in variable from excel");
    	lo.txtbx_UserName(sUserName);
    	log.info("username value taken by textbox");
        lo.txtbx_Password(sPassword);
        log.info("password value taken by textbox");
        lo.btn_LogIn();
        log.info("login button is clicked");
        lo.Togglebox();
        Thread.sleep(1000);
        log.info("Toggle Box is clicked");
        lo.CLMS();
        log.info("CLMS is clicked");
        ArrayList<String> hw = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(hw.get(1));    
        
		}
		return driver;
        
        }
    
	public static WebDriver log_out(WebDriver driver) throws Exception {
		
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/ul/li[1]/ul/li[2]/ul/li[5]/a")).click();
		return driver;
	}
    
	@Parameters("browser")
	@AfterClass
	public void fetchMostRecentTestResult(String browser, WebDriver driver) {
	    
//		TestNG tn = new TestNG();
	    if(browser.equalsIgnoreCase("chrome")) {
	    	driver.quit();

	    }
	    
	   else if((browser.equalsIgnoreCase("firefox"))) {
		   driver.quit();
	    }
	    
	   else {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
		
		
	}

	
}
