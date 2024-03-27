package com.BrowsersAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Login{
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		String OrangehrmWebApplicationUrl="https://www.facebook.com/";
		driver.get(OrangehrmWebApplicationUrl);
		
		WebElement userId=driver.findElement(By.id("email"));
		userId.sendKeys("8008060016");
		WebElement pword=driver.findElement(By.id("pass"));
		pword.sendKeys("Nhanna@48");
		WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"));
		login.click();
	
		
	}
	
	
}