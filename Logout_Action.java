package appModule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.TestNG;

public class Logout_Action extends TestNG
{

	public static WebDriver driver;
	static Logger log = LogManager.getLogger(SignIn_Action.class);
	static SignIn_Action si;
	
	@BeforeMethod(groups = {"a"})
	public void initElements() {

		
		//driver = tn.testSetup();
			
    }
	@Test
	public static void execute() throws Exception {
		
		//driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/ul/li[1]/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/ul/li[1]/ul/li[2]/ul/li[5]/a")).click();


//		driver = si.SignIn(1,driver);
//		
//		String id1 = "ctl00_ContentPlaceHolder1_Emp_TabContainer_tabGeneralDetails_ImageButtonDateOfBirth";
//		String id2 = "_content_CalendarExtender1_title";
//		String id3 = "_content_CalendarExtender1_prevArrow";
//		String id4 = "_content_CalendarExtender1_nextArrow";
//		String id5 = "_content_CalendarExtender1_monthsTable";
//		String id6 = "_content_CalendarExtender1_daysTable";
		
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/li[6]/a")).click();
		log.info("employee click");
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/li[6]/ul/li[2]/a")).click();
		log.info("employee master click");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		//selectDate("Dec","25", 2028, id1, id2, id3, id4, id5, id6);
		
		Thread.sleep(5000);
		
		log.debug("employee date ata entered");
	}
	
	public static void selectDate(String month, String select_day, int Check_yearint, WebElement id1, WebElement id2, WebElement id3, WebElement id4, WebElement id5, WebElement id6) throws InterruptedException
	{ 
		
		(id1).click();
		log.info("date is clicked");
		Thread.sleep(1000);
		(id2).click();
		Thread.sleep(2000);

		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String date = formatter.format(d);
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0]; 
		//month1 = splitter[0];
		String year = splitter[2];
//		System.out.println(date);
//		System.out.println(month);		
//		System.out.println(year);
//		System.out.println(month_year);
//		System.out.println(day);
	
		
	WebElement elements = (id2);
	
	WebElement previous = (id3);
	
	WebElement next = (id4);

	//elements.click();
	
	//int check_yearint1 =Integer.parseInt(year);
	outerloop:
	for (int i=0; i<500;i++)
	{
	
		String check_year = elements.getText();
		
		int check_yearint=Integer.parseInt(check_year);
	
				//Selecting the year
		if(check_yearint == Check_yearint)
		{ 

				//Selecting the month
			WebElement table = (id5);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
		
			for(int i1=0; i1<rows.size(); i1++) {
		        List<WebElement> row = rows.get(i1).findElements(By.tagName("td"));
		        int columnCount = row.size();
		        	for(WebElement webelement:row) {
		        		if(columnCount > 0) {
		        				// 0=index id column from table with id 'savings'
		        			String getIDFromTable = webelement.getText();
		        				if(getIDFromTable.equals(month)){
		        					webelement.click();
		        					WebElement day_table = (id6);
		        					List<WebElement> day_rows = day_table.findElements(By.tagName("tr"));
		        						//int day_count = rows.size();
		        					for(int i2=0; i2<day_rows.size();i2++) {
		        						List<WebElement> row1 = day_rows.get(i2).findElements(By.tagName("td"));
		        						int day_columnCount = row1.size();
		        							for(WebElement webelement1:row1) {
		        								if(day_columnCount > 0) {
		        									String getIDFromTable1 = webelement1.getText();
		        									if(getIDFromTable1.equals(select_day)){
		        										webelement1.click();
		        										break outerloop;
		        									}
		        										else {
		        											continue;
		        										}
		        									}
		        									else {
		        										continue;
		        									}
		        								}
		        							}
		        					}
		        					else {
		        						continue;
		        					}
		        				}
		        			}
						}

					} 
					else if(check_yearint >= Check_yearint ) {
						previous.click();
						continue;
					}
	
					else if(check_yearint <= Check_yearint ) {
						next.click();
						continue;
					}

			}
	
		}
	

	
}
