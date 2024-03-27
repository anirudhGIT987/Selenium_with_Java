package com.Assignments;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class gmail_Text {
public static void main(String[] args) {
	WebDriver driverC;
	String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPersonalDetails/empNumber/0006";
	
	System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	driverC= new ChromeDriver();
	
	driverC.get(OrangehrmWebApplicationUrl);
	
	
	/*
	By userNameProperty=By.name("txtUsername");
	WebElement userName=driverC.findElement(userNameProperty);
	userName.sendKeys("AnirudhHRM");
	
	By passwordProperty=By.name("txtPassword");
	WebElement password=driverC.findElement(passwordProperty);
	password.sendKeys("Ohrm@987");
	
	By loginButtonProperty=By.className("button");
	WebElement loginButton=driverC.findElement(loginButtonProperty);
	//System.out.println(loginButton.getText());
	loginButton.click();
	
	
	
	By headerProperty=By.className("menu");
	WebElement header=driverC.findElement(headerProperty);
	List<WebElement>headerElements=header.findElements(By.tagName("a"));
	
	int headerLinksNumber=headerElements.size();
	System.out.println(headerLinksNumber);
	
	/*for(int index=0; index<headerElements.size();index++)
	{
		String nameLinks=headerElements.get(index).getText();
		System.out.println(index +" "+ nameLinks);
	}
	
	int index=0;
	while(index<headerElements.size())
	{
		String nameLinks=headerElements.get(index).getText();
		System.out.println(index +" "+ nameLinks);
		index++;
	}
	*/
	
	
	
	
	
	
	
	/*WebDriver driveredge;
	String amazonUrl = "https://www.amazon.in/";
	System.setProperty("webdriver.edge.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\msedgedriver.exe");
	driveredge = new EdgeDriver();
	
	driveredge.get(amazonUrl);
	
	//<span class="nav-line-2">&amp; Orders<span class="nav-icon nav-arrow"></span></span>
	
	By property=By.className("nav-line-2");
		WebElement order=driveredge.findElement(property);
		System.out.println(driveredge.getTitle());
	
		By idProp=By.id("nav-orders");
		
		
		
		//<a href="/gp/css/order-history?ref_=nav_orders_first" class="nav-a nav-a-2   nav-progressive-attribute" id="nav-orders" tabindex="0">
		  <span class="nav-line-1">Returns</span>
		  <span class="nav-line-2">&amp; Orders<span class="nav-icon nav-arrow"></span></span>
		</a>
	
	/*		
	nav-cart-text-container
	
	By iProp=By.linkText("Images");
	WebElement image =driver.findElement(iProp);
	*/
	
	
}
}
