package com.Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Excel_EmployeeValidation_Ohrm {
	public static void main(String[] args) throws IOException, InterruptedException {
		
//Reading Expected LoginPanel Text
		FileInputStream xcel = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(xcel);
		XSSFSheet sheet_EmployeeData = workBook.getSheetAt(0);
		Row row1=sheet_EmployeeData.getRow(1);
		Cell rc_1_0=row1.getCell(0);
		String expected_LoginPage_Text=rc_1_0.getStringCellValue();
		//System.out.println(expected_LoginPanel_Text);
		
//Automating Browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(OrangehrmWebApplicationUrl);
		
		By logInPanelProp=By.id("logInPanelHeading");
		WebElement logInPanel=driver.findElement(logInPanelProp);
		String actual_Login_Page_Text=logInPanel.getText();
				
//Writing Actual LoginPanel Text into Excel 
					Cell rc_1_1=row1.createCell(1);
					rc_1_1.setCellValue(actual_Login_Page_Text);
					//FileOutputStream testresult_1_1 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_1);
		
//Result Status		
		if(actual_Login_Page_Text.equals(expected_LoginPage_Text))
		{
			Cell rc_1_2=row1.createCell(2);
			rc_1_2.setCellValue("Pass");
			//FileOutputStream testresult_1_2 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
			//workBook.write(testresult_1_2);			
		}
		else {	
			Cell rc_1_2=row1.createCell(2);
			rc_1_2.setCellValue("Pass");
			//FileOutputStream testresult_1_2 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
			//workBook.write(testresult_1_2);		
		}
			
//Reading OHRM WebPage Title
		Cell rc_1_3=row1.getCell(3);
		String expected_LogInPage_Title=rc_1_3.getStringCellValue();
		String actual_LogInPage_Title=driver.getTitle();
//Writing OHRM Title into Excel
					Cell rc_1_4=row1.createCell(4);
					rc_1_4.setCellValue(actual_LogInPage_Title);
					//FileOutputStream testresult_1_4 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_4);
//Result Status				
		if(actual_LogInPage_Title.equals(expected_LogInPage_Title))
		{
			Cell rc_1_5=row1.createCell(5);
			rc_1_5.setCellValue("PASS");
			//FileOutputStream testresult_1_5 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
			//workBook.write(testresult_1_5);
		}
		else {
			Cell rc_1_5=row1.createCell(5);
			rc_1_5.setCellValue("FAIL");
			//FileOutputStream testresult_1_5 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
			//workBook.write(testresult_1_5);
		}
		
				
		WebElement userNameElement=driver.findElement(By.id("txtUsername"));
		userNameElement.sendKeys("AnirudhHrm");
		String username=userNameElement.getAttribute("value");
//RC_1_6 Writing Credentials
					Cell rc_1_6=row1.createCell(6);
					 rc_1_6.setCellValue(username);
					// FileOutputStream testresult_1_6 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					 //workBook.write(testresult_1_6);
		WebElement passwordElement=driver.findElement(By.id("txtPassword"));
		passwordElement.sendKeys("Ohrm@987");
		String password=passwordElement.getAttribute("value");
					Cell rc_1_7=row1.createCell(7);
					rc_1_7.setCellValue("********");
					//FileOutputStream testresult_1_7 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					 //workBook.write(testresult_1_7);
		driver.findElement(By.className("button")).click();
		
//RC_1_8 Admin Link Text
		Cell rc_1_8=row1.getCell(8);
		String expected_HomePage_Text=rc_1_8.getStringCellValue();
		By admin_Link_Prop=By.linkText("Admin");
		WebElement admin_Link=driver.findElement(admin_Link_Prop);
		String actual_HomePage_Text=admin_Link.getText();
//Writing Admin Link Text					
					Cell rc_1_9=row1.createCell(9);
					rc_1_9.setCellValue(actual_HomePage_Text);
					//FileOutputStream testresult_1_9 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					 //workBook.write(testresult_1_9);
//Result Status					 
		if(actual_HomePage_Text.equals(expected_HomePage_Text))		
		{
					Cell rc_1_10=row1.createCell(10);
					rc_1_10.setCellValue("PASS");
					//FileOutputStream testresult_1_10 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_10);			
		}
		else {
					Cell rc_1_10=row1.createCell(10);
					rc_1_10.setCellValue("FAIL");
					//FileOutputStream testresult_1_10 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_10);
		}
		
//Add Employee Page 
		
		By pim_LinkProp=By.id("menu_pim_viewPimModule");
		WebElement pim_Link_Element=driver.findElement(pim_LinkProp);
			Actions act = new Actions(driver);	
		act.moveToElement(pim_Link_Element).build().perform();
		By addEmployee_LinkProperty=By.linkText("Add Employee");
		WebElement addEmployeeLink=driver.findElement(addEmployee_LinkProperty);
		addEmployeeLink.click();
		
//Reading FullName Text		
		Cell rc_1_11=row1.getCell(11);
		String expected_AddEmployeePageText =rc_1_11.getStringCellValue();
//Writing Full Name Text
		By fullNameListItemProperty=By.className("hasTopFieldHelp");
		WebElement fullNameListItem=driver.findElement(fullNameListItemProperty);
		String actual_AddEmployeePageText=fullNameListItem.getText();
					Cell rc_1_12=row1.createCell(12);
					rc_1_12.setCellValue(actual_AddEmployeePageText);
					//FileOutputStream testresult_1_12 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_12);
//Result Status
		if(actual_AddEmployeePageText.equals(expected_AddEmployeePageText))
		{
					Cell rc_1_13=row1.createCell(13);
					rc_1_13.setCellValue("PASS");
					//FileOutputStream testresult_1_13 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_13);
		}
	else {
					Cell rc_1_13=row1.createCell(13);
					rc_1_13.setCellValue("FAIL");
					//FileOutputStream testresult_1_13 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_13);			
		}
//Expected FirstName, MiddleName, LastName, EmployeeID
//Till now, we are at the Add Employee Page
				
//Adding Employees
		By firstNameProperty=By.id("firstName");
		WebElement firstName=driver.findElement(firstNameProperty);
		String expected_EmployeeFirstName="SriRangam";
		firstName.sendKeys(expected_EmployeeFirstName);
					Cell rc_1_14=row1.createCell(14);
					rc_1_14.setCellValue(expected_EmployeeFirstName);
					//FileOutputStream testresult_1_14 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_14);
			
		By middleNameProperty=By.name("middleName");
		WebElement middleName=driver.findElement(middleNameProperty);
		String expected_EmployeeMiddleName="Srinavasa";
		middleName.sendKeys(expected_EmployeeMiddleName);
					Cell rc_1_15=row1.createCell(15);
					rc_1_15.setCellValue(expected_EmployeeMiddleName);
					//FileOutputStream testresult_1_15 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_15);
		
		By lastNameProperty=By.id("lastName");
		WebElement lastName=driver.findElement(lastNameProperty);
		String expectedEmployeeLastName="Rao";
		lastName.sendKeys(expectedEmployeeLastName);
					Cell rc_1_16=row1.createCell(16);
					rc_1_16.setCellValue(expectedEmployeeLastName);
					//FileOutputStream testresult_1_16 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_16);
				
		By employeeIdProperty=By.id("employeeId");
		WebElement employeeId=driver.findElement(employeeIdProperty);
		String expectedEmployeeId=employeeId.getAttribute("Value");
					Cell rc_1_17=row1.createCell(17);
					rc_1_17.setCellValue(expectedEmployeeLastName);
					//FileOutputStream testresult_1_17 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_17);
				
		By saveButtonProperty=By.id("btnSave");
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
//Personal Details Page Text
		Cell rc_1_18=row1.getCell(18);
		String expected_PersonalDetailsPageText=rc_1_18.getStringCellValue();			 
		fullNameListItemProperty=By.className("hasTopFieldHelp");
		fullNameListItem=driver.findElement(fullNameListItemProperty);
		String actual_PersonalDetailsPageText=fullNameListItem.getText();	 
					Cell rc_1_19=row1.createCell(19);			 
					rc_1_19.setCellValue(actual_PersonalDetailsPageText);		 
					//FileOutputStream testresult_1_19 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_19);			 
		if(actual_PersonalDetailsPageText.equals(expected_PersonalDetailsPageText))
		{
					Cell rc_1_20=row1.createCell(20);
					rc_1_20.setCellValue("PASS");
					//FileOutputStream testresult_1_20 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_20);	
		}
		else {
					Cell rc_1_20=row1.createCell(20);
					rc_1_20.setCellValue("FAIL");
					//FileOutputStream testresult_1_20 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_20);	
			}
//Writing ACtual First Name, Middle NAme, LastName& Employee ID
		By registeredfirstNameProperty=By.id("personal_txtEmpFirstName");
		WebElement registeredFirstName=driver.findElement(registeredfirstNameProperty);
		String actual_EmployeeFirstName=registeredFirstName.getAttribute("Value");
					Cell rc_1_21=row1.createCell(21);
					rc_1_21.setCellValue(actual_EmployeeFirstName);	
					//FileOutputStream testresult_1_21 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_21);	 
		if(actual_EmployeeFirstName.equals(expected_EmployeeFirstName))
		{
					Cell rc_1_22 = row1.createCell(22);
					rc_1_22.setCellValue("PASS");
					//FileOutputStream testresult_1_22 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_22);
		}
		else {
					Cell rc_1_22 = row1.createCell(22);
					rc_1_22.setCellValue("FAIL");
					//FileOutputStream testresult_1_22 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_22);
		}
		By registeredMiddleNameProperty=By.id("personal_txtEmpMiddleName");
		WebElement registeredMiddleName=driver.findElement(registeredMiddleNameProperty);
		String actual_EmployeeMiddleName=registeredMiddleName.getAttribute("Value");
					Cell rc_1_23=row1.createCell(23);
					rc_1_23.setCellValue(actual_EmployeeFirstName);	
					//FileOutputStream testresult_1_23 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_23);	 
		if(actual_EmployeeFirstName.equals(expected_EmployeeFirstName))
		{
					Cell rc_1_24 = row1.createCell(24);
					rc_1_24.setCellValue("PASS");
					//FileOutputStream testresult_1_24 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_24);
       }
		else {
					Cell rc_1_24 = row1.createCell(24);
					rc_1_24.setCellValue("FAIL");
					//FileOutputStream testresult_1_24 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_24);
		}
		
		By registeredLastNameProperty=By.id("personal_txtEmpLastName");
		WebElement registeredLastName=driver.findElement(registeredLastNameProperty);
		String actual_EmployeeLastName=registeredLastName.getAttribute("Value");			 
						 
					Cell rc_1_25=row1.createCell(25);
					rc_1_25.setCellValue(actual_EmployeeFirstName);	
					//FileOutputStream testresult_1_25 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_25);	 
		if(actual_EmployeeFirstName.equals(expected_EmployeeFirstName))
		{
					Cell rc_1_26 = row1.createCell(26);
					rc_1_26.setCellValue("PASS");
					//FileOutputStream testresult_1_26 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_26);
		}
		else {
					Cell rc_1_26 = row1.createCell(26);
					rc_1_26.setCellValue("FAIL");
					//FileOutputStream testresult_1_26 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_26);
		}	 
		By registeredEmployeeIdProperty=By.id("personal_txtEmployeeId");
		WebElement registeredEmployeeId=driver.findElement(registeredEmployeeIdProperty);
		String actual_EmployeeId=registeredEmployeeId.getAttribute("Value");
					Cell rc_1_27=row1.createCell(27);
					rc_1_27.setCellValue(actual_EmployeeFirstName);	
					//FileOutputStream testresult_1_27 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_27);	 
		if(actual_EmployeeFirstName.equals(expected_EmployeeFirstName))
		{
					Cell rc_1_28 = row1.createCell(28);
					rc_1_28.setCellValue("PASS");
					//FileOutputStream testresult_1_28 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_28);
		}
		else {
					Cell rc_1_28 = row1.createCell(28);
					rc_1_28.setCellValue("FAIL");
					//FileOutputStream testresult_1_28 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_28);
		}	
//Expected LoginPanel after Logging out
		
		By welcomeAdminProperty=By.className("panelTrigger");
		WebElement welcomeAdminElement=driver.findElement(welcomeAdminProperty);
		welcomeAdminElement.click();
		
		Thread.sleep(2000);
		
		By logoutElementProperty=By.linkText("Logout");
		WebElement logoutElement=driver.findElement(logoutElementProperty);
		logoutElement.click();			
		
		Cell rc_1_29=row1.getCell(29);
		String expected_LoginPageText=rc_1_29.getStringCellValue();
		logInPanelProp=By.id("logInPanelHeading");
		logInPanel=driver.findElement(logInPanelProp);
		String actual_LoginPage_Text=logInPanel.getText();
					
					Cell rc_1_30=row1.createCell(30);
					rc_1_30.setCellValue(actual_LoginPage_Text);
					//FileOutputStream testresult_1_30 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_30);
		if(actual_LoginPage_Text.equals(expected_LoginPageText))
		{
					Cell rc_1_31=row1.createCell(31);
					rc_1_31.setCellValue("PASS");
					//FileOutputStream testresult_1_31= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_31);
		}
		else {
					Cell rc_1_31=row1.createCell(31);
					rc_1_31.setCellValue("FAIL");
					//FileOutputStream testresult_1_31= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\AddEmployee.xlsx");
					//workBook.write(testresult_1_31);
		}
	
	FileOutputStream testResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\SingleFileOUtputObject.xlsx");
	workBook.write(testResult);
	
	System.out.println("	*****THE END OF ASSIGNMENT**********");
driver.quit();	
			
	
	
	
	
	
	
	
	
	
	
}
}
