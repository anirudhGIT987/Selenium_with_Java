package com.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_Complete_Ohrm_Login_EmpRegistration_EmpTable extends Excel_AddEmployee_Mutli_EmployeeCredentials{

	WebDriver driver;
	String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	FileInputStream empReg_excel;
	XSSFWorkbook wb;
	XSSFSheet empDetails_Sheet;
	
	
	/*
	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(OrangehrmWebApplicationUrl);
	}
	
	
	
	@Test(priority =1, description ="Validation of Multi User Login & Multi Employee Registration")
	
		public void employeeRegistration() throws IOException, InterruptedException {
		
		empReg_excel = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\AddEmployee.xlsx");
		wb= new XSSFWorkbook(empReg_excel);
		empDetails_Sheet= wb.getSheetAt(0);
		int rowCount = empDetails_Sheet.getLastRowNum();
System.out.println("Active Rows in sheet:- "+rowCount);		
		Row row1=empDetails_Sheet.getRow(1);
		Row row0=empDetails_Sheet.getRow(0);
		int cellCount=row0.getLastCellNum();
System.out.println("Active Row of Cells in a Row is:- "+cellCount);

//		Reading all the Expected Test Data 	
	String expected_LogInPageText=row1.getCell(0).getStringCellValue();
	String expected_LogInPageTitle=row1.getCell(3).getStringCellValue();
	String expected_HomePageText=row1.getCell(10).getStringCellValue();
	String expected_AddEmployeePageText=row1.getCell(13).getStringCellValue();
	String expected_PersonalDetailsPageText= row1.getCell(20).getStringCellValue();
	String expected_LogInPageText_after_LogOut=row1.getCell(31).getStringCellValue();

System.out.println("rc_1_0|| Expected LoginPage Text is :- "+expected_LogInPageText);		
System.out.println("rc_1_3|| Expected LoginPage Title is:- "+expected_LogInPageTitle);	
System.out.println("rc_1_9||Expected HomePage Text is:- "+expected_HomePageText);
System.out.println("rc_1_12||expected AddEmployee PageText is:- "+expected_AddEmployeePageText);		
System.out.println("rc_1_19||expected PersonalDetails Page Text is:- "+expected_PersonalDetailsPageText);		
System.out.println("rc_1_30||expected LogInPage Text after LogOut is:-  "+expected_LogInPageText_after_LogOut);

System.out.println("*************************************************************");
System.out.println();


//LoginPanel Text		
	By loginPanelProperty=By.id("logInPanelHeading");
	WebElement loginPanel=driver.findElement(loginPanelProperty);
	String actual_LogInPageText=loginPanel.getText();
//OrangeHrm webPage Title
	String actual_LogInPageTitle=driver.getTitle();
			//End of Getting Data from WebApplication till LogIN
//Writing the data validation of elements before login
System.out.println("Creating rc1_1");
	
	row1.createCell(1).setCellValue(actual_LogInPageText);
	
	if(actual_LogInPageText.contains(expected_LogInPageText))
	{
		row1.createCell(2).setCellValue("PASS");
	}
	else {
		row1.createCell(2).setCellValue("FAIL");
	}
	
	row1.createCell(4).setCellValue(actual_LogInPageTitle);
	if(actual_LogInPageTitle.equalsIgnoreCase(expected_LogInPageTitle))
	{
		row1.createCell(5).setCellValue("PASS");
	}
	else {
		row1.createCell(5).setCellValue("FAIL");
	}
				//Moving to Validation of User Credentials
//Reading the User Credentials from External Excel file
	for(int rindex=1; rindex<=4; rindex++)
	{
		Row currentRow=empDetails_Sheet.getRow(rindex);
		
		String expectedUsernme=currentRow.getCell(6).getStringCellValue();
		String expectedPassword=currentRow.getCell(7).getStringCellValue();
//Driver is in LoginPage only			
		WebElement userNameElement=driver.findElement(By.name("txtUsername"));
		userNameElement.sendKeys(expectedUsernme);
		String userNameEntered=userNameElement.getAttribute("value");

		WebElement passwordElement=driver.findElement(By.name("txtPassword"));
		passwordElement.sendKeys(expectedPassword);
		String passwordEntered=passwordElement.getAttribute("value");
		
		WebElement loginButton=driver.findElement(By.name("Submit"));
		loginButton.click();
		Thread.sleep(1000);
		String urlAddress=driver.getCurrentUrl();
System.out.println("Current Url is:- "+urlAddress);		
	//	List<WebElement>linkElements=driver.findElements(By.tagName("a"));			
	//	int linksCount=linkElements.size();
//System.out.println("Total Links Count on the WebPage is:- "+linksCount);
		
	//	if(linksCount==5)
		if(urlAddress.contains("validateCredentials"))
		{		
						currentRow.createCell(8).setCellValue("FAIL");
						File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+userNameEntered+" "+passwordEntered+".png"));
						currentRow.createCell(9).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Invalid_Combination "+userNameEntered+" "+passwordEntered+".png");

System.out.println("The Invalid Combination of Username & Password is:- "+userNameEntered+"||"+passwordEntered);
		}
		
		//if(linksCount67)
		if(urlAddress.contains("dashboard"))
		{
System.out.println("Entered into Valid Login UserCredentials");			
						currentRow.createCell(8).setCellValue("PASS");
						File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+userNameEntered+" "+passwordEntered+".png"));
						currentRow.createCell(9).setCellValue("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\Valid_Combination "+userNameEntered+" "+passwordEntered+".png");

System.out.println("The VALID Combination of Username & Password is:- "+userNameEntered+"||"+passwordEntered);
	//Getting Admin Element text			
	WebElement adminElement=driver.findElement(By.linkText("Admin"));	
		String actual_HomePageText=adminElement.getText();
						currentRow.createCell(11).setCellValue(actual_HomePageText);

			if(actual_HomePageText.equals(expected_HomePageText))
			{
						currentRow.createCell(12).setCellValue("PASS");
			}
			else {
						currentRow.createCell(12).setCellValue("FAIL");
			}
	
		
			//To reach Add Employee page 
		WebElement pimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act = new Actions(driver);
		act.moveToElement(pimElement).build().perform();
		WebElement addEmployeeLink=driver.findElement(By.linkText("Add Employee"));
		addEmployeeLink.click();
		
		WebElement fullNameText=driver.findElement(By.className("hasTopFieldHelp"));
		String actual_AddEmployeePageText=fullNameText.getText();
							currentRow.createCell(14).setCellValue(actual_AddEmployeePageText);
		
			if(actual_AddEmployeePageText.equals(expected_AddEmployeePageText))
			{
							currentRow.createCell(15).setCellValue("PASS");
			}
			else {
							currentRow.createCell(15).setCellValue("FAIL");
			}
		
//Now driver is in ADD Employee Page			
//Moving to Expected Employee Details -c.16-19
		for(int rowindex=1; rowindex<=rowCount;rowindex++)
		{
		Row presentRow=empDetails_Sheet.getRow(rowindex);
							
		String expected_FirstName=presentRow.getCell(16).getStringCellValue();
		String expected_MiddleName=presentRow.getCell(17).getStringCellValue();
		String expected_LastName=presentRow.getCell(18).getStringCellValue();
							
							
//Registering Employees with given Expected Details
//If data is in line without here and there
		driver.findElement(By.name("firstName")).sendKeys(expected_FirstName);
		driver.findElement(By.name("middleName")).sendKeys(expected_MiddleName);
		driver.findElement(By.name("lastName")).sendKeys(expected_LastName);
		WebElement employeeId_Field=driver.findElement(By.name("employeeId"));
		String expected_EmployeeId=employeeId_Field.getAttribute("Value");
						presentRow.createCell(19).setCellValue(expected_EmployeeId);
		WebElement saveButton=driver.findElement(By.id("btnSave"));
		saveButton.click();
		
//Validation of Entered Employee Data	
		WebElement fullNameListItem=driver.findElement(By.className("hasTopFieldHelp"));
		String actual_PersonalDetailsPageText=fullNameListItem.getText();
						presentRow.createCell(21).setCellValue(actual_PersonalDetailsPageText);
		if(actual_PersonalDetailsPageText.contains(expected_PersonalDetailsPageText))
		{
						presentRow.createCell(22).setCellValue("PASS");
		}
		else {
						presentRow.createCell(22).setCellValue("FAIL");
		}
		
		WebElement registeredFirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
		String actual_FirstName=registeredFirstName.getAttribute("value");
						presentRow.createCell(23).setCellValue(actual_FirstName);
		if(actual_FirstName.equals(expected_FirstName))
		{		
						presentRow.createCell(24).setCellValue("PASS");
		}
		else {
						presentRow.createCell(24).setCellValue("FAIL");
		}
		WebElement registeredMiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
		String actual_MiddleName=registeredMiddleName.getAttribute("value");
						presentRow.createCell(25).setCellValue(actual_MiddleName);
		if(actual_MiddleName.equals(expected_MiddleName))
		{
						presentRow.createCell(26).setCellValue("PASS");
		}
		else {
						presentRow.createCell(26).setCellValue("PASS");
		}
		
		WebElement registeredLastName=driver.findElement(By.id("personal_txtEmpLastName"));
		String actual_LastName=registeredLastName.getAttribute("value");
						presentRow.createCell(27).setCellValue(actual_LastName);
		if(actual_LastName.equals(expected_LastName))
		{
						presentRow.createCell(28).setCellValue("PASS");
		}
		else {
						presentRow.createCell(28).setCellValue("PASS");
		}
		
		WebElement registeredEmployeeId=driver.findElement(By.id("personal_txtEmployeeId"));
		String actual_EmployeeId=registeredEmployeeId.getAttribute("value");
						presentRow.createCell(29).setCellValue(actual_EmployeeId);
		if(actual_EmployeeId.equals(expected_EmployeeId))
		{
						presentRow.createCell(30).setCellValue("PASS");
		}
		else {
						presentRow.createCell(30).setCellValue("PASS");
		}
		
		 addEmployeeLink=driver.findElement(By.linkText("Add Employee"));
		 addEmployeeLink.click();		
		
	}

}	
		
	
	}
	FileOutputStream testResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\addEmployeeRegistration.xlsx");
	wb.write(testResult);
	
	
}
	*/
	
	
	@Test(priority=2, description="Registered Employee List Table")
	
		public void registeredEmployeeList() throws IOException {
			FileInputStream emptyTestFile= new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\New Microsoft Excel Worksheet.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(emptyTestFile);
			XSSFSheet inputDataSheet = workBook.getSheetAt(0);
			
			By employeeListProperty=By.linkText("Employee List");
			WebElement employeeList=driver.findElement(employeeListProperty);
			employeeList.click();
			
			// Identify the table
			By empDetailsTableProperty=By.id("frmList_ohrmListComponent");
			WebElement empDetailsTable=driver.findElement(empDetailsTableProperty);
			
			//Click the idHeader for sorting in order
			By idheaderProp=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th[2]");
			WebElement idheader=empDetailsTable.findElement(idheaderProp);
			idheader.click();
			
			//Finding out the Table again --- To escape Stale Element found
			 empDetailsTableProperty=By.id("frmList_ohrmListComponent");
			 empDetailsTable=driver.findElement(empDetailsTableProperty);

			//Identify Row
			By rowProp=By.tagName("tr");
			List<WebElement>rows=empDetailsTable.findElements(rowProp);
		//To go to webTable -- to all rows
			for(int rowindex=0; rowindex<rows.size();rowindex++)
			{
				//Go to a row in the webtable
				WebElement row=rows.get(rowindex);
				
				Row newRow=inputDataSheet.createRow(rowindex);
				//Going to a row and finding the number of Row of cells
				By cellProp=By.tagName("td");
				List<WebElement>cells=row.findElements(cellProp);
				for(int cellindex = 0; cellindex<cells.size(); cellindex++)
				{
					WebElement cell=cells.get(cellindex);
					String data=cell.getText();
					newRow.createCell(cellindex).setCellValue(data);

	System.out.print(data+" | ");				
					
					
				}System.out.println();
			
			
			
			}
			FileOutputStream empDetailsList = new FileOutputStream("./src/com/Excel/Result/Input/TestNG_Registered_OHRM_Employees_Table.xlsx");
			workBook.write(empDetailsList);
		
			
		/*	
		//Logging Out from the OrangeHrm Account 	
		By welcome_Admin_Prop=By.className("panelTrigger");
		WebElement welcome_Admin=driver.findElement(welcome_Admin_Prop);
		welcome_Admin.click();
		Thread.sleep(2500);

		By logout_prop=By.linkText("Logout");
		WebElement logout=driver.findElement(logout_prop);
		logout.click();	
	
		WebElement loginPanelElement=driver.findElement(By.id("logInPanelHeading"));
		String actual_LogInPageText_afterLogout=loginPanelElement.getText();
					currentRow.createCell(32).setCellValue(actual_LogInPageText_afterLogout);
		if(actual_LogInPageText_afterLogout.contains(expected_LogInPageText_after_LogOut))	
		{
					currentRow.createCell(33).setCellValue("PASS");
		}
		else {
					currentRow.createCell(33).setCellValue("FAIL");
		}
*/
		}
		
		
	
	

	}
	
	
	
	
	
	

