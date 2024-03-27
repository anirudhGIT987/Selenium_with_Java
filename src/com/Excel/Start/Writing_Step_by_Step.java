package com.Excel.Start;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


class Writing_Step_by_Step{
	public static void main(String args[]) throws InterruptedException, IOException {
	
		//Automate the browser and get the actual data initially
		WebDriver driver;
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);

		By logInPanelProp=By.id("logInPanelHeading");
		WebElement logInPanel=driver.findElement(logInPanelProp);
		String actual_Login_Panel_Text=logInPanel.getText();
		String actual_Ohrm_Title=driver.getTitle();
		String acutal_Ohrm_Url_Address=driver.getCurrentUrl();
System.out.println(actual_Login_Panel_Text);
System.out.println(actual_Ohrm_Title);
System.out.println(acutal_Ohrm_Url_Address);
		
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys("AnirudhHrm");
		String username_Data=userName.getAttribute("value");
//System.out.println(username_Data);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("Ohrm@987");
		String password_Data=password.getAttribute("value");
//System.out.println(password_Data);
		driver.findElement(By.className("button")).click();
		
		
		By admin_Link_Prop=By.linkText("Admin");
		WebElement admin_Link=driver.findElement(admin_Link_Prop);
		String actual_Admin_Link_Text=admin_Link.getText();
//System.out.println(actual_Admin_Link_Text);
		By welcome_Admin_Prop=By.className("panelTrigger");
		WebElement welcome_Admin=driver.findElement(welcome_Admin_Prop);
		welcome_Admin.click();
		Thread.sleep(2500);
		
		By logout_prop=By.linkText("Logout");
		WebElement logout=driver.findElement(logout_prop);
		logout.click();
		 logInPanelProp=By.id("logInPanelHeading");
		logInPanel=driver.findElement(logInPanelProp);
		String actual_Login_Panel_Text_after_Logout=logInPanel.getText();
		
		driver.close();
		
////////////////////////////////////////////////////////////////////////////////		
		FileInputStream xcel_Login = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		XSSFWorkbook workBook_Login = new XSSFWorkbook(xcel_Login);
		XSSFSheet sheet_Login	= workBook_Login.getSheet("Sheet1");
		Row row1_Login=sheet_Login.getRow(1);
		Cell cell0_Login_LoginPanel_Text=row1_Login.getCell(0);
		String RC_1_0=cell0_Login_LoginPanel_Text.getStringCellValue();
System.out.println(RC_1_0);
		Cell cell3_Login_Ohrm_Title=row1_Login.getCell(3);
		String RC_1_3=cell3_Login_Ohrm_Title.toString();
System.out.println(RC_1_3);
		Cell cell6_Login_Url=row1_Login.getCell(6);
		String RC_1_6=cell6_Login_Url.toString();
System.out.println(RC_1_6);
		Cell cell_11_Login_Admin_Text=row1_Login.getCell(11);
		String RC_1_11=cell_11_Login_Admin_Text.toString();
System.out.println(RC_1_11);		
		Cell cel14_Login_LoginPanel=row1_Login.getCell(14);
		String RC_1_14=cel14_Login_LoginPanel.toString();
System.out.println(RC_1_14);
System.out.println("*************************");
System.out.println();
	////////////////////////////////////////////////////////////
		Cell cell_1_Login=row1_Login.createCell(1);
		cell_1_Login.setCellValue(actual_Login_Panel_Text);
		FileOutputStream testresult_1_1 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_1);
		
		Cell cell4_Login=row1_Login.createCell(4);
		cell4_Login.setCellValue(actual_Ohrm_Title);
		FileOutputStream testresult_1_4 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_4);
		
		Cell cell7_Login=row1_Login.createCell(7);
		cell7_Login.setCellValue(acutal_Ohrm_Url_Address);
		FileOutputStream testresult_1_7 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_7);
		//9,10,12,15
		Cell cell9_Login=row1_Login.createCell(9);
		cell9_Login.setCellValue(username_Data);
		FileOutputStream testresult_1_9 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_9);
		
		Cell cell_10_Login=row1_Login.createCell(10);
		cell_10_Login.setCellValue(password_Data);
		FileOutputStream testresult_1_10 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_10);
		
		Cell cell_12_Login=row1_Login.createCell(12);
		cell_12_Login.setCellValue(actual_Admin_Link_Text);
		FileOutputStream testresult_1_12 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_12);
	
		Cell cell_15_Login=row1_Login.createCell(15);
		cell_15_Login.setCellValue(actual_Login_Panel_Text_after_Logout);
		FileOutputStream testresult_1_15 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
		workBook_Login.write(testresult_1_15);
	///////////////////////////////////////////////////////////	
		//Writing Status
		if(actual_Login_Panel_Text.equals(RC_1_0))
		{
			Cell cell2_Login=row1_Login.createCell(2);
			cell2_Login.setCellValue("PASS");
			FileOutputStream testresult_1_2 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_2);				
		}
		else {
			Cell cell2_Login=row1_Login.createCell(2);
			cell2_Login.setCellValue("FAIL");
			FileOutputStream testresult_1_2 = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_2);				
		}
		
		if(actual_Ohrm_Title.equals(RC_1_3))
		{
			Cell cell5_Login=row1_Login.createCell(5);
			cell5_Login.setCellValue("PASS");
			FileOutputStream testresult_1_5= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_5);
		}
		else {
			Cell cell5_Login=row1_Login.createCell(5);
			cell5_Login.setCellValue("FAIL");
			FileOutputStream testresult_1_5= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_5);		
		}
		if(acutal_Ohrm_Url_Address.equals(RC_1_6))
		{
			Cell cell8_Login=row1_Login.createCell(8);
			cell8_Login.setCellValue("PASS");
			FileOutputStream testresult_1_8= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_8);		
		}
		else {
			Cell cell8_Login=row1_Login.createCell(8);
			cell8_Login.setCellValue("FAIL");
			FileOutputStream testresult_1_8= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_8);		
		}
		if(actual_Admin_Link_Text.equals(RC_1_11))
		{
			Cell cell_13_Login=row1_Login.createCell(13);
			cell_13_Login.setCellValue("PASS");
			FileOutputStream testresult_1_13= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_13);		
		}
		else {
			Cell cell_13_Login=row1_Login.createCell(13);
			cell_13_Login.setCellValue("FAIL");
			FileOutputStream testresult_1_13= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_13);		
		}
		if(actual_Login_Panel_Text_after_Logout.equals(RC_1_14))
		{
			Cell cell_16_Login=row1_Login.createCell(16);
			cell_16_Login.setCellValue("PASS");
			FileOutputStream testresult_1_16= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_16);
		}
		else {
			Cell cell_16_Login=row1_Login.createCell(16);
			cell_16_Login.setCellValue("FAIL");
			FileOutputStream testresult_1_16= new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\1LogInTest.xlsx");
			workBook_Login.write(testresult_1_16);
		}
	
		
	}
	
}
