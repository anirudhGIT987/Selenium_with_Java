package com.BrowsersAutomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class UNEP_LinksCount_SingleBlock {
public static void main(String[] args) {
	
	WebDriver driver;
	String Url="https://unep.org";
	System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(Url);
	
	
	
	WebElement header=driver.findElement(By.className("gwm_ts_header"));
	List<WebElement>headerL=header.findElements(By.tagName("a"));
	int hc=headerL.size();
	System.out.println(headerL.size());
	for(int index= 0;index<hc;index++)
	{
		System.err.println(index+ " "+headerL.get(index).getText());
	}
	/*
	By linkElementsProperty=By.tagName("a");
	List<WebElement>linkElements=driver.findElements(linkElementsProperty);
	long linksCount=linkElements.size();
	System.out.println(linksCount);
	for(int index= 0;index<linksCount;index++)
	{
		System.err.println(index+ " "+linkElements.get(index).getText());
	}
	*/
	//driver.quit();
	
	
}
}
