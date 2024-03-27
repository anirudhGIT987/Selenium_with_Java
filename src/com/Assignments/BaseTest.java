package com.Assignments;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Utility.LogUtility;
import com.Utility.Log_Utility;

public class BaseTest {
	
	public static WebDriver driver;
	String orangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
LogUtility.info("********* Chrome Browser Launched Successfully ******** ");
		driver.get(orangehrmWebApplicationUrl);
LogUtility.info("Successfully Navigated to OrangeHRM Application ");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
LogUtility.info("" **** Chorme Browser Closed with the OrangeHRM Application Successfully *******");		
	}
	
	
}
