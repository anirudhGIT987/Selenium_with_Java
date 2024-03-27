package com.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Excel_multi_UserCredentials_Login_Test {
	
	//public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		FileInputStream orangehrm_Login_InputTestData;
		XSSFWorkbook workBook;
		XSSFSheet inputDataSheet;
		
		
		
		
		@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(OrangehrmWebApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	@Test(priority=1, description="Validating User Credentials")
	public void logIn() throws IOException {
		
		orangehrm_Login_InputTestData = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\1LogInTest.xlsx");
		workBook = new XSSFWorkbook(orangehrm_Login_InputTestData);
		inputDataSheet = workBook.getSheetAt(0);
	
		Row row1=inputDataSheet.getRow(1);
		Cell rc_1_0=row1.getCell(0);
		String expected_LoginPanel_Text=rc_1_0.getStringCellValue();
System.out.println("The expected LoginPanel Text obtained from Excel File is:- "+expected_LoginPanel_Text);
		
		By loginPanel_Property=By.id("logInPanelHeading");
		WebElement loginPanel=driver.findElement(loginPanel_Property);
		String actual_loginPanelText=loginPanel.getText();
System.out.println("The actual LoginPanel Text obtained from WebApplication is:- "+actual_loginPanelText);		

//Writing Actual LoginPanel Text into Excel File					
					Cell rc_1_1=row1.createCell(1);
					rc_1_1.setCellValue(actual_loginPanelText);
				
		if(actual_loginPanelText.contains(expected_LoginPanel_Text))
		{
					Cell rc_1_2=row1.createCell(2);
					rc_1_2.setCellValue("PASS");
System.out.println("Successfully Navigated to the OrangeHrm WebPage:- Pass");		
		}
		else {
					Cell rc_1_2=row1.createCell(2);
					rc_1_2.setCellValue("FAIL");
System.out.println("Failed to Navigate to OrangeHrm WebPage:- FAIL");			
		}
//OHRM Page TITLE		
		Cell rc_1_3=row1.getCell(3);
		String expected_LogInPage_Title=rc_1_3.getStringCellValue();
		String actual_LogInPage_Title=driver.getTitle();
System.out.println("THe actual LoginPage Title of OrangeHRM is :- "+actual_LogInPage_Title);		
//Writing OHRM Title into Excel
					Cell rc_1_4=row1.createCell(4);
					rc_1_4.setCellValue(actual_LogInPage_Title);
				
//Result Status				
		if(actual_LogInPage_Title.equalsIgnoreCase(expected_LogInPage_Title))
		{
					Cell rc_1_5=row1.createCell(5);
					rc_1_5.setCellValue("PASS");					
System.out.println("Successfully Navigated to the OrangeHrm WebPage:- Pass");			
		}
		else {
					Cell rc_1_5=row1.createCell(5);
					rc_1_5.setCellValue("FAIL");
System.out.println("Failed to Navigate to OrangeHrm WebPage:- FAIL");				
		}
		
		Cell rc_1_6=row1.getCell(6);
		String expectedLoginpageUrlAddress=rc_1_6.toString();
System.out.println("The expected OrangeHrm Url address from Excel is:- "+expectedLoginpageUrlAddress);		
		String actualLoginPageUrlAddress=driver.getCurrentUrl();
					row1.createCell(7).setCellValue(actualLoginPageUrlAddress);
	if(actualLoginPageUrlAddress.contains(expectedLoginpageUrlAddress))	
		{
					Cell rc_1_8=row1.createCell(8);
					rc_1_8.setCellValue("PASS");					
System.out.println("Successfully Navigated to the OrangeHrm WebPage:- Pass ||WebPage URL ");
	}
	else {
					Cell rc_1_8=row1.createCell(8);
					rc_1_8.setCellValue("FAIL");					
System.out.println("Failed to Navigate to OrangeHrm WebPage:- FAIL || WebPage Url");	
		}
System.out.println();

				//Moving into UserNames, Passwords and Employee ID's
		
		int rowCount=inputDataSheet.getLastRowNum();
		System.out.println("Active Row Count is:- "+rowCount);
		int cellCount=row1.getLastCellNum();
		System.out.println("Active Cell Count in a row is: "+cellCount);
				
			//List<String> = new ArrayList<>();
			//List<String>password = 
	//creating two lists for two datas and creating a lopp for(i=0;i<uname.size;i++)

		//List<String>userName = new ArrayList<>();//sometimes unable to import
		//List<String>password = new ArrayList<>();
			
		for(int rowindex=1; rowindex<=rowCount;rowindex++)
		{
			Row currentRow=inputDataSheet.getRow(rowindex);
			
			String userName=currentRow.getCell(9).getStringCellValue();
			String password=currentRow.getCell(10).getStringCellValue();
			
//Entering the Credentials after storing the values from excel into respective single strings			
			WebElement userNameElement=driver.findElement(By.id("txtUsername"));
			userNameElement.sendKeys(userName);
			String usernameEntered=userNameElement.getAttribute("value");
			
			WebElement passwordElement=driver.findElement(By.id("txtPassword"));
			passwordElement.sendKeys(password);
			String passwordEntered=passwordElement.getAttribute("value");
		
			driver.findElement(By.className("button")).click();
			String urlAddress=driver.getCurrentUrl();

//Validating the Credentials  with Current URL			
			if(urlAddress.contains("validateCredentials"))
			{	
					Cell rc_1_11=currentRow.createCell(11);
					rc_1_11.setCellValue("FAIL");
System.out.println("Username Entered in WebApplication:- "+usernameEntered);
System.out.println("Password Entered in WebApplication "+passwordEntered);
					File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+usernameEntered+" "+passwordEntered +".png"));
					currentRow.createCell(12).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+usernameEntered+" "+passwordEntered +".png");


System.out.println("The Invalid UserName & Password combination is:- "+usernameEntered +" || "+passwordEntered);
			}
System.out.println();
			
			if(urlAddress.contains("dashboard"))
	{
					Cell rc_1_11=currentRow.createCell(11);
					rc_1_11.setCellValue("PASS");
					File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+usernameEntered+" "+passwordEntered+".png"));
					currentRow.createCell(12).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+usernameEntered+" "+passwordEntered+".png");
