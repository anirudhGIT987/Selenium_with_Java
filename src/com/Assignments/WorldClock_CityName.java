package com.Assignments;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WorldClock_CityName {

	  WebDriver driver;
	
	public void applicationLaunch() {
			
		String worldClockUrl="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(worldClockUrl);
	}
	
	public void webTable() {
		int rowsCount=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr")).size();

		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		String beforeXpath = "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String afterXpath = "]/td[1]";
		for(int r=1; r<=rowsCount;r++)
		{
			String actualXpath = beforeXpath+r+afterXpath;
			WebElement country=driver.findElement(By.xpath(actualXpath));
			System.out.println(country.getText());
		}
		
		/*int rows=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr")).size();
System.out.println("The no.of Rows is:- "+rows);				
		int cells=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td")).size();
		System.out.println("The no.of Cells is:- "+cells);
		
		
		
		for(int rowindex = 1; rowindex<rows; rowindex++)
		{
			String data=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowindex+"]/td[0]")).getText();
			System.out.println(data);
		}*/
		/*
		By webTableProperty=By.xpath("/html/body/div[5]/section[1]/div");
		WebElement webTable=driver.findElement(webTableProperty);
//Dimension tableSize=webTable.getSize();
//System.out.println(tableSize);
			By rowProperty=By.tagName("tr");
			
			List <WebElement>rowList=webTable.findElements(rowProperty);
			int rowCount=rowList.size();
			System.out.println("No of rows is :"+rowCount);
			//String rowsText=rowsList.get(0).getText();
			By cellProperty=By.tagName("td");
			List <WebElement>rowOfCells=rowList.get().findElements(cellProperty);

			/*for(int ri = 1; ri<rowList.size(); ri++)
			{
				
				//String rElements=rowList.get(ri).getText();
				//System.out.println(rElements);
			
			
			//currentRow=rowsList.get(ri);
				By cellProperty=By.tagName("td");
				//List <WebElement>cellList=webTable.findElements(cellProperty);
				
				List <WebElement>rowOfCells=rowList.get(ri).findElements(cellProperty);
			
				String countryText=rowOfCells.get(0).getText();
				
				//sheet.getRow(rowindex).getCell(0).getStringCellvalue;
				
				for(int roc = 0; roc==0;) {
	
					String text=rowOfCells.get(roc).getText();
					System.out.println(text);
					System.out.println();
				}
			}	
			
		
	*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorldClock_CityName obj =  new WorldClock_CityName();
		obj.applicationLaunch();
		obj.webTable();
			
	}

}
