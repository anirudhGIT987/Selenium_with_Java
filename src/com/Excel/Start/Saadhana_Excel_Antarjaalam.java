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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Saadhana_Excel_Antarjaalam {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriver driver;
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(ApplicationUrlAddress);
	
		
	By loginPanel_Prop=By.id("logInPanelHeading");
	WebElement LoginPanel=driver.findElement(loginPanel_Prop);
	String actual_Login_Panel_Text=LoginPanel.getText();
	String actual_OHRM_Title=driver.getTitle();
	String actual_OHRM_Url=driver.getCurrentUrl();
	//System.out.println(actual_Login_Panel_Text);
	//System.out.println(actual_OHRM_Title);
	//System.out.println(actual_OHRM_Url);
	//<input name="txtUsername" id="txtUsername" type="text">
	WebElement userName=driver.findElement(By.id("txtUsername"));
	//userName.sendKeys("hussainsillar@gmail.com");
	userName.sendKeys("AnirudhHrm");
	String username_Data=userName.getAttribute("value");
	//System.out.println(username_Data);
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	WebElement password=driver.findElement(By.id("txtPassword"));
	password.sendKeys("Ohrm@987");
	String password_Data=password.getAttribute("value");
	//System.out.println(password_Data);
	driver.findElement(By.className("button")).click();
	////////////////////////////////////////////////////////////////////
	By Welcome_Admin_Prop=By.linkText("Welcome Admin");
	WebElement Welcome_Admin=driver.findElement(Welcome_Admin_Prop);
	Welcome_Admin.click();
	Thread.sleep(5000);

	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	By Logout_Prop=By.linkText("Logout");
	WebElement Logout=driver.findElement(Logout_Prop);
	Logout.click();
	LoginPanel=driver.findElement(loginPanel_Prop);
	String again_actual_Login_Panel_Text=LoginPanel.getText();
	//System.out.println(again_actual_Login_Panel_Text);
	driver.close();

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	FileInputStream fileLogIn=new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	XSSFWorkbook workbook_LogIn=new XSSFWorkbook(fileLogIn);
	XSSFSheet sheet_LogIn=workbook_LogIn.getSheet("Sheet1");
	Row row1_LogIn=sheet_LogIn.getRow(1);
	Cell cell0_LogIn=row1_LogIn.getCell(0);
	//XSSFRow row1_LogIn=sheet_LogIn.getRow(1);
	//Cell cell0_LogIn=row1_LogIn.getCell(0);
	String RC_1_0=cell0_LogIn.getStringCellValue();
System.out.println(RC_1_0);
	Cell cell3_LogIn=row1_LogIn.getCell(3);
	String RC_1_3=cell3_LogIn.getStringCellValue();
System.out.println(RC_1_3);
	Cell cell6_LogIn=row1_LogIn.getCell(6);
	String RC_1_6=cell6_LogIn.getStringCellValue();
System.out.println(RC_1_6);
	Cell cellc_9=row1_LogIn.createCell(9);
	cellc_9.setCellValue(username_Data);
	FileOutputStream test_Result_9=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_9);
	//Row row1_LogIn=sheet_LogIn.getRow(1);
	Cell cell9_LogIn=row1_LogIn.getCell(9);
	String RC_1_9=cell9_LogIn.getStringCellValue();
System.out.println(RC_1_9);
	Cell cellc_10=row1_LogIn.createCell(10);
	cellc_10.setCellValue("   "+password_Data);
	FileOutputStream test_Result_10=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_10);
	//Row row1_LogIn=sheet_LogIn.getRow(1);
	Cell cell10_LogIn=row1_LogIn.getCell(10);
	String RC_1_10=cell10_LogIn.getStringCellValue();
	///System.out.println(RC_1_10);
	/////////////////////////////////////////////////////////////////////////////////////////////
	Cell cellc_1=row1_LogIn.createCell(1);
	cellc_1.setCellValue(actual_Login_Panel_Text);
	FileOutputStream testresult_1_1=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(testresult_1_1);
	Cell cell_1=row1_LogIn.getCell(1);
	String RC_1_1=cell_1.getStringCellValue();
	//System.out.println(RC_1_1);
	Cell cellc_4=row1_LogIn.createCell(4);
	cellc_4.setCellValue(actual_OHRM_Title);
	FileOutputStream test_Result_1_4=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_4);
	Cell cellc_7=row1_LogIn.createCell(7);
	cellc_7.setCellValue(actual_OHRM_Url);
	FileOutputStream test_Result_1_7=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_7);
	/*Cell cell_11=row1_LogIn.getCell(11);
	cell_11.getStringCellValue();
	String RC_1_11=cell_11.getStringCellValue();
	//
	    System.out.println(RC_1_11);*/
	   Cell cell_14=row1_LogIn.getCell(14);
	  //cell_14.getStringCellValue();
	   String RC_1_14=cell_14.getStringCellValue();
	  // System.out.println(RC_1_14);
	   Cell cellc_15=row1_LogIn.createCell(15);
	cellc_15.setCellValue(again_actual_Login_Panel_Text);
	FileOutputStream test_Result_1_15=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_15);
	   


	if(actual_Login_Panel_Text.equals(RC_1_1)) {
	Cell cellc_2=row1_LogIn.createCell(2);
	cellc_2.setCellValue("       PASS");
	FileOutputStream test_Result_1_2=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_2);
	}
	else {Cell cellc_2=row1_LogIn.createCell(2);
	cellc_2.setCellValue("       FAIL");
	FileOutputStream test_Result_1_2=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_2);

	}
	if(actual_OHRM_Title.equals(RC_1_3)) {
	Cell cellc_5=row1_LogIn.createCell(5);
	cellc_5.setCellValue("       PASS");
	FileOutputStream test_Result_1_5=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_5);

	}
	else {
	Cell cellc_5=row1_LogIn.createCell(5);
	cellc_5.setCellValue("       FAIL");
	FileOutputStream test_Result_1_5=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_5);
	}
	if(actual_OHRM_Url.equals(RC_1_6)) {
	Cell cellc_8=row1_LogIn.createCell(8);
	cellc_8.setCellValue("       PASS");
	FileOutputStream test_Result_1_8=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_8);

	}
	else {
	Cell cellc_8=row1_LogIn.createCell(8);
	cellc_8.setCellValue("       FAIL");
	FileOutputStream test_Result_1_8=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_8);
	}
	if(again_actual_Login_Panel_Text.equals(RC_1_14)) {



	Cell cellc_16=row1_LogIn.createCell(16);
	cellc_16.setCellValue("       PASS");
	FileOutputStream test_Result_1_16=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_16);

	}
	else {
	Cell cellc_16=row1_LogIn.createCell(16);
	cellc_16.setCellValue("       FAIL");
	FileOutputStream test_Result_1_16=new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
	workbook_LogIn.write(test_Result_1_16);
	}

	
}
}
