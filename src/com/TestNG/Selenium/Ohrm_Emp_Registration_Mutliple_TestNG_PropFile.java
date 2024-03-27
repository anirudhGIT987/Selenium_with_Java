package com.TestNG.Selenium;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.LogUtility;

public class Ohrm_Emp_Registration_Mutliple_TestNG_PropFile extends Ohrm_MutlipleUserCredentialsLogin_TestNg_PropFile {

	FileInputStream ohrmEmployeeRegistrExcel;
	XSSFWorkbook workBookEmp;
	XSSFSheet empSheet;
	int lastRowNumEmp;
	int lastCellNumEmp;
	Row row4;
	WebElement addEmployee;
	@Test(priority =3, description="Validating Login with Valid User Credentials")
	public void loginWithValidCredentials() throws IOException, InterruptedException {
		ohrmEmployeeRegistrExcel = new FileInputStream("./src/com/Excel/Data/Read/AddEmployee.xlsx");
		workBookEmp = new XSSFWorkbook(ohrmEmployeeRegistrExcel);
		empSheet = workBookEmp.getSheetAt(0);
		lastRowNumEmp = empSheet.getLastRowNum();
System.out.println("Active Row Count of Emp Excel file is:- "+lastRowNumEmp);		
		lastCellNumEmp=empSheet.getRow(0).getLastCellNum();
System.out.println("Active Cell Count of Emp Excel file is :- "+lastCellNumEmp);		
		
		row1=empSheet.getRow(1);
		String expected_LogInPageText=row1.getCell(0).getStringCellValue();
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
//System.out.println("Validation of OrangeHrm LoginPage is Completed");	
LogUtility.info("Validation of OrangeHrm LoginPage is Completed");					
		row4=empSheet.getRow(4);
		String validUserNameEntered=row4.getCell(6).getStringCellValue();	
		String validPasswordEntered=row4.getCell(7).getStringCellValue();
		
		String expected_HomePageText=row1.getCell(10).getStringCellValue();
		
		By userNameProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_UserName_idProperty"));
		
		WebElement userNameElement=driver.findElement(userNameProperty);userNameElement.sendKeys(validUserNameEntered);

		By passwordProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_Password_idProperty"));
		passwordElement =driver.findElement(passwordProperty);
		passwordElement.sendKeys(validPasswordEntered);
		By loginButtonProp=By.name(prop.getProperty("orangeHRMApplicationLogInPage_LoginButton_nameProperty"));
		WebElement loginButton=driver.findElement(loginButtonProp);
		loginButton.click();
		By welcomeAdminProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_WelcomeAdmin_idProperty"));
		welcomeAdmin=driver.findElement(welcomeAdminProperty);
		String actual_HomePageText=welcomeAdmin.getText();	
									row4.createCell(11).setCellValue(actual_HomePageText);

		if(actual_HomePageText.contains(expected_HomePageText))
		{							row4.createCell(8).setCellValue("PASS");
									row4.createCell(12).setCellValue("PASS");
//System.out.println("		Successfylly Navigated to the OrangeHrm HomePage:- PASS");						
LogUtility.info("		Successfylly Navigated to the OrangeHrm HomePage:- PASS");
		}
		else {
									row4.createCell(12).setCellValue("FAIL");
//System.out.println("		Failed to  Navigate to the OrangeHrm HomePage:- FAIL");						
LogUtility.info("		Failed to  Navigate to the OrangeHrm HomePage:- FAIL");
		}
		
	// Getting into Add EMployee Page
		By pimProperty=By.linkText(prop.getProperty("orangeHRMApplicationHomePage_PimElement_linkTextProperty"));
		WebElement pim=driver.findElement(pimProperty);
		Actions act = new Actions(driver);
		act.moveToElement(pim).build().perform();
		
		By addEmployeeProperty=By.linkText(prop.getProperty("orangeHRMApplicationEmployeeDetails_AddEmployee_idProperty"));
		addEmployee=driver.findElement(addEmployeeProperty);addEmployee.click();
		By headerAddEmployeeProperty=By.xpath(prop.getProperty("orangeHRMApplicationEmployeeDetails_AddEmployee_xpathProperty"));
		WebElement headerAddEmployee = driver.findElement(headerAddEmployeeProperty);	
	
		String expected_AddEmployeePageText=row1.getCell(13).getStringCellValue();
		String actual_AddEmployeePageText=headerAddEmployee.getText();
									row4.createCell(14).setCellValue(actual_AddEmployeePageText);
				if(actual_AddEmployeePageText.equalsIgnoreCase(expected_AddEmployeePageText))
				{		
									row4.createCell(15).setCellValue("PASS");
//System.out.println("        Successfully Navigated to the Add Employee Page | Pass  ");			
LogUtility.info("        Successfully Navigated to the Add Employee Page | Pass  ");
				}
				else {
									row4.createCell(15).setCellValue("FAIL");
//System.out.println("        Failed to Navigate to the Add Employee Page | Fail  ");			
LogUtility.info("        Failed to Navigate to the Add Employee Page | Fail  ");	
				}
	/*
// Entering the Employee Registration Data
				for(int empRowIndex =1; empRowIndex<=lastRowNumEmp;empRowIndex++ )
				{
					Row empNamesRow=empSheet.getRow(empRowIndex);
					String expected_FirstName=empNamesRow.getCell(16).getStringCellValue();
					String expected_MiddleName=empNamesRow.getCell(17).getStringCellValue();
					String expected_LastName=empNamesRow.getCell(18).getStringCellValue();
					
					By firstNameProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_FirstName_idProperty"));
					WebElement firstName=driver.findElement(firstNameProperty);firstName.sendKeys(expected_FirstName);
					
					By middleNameProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_MiddleName_idProperty"));
					WebElement middleName=driver.findElement(middleNameProperty);middleName.sendKeys(expected_MiddleName);
					
					By lastNameProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_LastName_idProperty"));
					WebElement lastName=driver.findElement(lastNameProperty);lastName.sendKeys(expected_LastName);
					
					By employeeIdProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_EmployeeId_idProperty"));
					WebElement employeeId=driver.findElement(employeeIdProperty);
					String expected_Employee_ID=employeeId.getAttribute("value");
					
									empNamesRow.createCell(19).setCellValue(expected_Employee_ID);
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.ENTER).build().perform();
					//Thread.sleep(1000);
	//java.lang.Runtime.getRuntime().exec("./AutoIt_.exeFiles/Ohrm_Autoit_ImageUpload.exe");
					 //java.lang.Runtime.getRuntime().exec("C:\\Users\\srinivas1\\Desktop\\1030AMAugustBatch\\WebApplicationTesting\\AutoItTestScripts\\EmployeePhotoGraph.exe");

					//By imageChooseFileProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_ChooseFile_idProperty"));
					//WebElement imageChooseFile = driver.findElement(imageChooseFileProperty);
					//imageChooseFile.click();
					By saveButtonProperty=By.id(prop.getProperty("orangeHRMApplicationAddEmployee_SaveButton_idProperty"));
					WebElement saveButton=driver.findElement(saveButtonProperty);
					saveButton.click();
System.out.println("Clicked Save Button");
				

					By personalDetailsProperty=By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1");
					WebElement personalDetails=driver.findElement(personalDetailsProperty);
					String actual_PersonalDetailsPageText=personalDetails.getText();
					String expected_PersonalDetailsPageText=row1.getCell(20).getStringCellValue();
									empNamesRow.createCell(21).setCellValue(actual_PersonalDetailsPageText);
				if(actual_PersonalDetailsPageText.equalsIgnoreCase(expected_PersonalDetailsPageText))
				{
									empNamesRow.createCell(22).setCellValue("PASS");
LogUtility.info("    Successfully Navigated to Personal Details Page           ");	
				}
				else {
									empNamesRow.createCell(22).setCellValue("FAIL");
				}
				
				WebElement registeredFirstName=driver.findElement(By.id(prop.getProperty("orangeHRMApplicationEmployeeDetails_RegisteredFirstName_idProperty")));
				String actual_FirstName=registeredFirstName.getAttribute("value");
									empNamesRow.createCell(23).setCellValue(actual_FirstName);
				if(actual_FirstName.equals(expected_FirstName))
				{		
									empNamesRow.createCell(24).setCellValue("PASS");
				}
				else {
									empNamesRow.createCell(24).setCellValue("FAIL");
				}
				WebElement registeredMiddleName=driver.findElement(By.id(prop.getProperty("orangeHRMApplicationEmployeeDetails_RegisteredMiddleName_idProperty")));
				String actual_MiddleName=registeredMiddleName.getAttribute("value");
									empNamesRow.createCell(25).setCellValue(actual_MiddleName);
				if(actual_MiddleName.equals(expected_MiddleName))
				{
									empNamesRow.createCell(26).setCellValue("PASS");
				}
				else {
									empNamesRow.createCell(26).setCellValue("PASS");
				}
				
				WebElement registeredLastName=driver.findElement(By.id(prop.getProperty("orangeHRMApplicationEmployeeDetails_RegisteredLastName_idProperty")));
				String actual_LastName=registeredLastName.getAttribute("value");
									empNamesRow.createCell(27).setCellValue(actual_LastName);
				if(actual_LastName.equals(expected_LastName))
				{
									empNamesRow.createCell(28).setCellValue("PASS");
				}
				else {
									empNamesRow.createCell(28).setCellValue("PASS");
				}
				
				WebElement registeredEmployeeId=driver.findElement(By.id(prop.getProperty("orangeHRMApplicationEmployeeDetails_RegisteredEmployeeId_idProperty")));
				String actual_EmployeeId=registeredEmployeeId.getAttribute("value");
									empNamesRow.createCell(29).setCellValue(actual_EmployeeId);
				if(actual_EmployeeId.equals(expected_Employee_ID))
				{
									empNamesRow.createCell(30).setCellValue("PASS");
				}
				else {
									empNamesRow.createCell(30).setCellValue("PASS");
				}
				
			By registeredEmpImageProperty=By.id(prop.getProperty("orangeHRMApplicationEmployeeDetails_RegisteredImage_idProperty"));
				WebElement registeredEmpImage=driver.findElement(registeredEmpImageProperty);
				Boolean flag=registeredEmpImage.isDisplayed();
				if(flag==true)
				{
LogUtility.info("Employee Phtograph Uploaded to the Application Successfully | PASS");					
				}
				else {
LogUtility.info("Employee Phtograph failed to Upload to the Application Successfully| FAIL");						
				} 
				addEmployee=driver.findElement(By.linkText("Add Employee"));
				
				addEmployee.click();
System.out.println("Clicked Add Employee after Validation of Registered Employee");	
			}
	*/
			// FileOutputStream testResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\New_OHRM_Logged_addEmployeeRegistration.xlsx");
			//	 workBookEmp.write(testResult);		
	
	}
		
