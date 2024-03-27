package com.BrowsersAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Junk {

	WebDriver driver;
	String applicationUrl="https://echoecho.com/htmlforms10.htm";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");
		//driver = new FirefoxDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.get(applicationUrl);
	
	}
	@Test
	public void testing() {

		//After getting into the website, look for the radio buttons common property
		

	//List<WebElement>rowProperty=radioButtonsTable.findElements(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr"));
//System.out.println("Row COunt in the Table is:- "+rowProperty.size());

		
		//for(int buttonIndex=)
		By group1RadioButtonProp=By.name("group1");
		List<WebElement>group1RadioButton=driver.findElements(group1RadioButtonProp);
		for(int buttonIndex=0; buttonIndex<group1RadioButton.size(); buttonIndex++)
		{
			WebElement currentButton=group1RadioButton.get(buttonIndex);
			Boolean displayStatus=currentButton.isDisplayed();
			String radioButtonName=group1RadioButton.get(buttonIndex).getAttribute("value");
			if(displayStatus==true) 
			{
System.out.println(radioButtonName+" is displayed");					
				currentButton.click();
				Boolean selectionStatus=currentButton.isSelected();
				if(selectionStatus==true) {
System.out.println(radioButtonName+" is selected");					
				}
				for(int validationIndex =0; validationIndex<group1RadioButton.size(); validationIndex++)
				{
					radioButtonName=group1RadioButton.get(validationIndex).getAttribute("value");
					String status=group1RadioButton.get(validationIndex).getAttribute("checked");
System.out.println(radioButtonName+" "+status);

				}
System.out.println();
			}
			else{
System.out.println("RadioButton"+buttonIndex+" is not displayed");						
			}

		}
		
	
		
		
	}
	
	
	
}
