package com.BrowsersAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trail_Error {
	

public static void main(String[] args) {
	 WebDriver driver;
	 String url="https://www.aqi.in/";
		System.setProperty("webdriver.chrome.driver","./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
	/*	List<WebElement> table=driver.findElements(By.tagName("table"));
		System.out.println(table.size());
				for(int i=0;i<table.size();i++)
				{
					String txt=table.get(i).getText();
//Gave the elements with table as atag name
					System.out.println(txt);
				}*/

		///html/body/main/div[2]/div/div/div/div[2]
		////*[@id="real-box"]/div[2]
		
		//		//*[@id="citytabledata"]/table/tbody/tr[7]/td[1]
		//			//*[@id="citytabledata"]/table/thead/tr/th[1]
		//		/html/body/main/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/table/thead/tr/th[7]/h2
		
		
				///html/body/main/div[2]/div/div/div/div[2]--- xpath of table
		//		/html/body/main/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/table/tbody/tr[8]/td[8]
		// /html/body/main/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/table/thead/tr/th[1]
				List<WebElement>rowL=driver.findElements(By.xpath("//*[@id=\"citytabledata\"]/table/tbody/tr"));
		int rowCount=rowL.size();
System.out.println("Row Count is :- "+rowCount);
	
				List<WebElement>cellL=driver.findElements(By.xpath("//*[@id=\"citytabledata\"]/table/thead/tr[1]/th"));
			int cellCount =cellL.size();
			System.out.println("Cell Count is:- "+cellCount);
			
			WebElement tableAqi=driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]"));
			By rowProp=By.tagName("tr");
			List<WebElement>rows=tableAqi.findElements(rowProp);
			int rowC=rows.size();
System.out.println("rowC :-"+ rowC);

	}
}