	@Test(priority = 4, description ="Validation of Employee List Table into Excel")
	public void employeeListTable() throws IOException {
		FileInputStream emptyTestFile= new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\New Microsoft Excel Worksheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(emptyTestFile);
		XSSFSheet inputDataSheet = workBook.getSheetAt(0);
		
		By employeeListProperty=By.linkText(prop.getProperty("orangeHRMApplicationEmployeeDetails_EmployeeList_linkTextProperty"));
		WebElement employeeList=driver.findElement(employeeListProperty);
		employeeList.click();
		
		By idHeaderProperty=By.linkText(prop.getProperty("orangeHRMApplicationEmployeeDetails_idHeaderEmployeeListTable_linkTextProperty"));
		WebElement idHeader=driver.findElement(idHeaderProperty);idHeader.click();
		
		By employeeDetailsTableProperty=By.id("frmList_ohrmListComponent");
		WebElement employeeDetailsTable=driver.findElement(employeeDetailsTableProperty);
		By empTableRowProperty=By.tagName("tr");
		List<WebElement>empTableRowList=employeeDetailsTable.findElements(empTableRowProperty);
		int empTableRowCount=empTableRowList.size();
//System.out.println("The No. of Active ROws in the WebTable is:- "+empTableRowCount);			
		for(int empTableNxtPageIndex=1; empTableNxtPageIndex<3; empTableNxtPageIndex++)
{
			
		
		for(int empTableRowindex=0; empTableRowindex<empTableRowCount;empTableRowindex++)
	{
	// Get to the Row First
		WebElement currentRow=empTableRowList.get(empTableRowindex);
							Row createdRow=inputDataSheet.createRow(empTableRowindex);
		List<WebElement>empTableCellsList=currentRow.findElements(By.tagName("td"));
		int empTableCellCount=empTableCellsList.size();
//System.out.println("The No.of Active Cells in a Row is:- "+empTableCellCount);					
		
		for(int empTableCellindex=0;empTableCellindex<empTableCellCount;empTableCellindex++)
		{
			String empData=empTableCellsList.get(empTableCellindex).getText();
			createdRow.createCell(empTableCellindex).setCellValue(empData);
		}

	}	By nextPageProperty=By.linkText(prop.getProperty("orangeHrm_EmployeeTable_NextPage_LinkTextProperty"));
		WebElement nextPage=driver.findElement(nextPageProperty);nextPage.click();	
		
		
	}
		
		//FileOutputStream outputEmpTable = new  FileOutputStream("./src/com/Excel/Result/Input/new_Ohrm_Logged_EmpListTableOhrm.xlsx");
		//workBook.write(outputEmpTable);
		
		
		
	}
	
	@Test(priority = 5, description ="Validation of the functionality of Logout")
	public void Logout() {
		
		By welcomeAdminProperty=By.id(prop.getProperty("orangeHRMApplicationLogInPage_WelcomeAdmin_idProperty"));
		welcomeAdmin=driver.findElement(welcomeAdminProperty);
		welcomeAdmin.click();
		
		By logOutProperty=By.linkText(prop.getProperty("orangeHRMApplicationLogInPage_LogOut_linkTextProperty"));	
		WebElement logOut=driver.findElement(logOutProperty); logOut.click();	
LogUtility.info("Logged Out of the OrangeHrm WebApplication Succesfully");		
	}
	
	
	
}
	
	
	
	
	
	

