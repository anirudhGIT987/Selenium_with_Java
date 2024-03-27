package com.Excel.Start;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.UserDefined_Methods.UserDefined_Methods_Basics;


public class Excel_Read_Selenium {
public static void main(String[] args) throws IOException {
	
	FileInputStream xcel = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Start\\ExcelReadWrite.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(xcel);
	XSSFSheet xcelsheet = workBook.getSheet("Sheet1");
 
int rowCount=xcelsheet.getLastRowNum();
	int cellCount=xcelsheet.getRow(1).getLastCellNum();
	System.out.println(rowCount);
	System.out.println(cellCount);
	
	for(int i =1; i<rowCount; i++)
	{	XSSFRow currentRow=xcelsheet.getRow(i);
	
			for(int j=0; j<cellCount; j++)
		 {
				String currentCell=currentRow.getCell(j).getStringCellValue();

				System.out.print(currentCell+"||");
			
		}
	}

	
	
	
	
	/*
	//We have to make the Webdriver to accept the Files from system
	FileInputStream testDataFile = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Assignments\\LogInTest.xlsx");
	
	//Identifying the WorkBook in the excel file
	XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
	
	//Identifying the ParticularSheet in the Workbook
	XSSFSheet testDataSheet = workBook.getSheet("Sheet1");
	
	//Identifying the Row in the SHeet
	//Row testDataSheetRow=testDataSheet.getRow(3);
	int rowCount=testDataSheet.getLastRowNum();
	//Identifying the Row of Cell in the Row
	//Cell testDataSheetRowofCell=testDataSheetRow.getCell(0);
	int cellCount=testDataSheet.getRow(0).getLastCellNum();
	//Get the Data from the Cell
	
	for(int i =0; i<rowCount; i++)
	{
		XSSFRow currentRow=testDataSheet.getRow(i);
		
		for(int j =0; j<cellCount; j++)
			{
			String value =currentRow.getCell(j).getStringCellValue();
			System.out.println(" " +value);
			}
	}
	
	
	
	
	
	/*
	double testData=testDataSheetRowofCell.getNumericCellValue();
	System.out.println(testData);
	
	*/

	UserDefined_Methods_Basics objec1 = new UserDefined_Methods_Basics();

	
	
	
	
	
	
	
	
	
	
}

}
