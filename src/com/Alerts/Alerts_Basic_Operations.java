package com.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Basic_Operations {
	
	// Basically alerts are different from popups
	//Confirmation alerts, sendkeys alerts etc.,
	WebDriver driver;
	String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

	public void applicationLaunch()
	{
	// Automating the Chrome Browser
	System.setProperty("webdriver.chrome.driver", "./BrowserDriver_Files/chromedriver.exe");
	driver = new ChromeDriver();

	driver.get(applicationUrlAddress);

	}

	public void applicationClose()
	{
	driver.quit();
	}

	public void handlingAlert() throws InterruptedException
	{

	// id="searchBtn"
	By checkAvailabilityProperty=By.id("searchBtn");
	WebElement checkAvailability=driver.findElement(checkAvailabilityProperty);
	checkAvailability.click();

	Thread.sleep(5000);

	// moving to an alert window
	Alert alertWindow=driver.switchTo().alert();


	String alertWindowTextMessage=alertWindow.getText();
	System.out.println(" The text of an alert window is :- "+alertWindowTextMessage);


	alertWindow.accept(); // will perform operation on the OK button

	// alertWindow.dismiss(); // will perform operation on the Cancel button

	// alertWindow.sendKeys("Testing"); // will perform operation to send the test data into alert

	}

	public static void main(String[] args) throws InterruptedException {

		Alerts_Basic_Operations handling = new Alerts_Basic_Operations();

	handling.applicationLaunch();
	handling.handlingAlert();

	}

}

