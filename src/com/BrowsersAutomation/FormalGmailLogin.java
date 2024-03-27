package com.BrowsersAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormalGmailLogin {
	 
		   protected static WebDriver driver;

		   protected static String result;

		  // @BeforeClass

		   public static void setup()  {
		              System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");

		   driver = new ChromeDriver();

		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		  }

		   //@Test

		 void Testcase1() {

		   driver.get("http://mail.google.com");

		   WebElement loginfield = driver.findElement(By.name("Email"));
		   if(loginfield.isDisplayed()){
		       loginfield.sendKeys("ragesh@gmail.in");
		   }
		   else{
		  WebElement newloginfield = driver.findElemnt(By.cssSelector("#identifierId"));                                      
		       newloginfield.sendKeys("ragesh@gmail.in");
		      // System.out.println("This is new login");
		   }


		    driver.findElement(By.name("signIn")).click();

		  // driver.findElement(By.cssSelector(".RveJvd")).click();

		   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 // WebElement pwd = driver.findElement(By.name("Passwd"));
		  WebElement pwd = driver.findElement(By.cssSelector("#Passwd"));

		  pwd.click();
		  pwd.clear();
		 // pwd.sendKeys("123");
		 if(pwd.isEnabled()){
		     pwd.sendKeys("123");
		 }
		 else{
		     System.out.println("Not Enabled");
		 }
		
		   

