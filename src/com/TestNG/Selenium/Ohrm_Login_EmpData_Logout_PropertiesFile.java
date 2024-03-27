package com.TestNG.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Assignments.BaseTest;

public class Ohrm_Login_EmpData_Logout_PropertiesFile extends BaseTest{
	
	FileInputStream ohrmMultiUserCredentialsExcel;
	XSSFWorkbook workBook;
	XSSFSheet testSheet;
	Properties prop;
	FileInputStream orangeHrmPropertiesFile;
	Row row1;
	int lastRowNum;
	int lastCellNum;
		
	@Test(priority=1, description="Validation of Login Page of OrangeHRM WebApplication")
	
	public void orangeHrmWebApplicationLoginPage() throws IOException {
		
		ohrmMultiUserCredentialsExcel= new FileInputStream("./src/com/Excel/Data/Read/1LogInTest.xlsx");
		workBook = new XSSFWorkbook(ohrmMultiUserCredentialsExcel);
		testSheet=workBook.getSheetAt(0);
		lastRowNum=testSheet.getLastRowNum();
		lastCellNum=testSheet.getRow(0).getLastCellNum();
System.out.println("Last Row Number in loginExcel File is:- "+lastRowNum+" & Last Cell Number is:- "+lastCellNum );		
		orangeHrmPropertiesFile = new FileInputStream("./src/com/Config/OrangeHRM.properties");
		prop = new Properties();
		prop.load(orangeHrmPropertiesFile);
		
		row1=testSheet.getRow(1);
		Cell cell1=row1.getCell(0);
		String expected_LogInPageText=cell1.getStringCellValue();
// Driver already navigated to Url
		By loginPanelProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_loginPanel_idProperty"));
		WebElement loginPanel=driver.findElement(loginPanelProperty);
		String actual_LogInPageText=loginPanel.getText();
								row1.createCell(1).setCellValue(actual_LogInPageText);
		if(actual_LogInPageText.equalsIgnoreCase(expected_LogInPageText))
		{
								row1.createCell(2).setCellValue("PASS");
		}
		else {
								row1.createCell(2).setCellValue("FAIL");	
		}
		
		String expected_LogInPageTitle=row1.getCell(3).getStringCellValue();
		String actual_LogInPageTitle=driver.getTitle();
								row1.createCell(4).setCellValue(actual_LogInPageTitle);
		if(actual_LogInPageTitle.equalsIgnoreCase(expected_LogInPageTitle))
		{
								row1.createCell(5).setCellValue("PASS");
		}
		else {
								row1.createCell(5).setCellValue("FAIL");
		}					
		String expected_LogInPageUrlAddress=row1.getCell(6).getStringCellValue();
		String actual_LogInPageUrlAddress=driver.getCurrentUrl();
								row1.createCell(7).setCellValue(actual_LogInPageUrlAddress);
		if(actual_LogInPageUrlAddress.contains(expected_LogInPageUrlAddress))
		{
								row1.createCell(8).setCellValue("PASS");
		}
		else {
								row1.createCell(8).setCellValue("FAIL");
		}
System.out.println("Validation of OrangeHrm LoginPage is Completed");		
	}
	
@Test(priority =2, description="Validation of Multiple User Credentials")
		
		public void multiUserCredentialsLogin() throws IOException, InterruptedException {
			for(int rowindex=1;rowindex<=lastRowNum;rowindex++)
			{		
				Row userCredentialsLoopRow=testSheet.getRow(rowindex);
				String enteredUserName=testSheet.getRow(rowindex).getCell(9).getStringCellValue();
				String enteredPassword=testSheet.getRow(rowindex).getCell(10).getStringCellValue();
				
				By userNameProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_UserName_idProperty"));
				driver.findElement(userNameProperty).sendKeys(enteredUserName);
				By passwordProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_Password_idProperty"));
				driver.findElement(passwordProperty).sendKeys(enteredPassword);
				By loginButtonProp=By.name(prop.getProperty("orangeHRMApplicationLogInPage_LoginButton_nameProperty"));
				WebElement loginButton=driver.findElement(loginButtonProp);loginButton.click();
				
				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.until(ExpectedConditions.invisibilityOf(loginButton));
				String presentWebPageUrl=driver.getCurrentUrl();
				if(presentWebPageUrl.contains("validateCredentials"))
				{						
										userCredentialsLoopRow.createCell(11).setCellValue("FAIL");
					File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source, new File("./SnapShots/OrangeHrm_UserCredentials_"+enteredUserName+" & "+enteredPassword+".png"));
System.out.println("The invalid User Credentials Combination is:- "+enteredUserName+" |"+enteredPassword);				
				}
				
				if(presentWebPageUrl.contains("dashboard"))
	{					
										userCredentialsLoopRow.createCell(11).setCellValue("PASS");
System.out.println("The Valid User Crendentials Combination is :- "+enteredUserName+" |"+enteredPassword);						
						String expected_HomePageText=row1.getCell(13).getStringCellValue();
						By welcomeAdminProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_WelcomeAdmin_idProperty"));
						WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
						String actual_HomePageText=welcomeAdmin.getText();	
										userCredentialsLoopRow.createCell(14).setCellValue(actual_HomePageText);

						if(actual_HomePageText.contains(expected_HomePageText))
						{
										userCredentialsLoopRow.createCell(15).setCellValue("PASS");
System.out.println("		Successfyllu Navigated to the OrangeHrm HomePage:- PASS");						
						}
						else {
										userCredentialsLoopRow.createCell(15).setCellValue("FAIL");
						}
				
			welcomeAdmin.click();
			By logOutProperty=By.linkText(prop.getProperty("orangeHRMApplicationLogInPage_LogOut_linkTextProperty"));	
			WebElement logOut=driver.findElement(logOutProperty); logOut.click();	
						
			String expected_LogInPageText=row1.getCell(16).getStringCellValue();
			By loginPanelProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_loginPanel_idProperty"));
			WebElement loginPanel=driver.findElement(loginPanelProperty);
			String actual_LogInPageTextAfterLogOut=loginPanel.getText();
										userCredentialsLoopRow.createCell(17).setCellValue(actual_LogInPageTextAfterLogOut);
					if(actual_LogInPageTextAfterLogOut.equalsIgnoreCase(expected_LogInPageText))
					{
										userCredentialsLoopRow.createCell(18).setCellValue("PASS");
					}
					else {
										userCredentialsLoopRow.createCell(18).setCellValue("FAIL");
					}
System.out.println("Validation of Multiple UserCredentials is Completed with Validation after Logout");
System.out.println();
	
	
	}
			
			
			
			
		
		}	
		FileOutputStream mutlipleUsersTest = new FileOutputStream("./src/com/Excel/Result/Input/orangeHrm_MultipleUserCredentials_Login_Result.xlsx");
		workBook.write(mutlipleUsersTest);
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	

