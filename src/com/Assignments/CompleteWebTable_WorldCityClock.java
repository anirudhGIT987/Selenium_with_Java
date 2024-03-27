package com.Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompleteWebTable_WorldCityClock extends WebTable_WorldClock_CityNames_FirstCol{

	
	public void completeWebTable() throws IOException {		
		
		//		/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]

		// As this is the Xpath of the last test Data of the current Web TAble,
// From the xpath, it is clear that there are 36 rows and 8 row of cells made by the Developer.
		
		// To get all the elements from the WebTable in a single Shot we have to make 
	// a nested FOr loop as we have dome for Multi Dimesnional Arrays & Multi Data input from Excel

		
		FileInputStream completeWebTable = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\WorldClock_COuntries.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(completeWebTable);
		XSSFSheet webTableSheet = workBook.getSheet("Sheet1");
		
System.out.println("Application Launched");	
	
		//Creating Headings on First Row--0 index		
	Row row0=webTableSheet.createRow(0);
	//Entering Headings 
			for(int i=1; i<=8; i+=2)
		{
			row0.createCell(i).setCellValue("City");	
		}
		for(int index = 2; index<=8; index+=2 )
		{
			row0.createCell(index).setCellValue("Clock");	
		}
			// Loop for Row
		for(int rowIndex = 1; rowIndex<=36; rowIndex++)
		{
							Row newRow= webTableSheet.createRow(rowIndex);
//System.out.println("Done with outer rowIndex:- "+rowIndex+" Loop");			
			
				// Making a nested Loop for Row of Cell
			for(int rowOfCellIndex=0; rowOfCellIndex<=8; rowOfCellIndex++)
			{
				By cityProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+rowOfCellIndex+"]");
				WebElement city=driver.findElement(cityProperty);
				String cityName=city.getText();
//If we've written line 36 here- then it would create every time new row for every time Cell is called.s
							Cell newCell=newRow.createCell(rowOfCellIndex);
							newCell.setCellValue(cityName);
// We have to make the result in console too in as Rows and Colums
System.out.print(cityName +" | ");	


			
			}
			System.out.println();
		}
		
		FileOutputStream cityClocksResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\world_CityClocks.xlsx");
		workBook.write(cityClocksResult);

	}	
		public static void main(String[]args) throws IOException {
			CompleteWebTable_WorldCityClock fullTable = new CompleteWebTable_WorldCityClock();
			fullTable.applicationLaunch();
			fullTable.completeWebTable();
			
			fullTable.applicationClose();
		}
		
		
	
	
	
	
		
}
