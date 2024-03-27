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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHrm_FullEmployeeTable {
	WebDriver driver;
	
	void orangeHrmLaunch() {
		
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(OrangehrmWebApplicationUrl);
	}
	
	void LoginHrm() throws IOException {
		FileInputStream emptyTestFile= new FileInputStream("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\src\\com\\Excel\\Data\\Read\\New Microsoft Excel Worksheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(emptyTestFile);
		XSSFSheet inputDataSheet = workBook.getSheetAt(0);
		WebElement userNameElement=driver.findElement(By.id("txtUsername"));
		userNameElement.sendKeys("AnirudhHrm");
		String username=userNameElement.getAttribute("value");
		WebElement passwordElement=driver.findElement(By.id("txtPassword"));
		passwordElement.sendKeys("Ohrm@987");
		String password=passwordElement.getAttribute("value");
		driver.findElement(By.className("button")).click();
	
		By pim_LinkProp=By.id("menu_pim_viewPimModule");
		WebElement pim_Link_Element=driver.findElement(pim_LinkProp);
			Actions act = new Actions(driver);	
		act.moveToElement(pim_Link_Element).build().perform();
System.out.println("Hovered to Pim");		
		By employeeListProperty=By.linkText("Employee List");
		WebElement employeeList=driver.findElement(employeeListProperty);
		employeeList.click();System.out.println("Employee list is clicked");
		
		// Identify the table
		By empDetailsTableProperty=By.id("frmList_ohrmListComponent");
		WebElement empDetailsTable=driver.findElement(empDetailsTableProperty);
//	/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]
		// /html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th[2]
		
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
				String empdata=cell.getText();
				newRow.createCell(cellindex).setCellValue(empdata);
				
System.out.print(empdata+" | ");				
				
				
			}System.out.println();
		
		
		
		}
	
	FileOutputStream empDetailsList = new FileOutputStream("./src/com/Excel/Result/Input/Registered_OHRM_Employees_Table.xlsx");
	workBook.write(empDetailsList);
	
	
	}
	
	

	
	public static void main(String[] args) throws IOException {
		
		OrangeHrm_FullEmployeeTable empTable = new OrangeHrm_FullEmployeeTable();
		empTable.orangeHrmLaunch();
		empTable.LoginHrm();
		
		
		
		
	}
	
	
	
	
}
