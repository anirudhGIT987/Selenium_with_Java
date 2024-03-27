package com.Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_WorldClock_CityNames_FirstCol  {
			WebDriver driver;
			
	
	public void applicationLaunch() {
			
		String worldClockUrl="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(worldClockUrl);
	}
/*	public static void FileInput() throws FileNotFoundException {
		FileInputStream xcel = new FileInputStream("./src/com/Excel/Data/Read/WorldClock_COuntries.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheetAt(1);
		XSSFRow row1=sheet.getRow(1);
	}*/
	public void CityClockTable() throws IOException {
		
		int rowCount=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr")).size();
System.out.println("The No. of rows in the table:- "+rowCount);
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
	
		//String beforeXpath = "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		//String afterXpath = "]/td[1]";
		
	FileInputStream xcel = new FileInputStream("./src/com/Excel/Data/Read/New Microsoft Excel Worksheet.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.getSheet("Sheet1");


		for(int rowIndex=1; rowIndex<=rowCount;rowIndex++)
		{	
			String actualXpath = "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td[1]";
			WebElement cityElement=driver.findElement(By.xpath(actualXpath));
			String cityName=cityElement.getText();
System.out.println(cityName);
			
//sheet.createRow(rowIndex).createCell(0).setCellValue(cityName);
			Row newRow=sheet.createRow(rowIndex);
			Cell newRowOfCell=newRow.createCell(0);
		newRowOfCell.setCellValue(cityName);
			
		}
		FileOutputStream cityNamesFirstCol = new FileOutputStream("./src/com/Excel/Result/Input/WorldClock_FirstCol_Countries.xlsx");
		wb.write(cityNamesFirstCol);
		
	}
	
		void applicationClose() {
		driver.quit();
	}
	
		
		public static void main(String[] args) throws IOException {
			
			WebTable_WorldClock_CityNames_FirstCol  firstCol= new WebTable_WorldClock_CityNames_FirstCol();
			firstCol.applicationLaunch();
			firstCol.CityClockTable();
			firstCol.applicationClose();
		}
	
	
	
	
}
