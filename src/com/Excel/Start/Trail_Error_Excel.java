package com.Excel.Start;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trail_Error_Excel {
	public static void main(String[] args) throws IOException{
		
		FileInputStream xcel = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\LogInTest.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(xcel);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		Row sheetRow=sheet.getRow(1);
		Cell rowCell=sheetRow.getCell(0);
		RichTextString inputData=rowCell.getRichStringCellValue();
		
		System.out.println(inputData);
		System.out.println(rowCell.getStringCellValue());
		
		
		WebDriver driver;
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(OrangehrmWebApplicationUrl);
		
		By loginpanelHeadingProperty=By.id("logInPanelHeading");
		WebElement loginPanelHeading=driver.findElement(loginpanelHeadingProperty);
		
	//	String expectedLoginPanelText=expectedLoginPanelExcelData;
		//System.out.println("The Expected LoginPanel from Excel file is :- "+expectedLoginPanelExcelData );
		
		String actualLoginPanelText=loginPanelHeading.getText();
		System.out.println("The Actual LoginPanel Text is :- "+ actualLoginPanelText);
		
		//Update the data into the existing cell of the Excel File
				//Row rowIndex=sheet.getRow(1);
				//Identify the row of cell
				//Cell cellIndex=rowIndex.getCell(1);
				 				
		 sheet.getRow(1).getCell(7).setCellValue(actualLoginPanelText);  // Access the second cell in second row to update the value
		 
		
		 
				//save the file
		FileOutputStream outputFile = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\LogInTest.xlsx");
		workBook.write(outputFile);

		
			
		
	}
		
	
	
	
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
        

