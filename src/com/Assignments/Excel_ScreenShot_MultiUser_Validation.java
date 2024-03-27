package com.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_ScreenShot_MultiUser_Validation {
		static WebDriver driver;
		//Going Cell by Cell	
		
//	public void beforeLogin() throws IOException, InterruptedException {
		public static void main(String argas[]) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(OrangehrmWebApplicationUrl);
		
		FileInputStream xcel = new FileInputStream("./src/com/Excel/Data/Read/1LogInTest.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(xcel);
		XSSFSheet inputSheet = workBook.getSheetAt(0);
		Row row1=inputSheet.getRow(1);
		String expected_LogInPageText=row1.getCell(0).getStringCellValue();
System.out.println("The Expected LoginPage Text from Excel is:- "+expected_LogInPageText);		
		
	//Actual LoginPanel Text		
		WebElement loginPanel=driver.findElement(By.id("logInPanelHeading"));
		String actual_loginPanelText=loginPanel.getText();
System.out.println("The actual LoginPanel Text obtained from WebApplication is:- "+actual_loginPanelText);		
	//							rc_1_1 || rc_1_2
	//Writing Actual LoginPage Text into Excel
						row1.createCell(1).setCellValue(actual_loginPanelText);
		if(actual_loginPanelText.contains(expected_LogInPageText))
		{
						row1.createCell(2).setCellValue("PASS");
		}
		else {
						row1.createCell(2).setCellValue("FAIL");
		}
System.out.println("The LoginPage validation before login is completed");	
	//rc_1_3				
		String expected_LogInPageTitle=row1.getCell(3).getStringCellValue();
System.out.println("The expected LoginPage Title is:- "+expected_LogInPageTitle);		
	//rc_1_4	|| rc_1_5	
		String actual_LoginPage_Title=driver.getTitle();
	//writing actual login Page Title into Excel
						row1.createCell(4).setCellValue(actual_LoginPage_Title);
		if(actual_LoginPage_Title.equalsIgnoreCase(expected_LogInPageTitle))	
		{
						row1.createCell(5).setCellValue("PASS");
		}
		else {
						row1.createCell(5).setCellValue("FAIL");
		}
System.out.println("The Validation of LoginPage Title is Completed");	
	//rc_1_6	
		String expected_LogInPageUrlAddress=row1.getCell(6).getStringCellValue();
	//rc_1_7 || rc_1_8	
	//Writing actual LoginPage Url into Excel	
		String actual_LogInPageUrlAddress=driver.getCurrentUrl();
						row1.createCell(7).setCellValue(actual_LogInPageUrlAddress);
		if(actual_LogInPageUrlAddress.contains(expected_LogInPageUrlAddress))
		{
						row1.createCell(8).setCellValue("PASS");
		}
		else {
						row1.createCell(8).setCellValue("FAIL");
		}
System.out.println("The Validation of LoginPage Url is completed");
		
	//Entering User credentials into WebApplication
		int rowCount=inputSheet.getLastRowNum();
System.out.println("The Active no.of Rows are :- "+ rowCount);
		for(int rindex=1; rindex<=rowCount; rindex++)
		{
			Row currentRow=inputSheet.getRow(rindex);
			
			String userName=currentRow.getCell(9).getStringCellValue();
			String password=currentRow.getCell(10).getStringCellValue();
			
	//driver is at Login Page itself-- Entering the data into WebApplication
			WebElement userNameElement=driver.findElement(By.id("txtUsername"));
			userNameElement.sendKeys(userName);
			String usernameEntered=userNameElement.getAttribute("value");
			
			WebElement passwordElement=driver.findElement(By.id("txtPassword"));
			passwordElement.sendKeys(password);
			String passwordEntered=passwordElement.getAttribute("value");
		
			driver.findElement(By.className("button")).click();				
			
			List<WebElement>linksList=driver.findElements(By.tagName("a"));
			int linksCount=linksList.size();
System.out.println("The no.of Links on the Current WebPage:- "+linksCount);			
			if(linksCount<10) 
			{	
				
						currentRow.createCell(11).setCellValue("FAIL");
						File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+usernameEntered+" "+passwordEntered +".png"));
						currentRow.createCell(12).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+usernameEntered+" "+passwordEntered +".png");
			}
			if(linksCount==67)
			{
						currentRow.createCell(11).setCellValue("PASS");
						File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+usernameEntered+" "+passwordEntered+".png"));
						currentRow.createCell(12).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+usernameEntered+" "+passwordEntered+".png");
System.out.println("The Validation of UserCredentials with ScreenShots is Completed");			
						
			}
			
			
			
			
		}
		
		FileOutputStream output = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\UserCredentials_Screenshot.xlsx");
		workBook.write(output);

	}	
			
	
	
		
	
		
	
	}
		
	
	
	
	

