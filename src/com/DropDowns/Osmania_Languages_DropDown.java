package com.DropDowns;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Assignments.BaseTest;

public class Osmania_Languages_DropDown extends BaseTest{
	
	@Test()
	public void dropDownSelection() throws IOException, InterruptedException {
		
		By dropDownProperty=By.id("gtranslate_selector");
	WebElement dropDown=driver.findElement(dropDownProperty);
	driver.manage().window().maximize();
//<option value="en|fr">French</option>	
	By languagesProperty=By.tagName("option");
	List<WebElement>languageElement=dropDown.findElements(languagesProperty);
	for(int drdindex =1; drdindex<languageElement.size(); drdindex++)
	{	String 	languageName=languageElement.get(drdindex).getText();
		//languageElement.get(drdindex).click();
		Select selection = new Select(dropDown);
		selection.selectByIndex(drdindex);
		Thread.sleep(3000);
		TakesScreenshot snap=((TakesScreenshot)driver);
		File srcFile=snap.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./SnapShots/"+drdindex+"OsmaniaWebPage_"+languageName+".png");
		FileUtils.copyFile(srcFile, destFile);
System.out.println(drdindex+" "+ languageName);		
		
		
	}
	
	
	
	
	
	
	}
	
	
}