System.out.println("The Validation of UserCredentials with ScreenShots is Completed");			
System.out.println("Username Entered in WebApplication:- "+usernameEntered);
System.out.println("Password Entered in WebApplication "+passwordEntered);

System.out.println("The VALID Username & Password Combination is:- "+usernameEntered+" || "+passwordEntered);
//Validating Admin element text after Logging In with Valid Credentials		

			Cell cell_12_Login_Admin_Text=row1.getCell(12);
			String RC_1_12=cell_12_Login_Admin_Text.toString();
//System.out.println(RC_1_12);		
		By admin_Link_Prop=By.linkText("Admin");
		WebElement admin_Link=driver.findElement(admin_Link_Prop);
		String 	actual_Admin_Link_Text=admin_Link.getText();
					
					Cell cell_13_Login=currentRow.createCell(13);
					cell_13_Login.setCellValue(actual_Admin_Link_Text);
		if(actual_Admin_Link_Text.equals(RC_1_12))
		{
					Cell cell_14=currentRow.createCell(14);
					cell_14.setCellValue("PASS");		
		}
		else {
					Cell cell_14=currentRow.createCell(14);
					cell_14.setCellValue("FAIL");		
		}
		
		
		
	}
		}			
		FileOutputStream login_Logout_TestResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\Excel_OrangeHrmLogin_Logout_TestResult.xlsx");
		workBook.write(login_Logout_TestResult);
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//Logging Out from the OrangeHrm Account 	
		By welcome_Admin_Prop=By.className("panelTrigger");
		WebElement welcome_Admin=driver.findElement(welcome_Admin_Prop);
		welcome_Admin.click();
		Thread.sleep(2500);

		By logout_prop=By.linkText("Logout");
		WebElement logout=driver.findElement(logout_prop);
		logout.click();		

//After Logging Out Validating for LoginPanel again
		Cell cell_15_Login_LoginPanel=row1.getCell(15);
		String rc_1_15=cell_15_Login_LoginPanel.toString();
