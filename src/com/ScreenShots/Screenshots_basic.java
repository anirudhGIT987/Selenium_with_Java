package com.ScreenShots;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Assignments.WorldClock_CityName;

public class Screenshots_basic {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	String eenaduWebApplicationUrl="https://mictests.com/";
				

		driver = new ChromeDriver(options);
		driver.get(eenaduWebApplicationUrl);
		System.out.println("The title of the WebPage is :- "+driver.getTitle());
		
	/*	
		//To take Screenshot of the Page this is the Script
		//TakesScreenshot)driver
		//(TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//(Data Type) File variableName=
		//FileUtils.cpoyFile(source(variableName), new File(Destination));
		File screenSnap=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenSnap, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\eenaduHomePage.png"));
			
		System.out.println("Screenshot captured Successfully");
		// Selenium webdriver runs super fast, such that it sometimes misses the elements and throws exception as no such element found
		Thread.sleep(2000);
		// for 5 seconds nearly we tell the Webdriver to sleep and then perform the actions
		// so that the websites gets time to load popup after loading of page
	System.out.println("SLept for 5000milliseconds");	
		Robot robo = new Robot();
		//Thread.sleep(0);
		robo.keyPress(KeyEvent.VK_TAB);
	//	Thread.sleep(5500);
		//robo.keyPress(KeyEvent.VK_TAB);
		//Thread.sleep(2500);

	robo.keyPress(KeyEvent.VK_ENTER);
		//driver.close();
	System.out.println("performed popup handling successfully");	
		
//	String eenaduWebApplicationUrl="https://eenadu.net";
		//String eenaduWebApplicationUrl="https://www.downtoearth.org.in/";
		
	*/
	
	}
	
}
