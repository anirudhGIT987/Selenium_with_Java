package com.Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityClocks_Dynamic_WebTable {
	WebDriver driver;
	
	public void applicationLaunch() {
		
		String worldClockUrl="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(worldClockUrl);
	}
	
	public void webTable_Data() throws IOException {
		
		//  /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[13]/td[5]
		//	/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th/h3
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
//Tag Name tr and td with webtable declaration or xpath of tr and td
		
	 //head xpath By rowProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th");
		By rowProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
		List<WebElement>rows=driver.findElements(rowProperty);
		int rowCount=rows.size();
System.out.println("The total No.of Rows in table :- "+rowCount);	
		for(int index=0; index<rowCount; index++)
		{
			String data=rows.get(index).getText();
System.out.print(data+"|");
		}
System.out.println("Space is given");
		
		By tdProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td");
		List<WebElement>rowOfCell=driver.findElements(tdProperty);
		int rowOfCellCount=rowOfCell.size();
System.out.println("The no.of Cells is:- "+rowOfCellCount);		
		for(rowindex =1)


			for(int cindx=0; cindx<rowOfCellCount; cindx++)
		{
		String data=rowOfCell.get(cindx).getText();
System.out.print(data+"|");
		}
		*/
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th
		
		
		By rowProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
		List<WebElement>rows=driver.findElements(rowProperty);
		int rowCount=rows.size();
System.out.println("The total No.of Rows in table :- "+rowCount);	
		for(int index=0; index<rowCount; index++)
		
			
		By tdProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td");
		List<WebElement>rowOfCell=driver.findElements(tdProperty);
		int rowOfCellCount=rowOfCell.size()	;
			
		// /html/body/div[5]/section[1]/div/section/div[1]
		By webTableProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]");
		WebElement cityClockTable=driver.findElement(webTableProperty);
		Dimension dim=cityClockTable.getSize();
System.out.println("Size of the webTable is:- "+dim);		
		
 		/*By headerProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th");
 		List<WebElement>headerElements=driver.findElements(headerProperty);
 		int thCount=headerElements.size();
 System.out.println("No. of Header Elements :- "+thCount);		
	*/	By rowProperty=By.tagName("tr");
		List<WebElement>rows=cityClockTable.findElements(rowProperty);
		int activeRowsCount=rows.size();
System.out.println("Active Rows are:- "+activeRowsCount);

			/*	By cellProp=By.tagName("td");	
				List<WebElement>cells=driver.findElements(cellProp);
				int cellC=cells.size();
System.out.println("No. of cells are :- "+cellC);				

						
				for(int ci=0; ci<cellC; ci++) {
					String data=cells.get(ci).getText();
System.out.print(data+" | ");					
					}
System.out.println();				
				*/
FileInputStream completeWebTable = new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\WorldClock_COuntries.xlsx");
XSSFWorkbook workBook = new XSSFWorkbook(completeWebTable);
XSSFSheet webTableSheet = workBook.getSheet("Sheet1");

for(int rowindex=0; rowindex<activeRowsCount; rowindex++)
{	Row newRow= webTableSheet.createRow(rowindex);


	By cellProp=By.tagName("td");
	List<WebElement>cells=rows.get(rowindex).findElements(cellProp);
	
	for(int cellindex=0; cellindex<cells.size(); cellindex++)
	{
		String data=cells.get(cellindex).getText();
		Cell newCell=newRow.createCell(cellindex);
		newCell.setCellValue(data);
System.out.print(data+" | ");				
	}
System.out.println();			
}
FileOutputStream cityClocksResult = new FileOutputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Result\\Input\\dynamic_world_CityClocks.xlsx");
workBook.write(cityClocksResult);

				
		

		










/*



By columnProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td");
		List<WebElement>columns=cityClockTable.findElements(columnProperty);
		int cellsCount=columns.size();
System.out.println("Total No.of Columns are:- "+cellsCount);		
		
for(int rowindex=1; rowindex<activeRowsCount; rowindex++)
		{
			for(int cellindex=0;cellindex<cellsCount; cellindex++) {
					WebElement rowOfCell=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowindex+"]/td["+cellindex+"]"));
					String tableData=rowOfCell.getText();
System.out.print(tableData+" | ");					
			}
System.out.println();
		}






/*	By columnProperty=By.tagName("td");
		List<WebElement>columns=cityClockTable.findElements(columnProperty);
		int cellsCount=columns.size();
System.out.println("Total No.of Columns are:- "+cellsCount);		
	for(int r=0;r<activeRowsCount;r++) {
			
			
			String rowsText=rows.get(r).getText();
System.out.println(r+" "+rowsText);			
		}*/
		
	}
	
	
	
	
	public static void main(String args[]) throws IOException {
		
		CityClocks_Dynamic_WebTable dynamicTable = new CityClocks_Dynamic_WebTable();
		dynamicTable.applicationLaunch();
		dynamicTable.webTable_Data();
		
	}
	
	
	
	
	
	
	
}