//System.out.println(rc_1_15);
		
		loginPanel_Property=By.id("logInPanelHeading");
		loginPanel=driver.findElement(loginPanel_Property);
		actual_loginPanelText=loginPanel.getText();
					Cell cell_16_Login=currentRow.createCell(16);
					cell_16_Login.setCellValue(actual_loginPanelText);
		if(actual_loginPanelText.contains(rc_1_15))
		{
					Cell rc_1_17=currentRow.createCell(17);
					rc_1_17.setCellValue("PASS");
			//FileOutputStream testresult_1_17 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\OrangeHrm_Login_TestResultFile.xlsx");
			//workBook.write(testresult_1_17);
System.out.println("Successfully Logged Out:- Pass");		
		}
		else {
					Cell rc_1_17=currentRow.createCell(17);
					rc_1_17.setCellValue("FAIL");
			//FileOutputStream testresult_1_17= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\OrangeHrm_Login_TestResultFile.xlsx");
			//workBook.write(testresult_1_17);
System.out.println("Failed to Log Out:- FAIL");			
			}
		}
	}		
		
					Cell rc_1_17=row1.createCell(17);
					rc_1_17.setCellValue("");
			
		
		FileOutputStream login_Logout_TestResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\Excel_OrangeHrmLogin_Logout_TestResult.xlsx");
		workBook.write(login_Logout_TestResult);	
		
		
		//driver.close();	
	}
	
}
		
		
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver = new ChromeDriver();
		driver.get(OrangehrmWebApplicationUrl);
		driver.getPageSource();
		FileInputStream orangehrm_Login_InputTestData = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\1LogInTest.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(orangehrm_Login_InputTestData);
		XSSFSheet inputDataSheet = workBook.getSheetAt(0);
		Row row1=inputDataSheet.getRow(1);
		
		int rowCount=inputDataSheet.getLastRowNum();
System.out.println("Active Row Count is:- "+rowCount);
System.out.println("Active Cell Count in a row is: "+row1.getLastCellNum());
		
		//List<String>userName = new ArrayList<>();//sometimes unable to import
		//List<String>password = new ArrayList<>();
			
		for(int rowindex=1; rowindex<=rowCount;rowindex++)
		{
			Row currentRow=inputDataSheet.getRow(rowindex);
			
			String userName=currentRow.getCell(9).getStringCellValue();
			String password=currentRow.getCell(10).getStringCellValue();
			
//Entering the Credentials after storing the values from excel into respective single strings			
			WebElement userNameElement=driver.findElement(By.id("txtUsername"));
			userNameElement.sendKeys(userName);
			String usernameEntered=userNameElement.getAttribute("value");
System.out.println("Username Entered in WebApplication:- "+usernameEntered);
			
			WebElement passwordElement=driver.findElement(By.id("txtPassword"));
			passwordElement.sendKeys(password);
			String passwordEntered=passwordElement.getAttribute("value");
System.out.println("Password Entered in WebApplication "+passwordEntered);
		
			driver.findElement(By.className("button")).click();
			String urlAddress=driver.getCurrentUrl();

//Validating the Credentials with Current URL			
			if(urlAddress.contains("validateCredentials"))
			{	
				Cell rc_1_11=currentRow.createCell(11);
				rc_1_11.setCellValue("FAIL");
System.out.println("The Invalid UserName & Password combination is:- "+usernameEntered +" || "+passwordEntered);
				
			}System.out.println();
			if(urlAddress.contains("dashboard"))
			{
				Cell rc_1_11=currentRow.createCell(11);
				rc_1_11.setCellValue("PASS");
System.out.println("Successfylly Navigated to the Expected Page");				
System.out.println("The VALID Username & Password Combination is:- "+usernameEntered+" || "+passwordEntered);
			}
			
		}
		FileOutputStream credentialsTestResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\credentialsTestResult.xlsx");
		workBook.write(credentialsTestResult);
//Continuing with the validation of Admin Element after successfully navigating to OrangeHrm dashboard
		
		
	}
}
*/