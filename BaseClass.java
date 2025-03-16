package appModule;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{

	static protected Logger log = LogManager.getLogger(BaseClass.class);
	public static WebDriver driver;
		
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest extest;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"b"})
	public void initElements(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
		  //WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
		    Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("autofill.profile_enabled", false);
		    options.setExperimentalOption("prefs", prefs);
		  //options.addArguments("--headless=new");
		    options.addArguments("ignore-ssl-errors=yes");
		    options.addArguments("ignore-certificate-errors");
		    options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options);			
			
//			driver=new ChromeDriver();
			driver.get("http://192.168.1.121/HOME/loginpage.aspx");
			driver.manage().window().maximize();

		    }
		    
		   else if((browser.equalsIgnoreCase("firefox")))
		   {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				driver.get("http://192.168.1.121/HOME/loginpage.aspx");
				driver.manage().window().maximize();		
		    }
		    
		   else {
		         throw new IllegalArgumentException("The Browser Type is Undefined");
		      }		
    }
	
	@Parameters("browser")
	@AfterMethod
	public void fetchMostRecentTestResult(String browser)
	{
	    
		 if(browser.equalsIgnoreCase("chrome"))
		 {
	    	driver.quit();
	    }
	   else if((browser.equalsIgnoreCase("firefox")))
	   {
		   driver.quit();
	   }
	   else 
	   {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
	}
	
	@DataProvider(name = "ExcelData1")
	public static Object[][] iterations1 ()
	{
		return new Object[][] {{1}};
	}

	
	@DataProvider(name="ExcelData2")
	public static Object[][] iterations2()
	{
		return new Object[][] {{1},{2}};
	}
	

	@DataProvider(name = "ExcelData3")
	public static Object[][] iterations3 ()
	{
		return new Object[][] {{1},{2},{3}};
	}
	
	
	@DataProvider(name = "ExcelData4")
	public static Object[][] iterations4 ()
	{
		return new Object[][] {{1},{2},{3},{4}};
	}
	

	@DataProvider(name = "ExcelData5")
	public static Object[][] iterations5 ()
	{
		return new Object[][] {{1},{2},{3},{4},{5}};
	}

	@DataProvider(name = "ExcelData6")
	public static Object[][] iterations6 ()
	{
		return new Object[][] {{1},{2},{3},{4},{5},{6}};
	}

	
	@BeforeTest
	public void startReport()
	{
		
       // Create an object of Extent Reports
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/CLMSExtentReport.html");
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host Name", "Automation Testing");
        extent.setSystemInfo("Environment", "Testing");
        extent.setSystemInfo("Eins", "VMS");
        
        spark.config().setDocumentTitle("Eins VMS Test Automation Report");
        
        // Name of the report
        spark.config().setReportName("VMS Automation Report");
        
        // Dark Theme
        spark.config().setTheme(Theme.DARK);
	
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}	
	
}
