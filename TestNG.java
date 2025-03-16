package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;


public class TestNG {

	//1. Method to select from Drop down
	public WebElement selectmethod (WebElement ele,String elename)
	{
		Select objSelect = new Select(ele);
		objSelect.selectByVisibleText(elename);
		return ele;
	}
	
	//2. Method to take Screenshot
	public void Screenshot (WebDriver driver, String filename) throws IOException
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
        FileUtils.copyFile(screenshotFile , new File(Constant.File_Screenshot + filename));
	}

	//3. Method to Highlight an Element
	public void HighlightText (WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
		js.executeScript("arguments[0].style.background='yellow'", ele);
	}

	
	//4. Outer Scroll - 250px
	public void outerscroll250 (WebDriver driver)
	{		
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
	}
	
	//5. Outer Scroll - 500px
	public void outerscroll500 (WebDriver driver)
	{		
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
	}
	
	//6. Last Delete
	public void LastDelete (WebElement tableid) //Table ID with tbody tag
  	{
  		List<WebElement> ele1 = tableid.findElements(By.tagName("tr"));
  		System.out.println(ele1.size());
  		List<WebElement> ele2 = ele1.get(ele1.size()-1).findElements(By.tagName("td"));
  		ele2.get(ele2.size()-1).findElement(By.tagName("input")).sendKeys(Keys.ENTER);
  	}
	
	//7. Last Page
	public void LastPage (WebElement pagetable)
  	{
  		List<WebElement> ele = pagetable.findElements(By.tagName("td"));
  		System.out.println(ele.size());
  		ele.get(ele.size()-1).click();	
  	}

	//8. Last View
	public void LastView (WebElement tableid) //Table ID with tbody tag
  	{
  		List<WebElement> ele1 = tableid.findElements(By.tagName("tr"));
  		System.out.println(ele1.size());
  		List<WebElement> ele2 = ele1.get(ele1.size()-1).findElements(By.tagName("td"));
  		ele2.get(ele2.size()-3).findElement(By.tagName("input")).sendKeys(Keys.ENTER);
  	}
	
	//9. Inner Scroll
	public void InnerScroll (WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollTop = 1200;",ele); 
	}
		
	//10. Check View Enabled
	public boolean CheckView (WebDriver driver, WebElement ele)
	{
		try 
		{
			HighlightText(driver,ele);
			return ele.isEnabled();
		} 
		catch (StaleElementReferenceException e)
		{
			HighlightText(driver,ele);
			return ele.isEnabled();
		}
	}
	
	//11. Check Validation
	public boolean CheckVal (WebDriver driver,WebElement ele)
	{
		try
		{
			HighlightText(driver,ele);
			return ele.isDisplayed();
		} 
		catch (NoSuchElementException e)
		{
			HighlightText(driver,ele);
			return ele.isDisplayed();
		}
	}
	
	//12. Image Upload (Non - Input Tags)
	public void UploadPhoto (String path) throws AWTException, InterruptedException
	{
		 StringSelection ss = new StringSelection(path);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

         Robot robot = new Robot();
         Thread.sleep(300);
         
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         Thread.sleep(500);

         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(500);
	}
	
	//13. Scroll Right
	public void InnerRightScroll (WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollTop = 1000;",ele); 
	}
	
	//14. OuterScroll Back
	public void OuterScrollBack250 (WebDriver driver)
	{
		{		
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-250)", "");
	}
	}
	
	//15. OuterScroll x 
	public void OuterScrollx (WebDriver driver, String px)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+px+" )", "");
	}
	
	//16. OutereScrollBack x
	public void OuterScrollBackx (WebDriver driver, String px)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-"+px+")", "");
	}
	
	//17. Last Edit
	public void LastEdit (WebElement tableid) //Table ID with tbody tag
  	{
  		List<WebElement> ele1 = tableid.findElements(By.tagName("tr"));
  		System.out.println(ele1.size());
  		List<WebElement> ele2 = ele1.get(ele1.size()-1).findElements(By.tagName("td"));
  		ele2.get(ele2.size()-2).findElement(By.tagName("input")).sendKeys(Keys.ENTER);
  	}
	
	//18. Reports Table
	public void ReportsTable (WebElement tableid, String value)
	{
		List<WebElement> lst = tableid.findElements(By.tagName("tr"));
		for(int i = 0; i<lst.size(); i++)
		{
			String check = lst.get(i).findElement(By.tagName("td")).findElement(By.tagName("label")).getText();
			if(value.equals(check))
			{
				lst.get(i).findElement(By.tagName("td")).findElement(By.tagName("input")).click();
				break;
			}
		}
	}
	
	//19. To Convert Format of Date to e.g.- Dec-1-2022 
	public String ConvertDate (String date) throws ParseException
	{  
		Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(date); 
		String check = new SimpleDateFormat("MMM-d-YYYY").format(date1);
		return check;
	}
	
	//20. To Check if Alert is Present in Report - (6 seconds wait)
	public boolean CheckAlert (WebDriver driver, String alert)
	{
		
		try {
			
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(6));		
			wait.until(ExpectedConditions.alertIsPresent());
			
			String alert1 = driver.switchTo().alert().getText();
			
			if(alert1.equals(alert))
			{
				return true;
			} 
			else
			{
				return false;
			}
		} 
		catch (TimeoutException e)
		{
			return false;
		}
	}
		
	//21. To Check if a File is Downloaded
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
			  String check = dirContents[i].getName();
		      if (check.equals(fileName)) {
		          // File has been found, it can now be deleted:
		         // dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
		
	//22. Delete the Downloaded file 
	public void FileDelete (String downloadpath, String filename)
	{
		File dir = new File(downloadpath);
		File[] dirContents = dir.listFiles();
		try {
		for (int i = 0; i < dirContents.length; i++) {
			  String check = dirContents[i].getName();
		      if (check.equals(filename)) {
		          // File has been found, it can now be deleted:
		         dirContents[i].delete();
		      } } } catch (Exception e) {
		    	  e.printStackTrace();      }
	}
	
	
	
	//23. Access Group 
	public void selectCheckboxByName(String name, WebElement table) {	    	   

	    // Find all rows in the table
	    List<WebElement> rows = table.findElements(By.xpath("//table//tr"));
	    
	    for(int i =1; i<=rows.size();i++)
	    {
	        // Find the cells in the current row
	        List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

	        // If the second cell (index 1) contains the name we're looking for,
	        // select the checkbox in the first cell (index 0)
	        if (cells.get(1).getText().equals(name)) {
	            WebElement checkbox = cells.get(0).findElement(By.tagName("input"));
	            checkbox.click();
	            break; // Only select the first checkbox that matches the name
	        }
	    }
	    
	}

		
	//24. Random Number
    public String randomno(int count) {
	        Random rand = new Random();
	        String randomNumber = "";	   
	        for (int i = 1; i < count+1; i++) {
	        	randomNumber = rand.nextInt(i) + randomNumber;	         
	        }
			return (randomNumber);
    
    }


	//25. Current Date Time
	public String DateTimeNow ()
	{
    	
    	LocalDateTime now = LocalDateTime.now();

         // Create a formatter for the desired format
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

         // Format the date and time using the formatter
         String formattedDateTime = now.format(formatter);

         // Print the formatted date and time
         return (formattedDateTime);
	}
	
	//26. Select Last AG
	public void SelectLastAG (WebElement tableid)
	{
		List<WebElement> agl1 = tableid.findElements(By.tagName("tr"));
		List<WebElement> agl2 = agl1.get(agl1.size()-1).findElements(By.tagName("td"));
		agl2.get(0).findElement(By.tagName("input")).click();		
	}
	
	 //27. Random Name
    public String randomname ()
    {
    	Faker faker = new Faker();
    	
    	return (faker.name().fullName()); 
    }
    
    //28. Random Address
    public String randomadd ()
    {
    	Faker faker = new Faker();

    	return (faker.address().fullAddress()); 
    }
	
}
	
	

