package com.Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_OrangeHrm_Login_EMpData_List_Excel extends Excel_AddEmployee_Mutli_EmployeeCredentials{
		
		
		
	@Test(priority=2, description="Registered Employee List Table")
		public void registeredEmployeeDetailsTable() throws IOException {
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
			
		}
		
		
	
	
	
	
	
}
