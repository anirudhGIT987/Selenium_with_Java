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


public class Excel_Write {
public static void main(String[] args) throws IOException {
	//Identify the File in a System
	/*FileInputStream testDataFile = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\ExcelReadWrite.xlsx");
	
	//Identify the Workbook in the Excel file as the file path is to excel
	XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
	
	//Identify the Sheet in the WB
	XSSFSheet testDataFileSheet = workBook.getSheet("Sheet1");
	
	//Create A row
	Row rowIndex=testDataFileSheet.createRow(5);
	//Create a row of cell
	Cell cellIndex=rowIndex.createCell(3).set
	
	//Set the Data
	cellIndex.setCellValue(45.5);
	
	//save the file
	FileOutputStream output = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\ExcelReadWrite.xlsx");
	workBook.write(output);
	*/
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	driver = new ChromeDriver();
	driver.get(OrangehrmWebApplicationUrl);
	
	By userProp=By.name("txtUsername");
	WebElement un=driver.findElement(userProp);
	String txt=un.getText();
	System.out.println(txt);
	String value=un.getAttribute("value");
	System.out.println(value);
	
	
	
	
	
	
	
}
}
