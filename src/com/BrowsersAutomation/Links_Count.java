package com.BrowsersAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links_Count {
public static void main(String[] args) {
		
		
	WebDriver driver;
	
	/*
	String imdUrl="https://mausam.imd.gov.in/";
	
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");

	driverC = new ChromeDriver();
	driverC.get(imdUrl);
		By linkProp=By.tagName("a");
	List<WebElement>links=driverC.findElements(linkProp);
	int linksCount=links.size();
	System.out.println(linksCount);
	for(int i=0; i<linksCount;i+=1)
	{
		String linksText=links.get(i).getText();
		System.out.println(linksText);
	}
	*/
	String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
	System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");

	driver = new ChromeDriver();
	
	driver.get(applicationUrlAddress);


	// Identifying the Header Block of the WebPage
	// class="menu-wrap" - property of the Header Block
	By tsrtc_HeaderBlockProperty=By.className("menu-wrap");
	WebElement tsrtc_HeaderBlock=driver.findElement(tsrtc_HeaderBlockProperty);


	// identify the elements of the TSRTC Header Block
	// <a class="selectedtabcopy" href="/oprs-web/guest/home.do?h=1" target="_top" title="Home"> Home</a>
	// <a class="tabcopy blinking" href="/oprs-web/guest/specialHire.do" target="_top" title="Bus on Contract">Bus on Contract</a>
	// <a class="tabcopy" href="/oprs-web/guest/ticket/cancel.do" target="_top" title="Cancel Tickets">Cancel Tickets</a>

	By linksProperty=By.tagName("a");
	List<WebElement>tsrtc_HeaderBlockLinks=tsrtc_HeaderBlock.findElements(linksProperty);

	// finding the size of the ArrayList(tsrtc_HeaderBlockLinks)
	int tsrtc_HeaderBlockLinksCount=tsrtc_HeaderBlockLinks.size();
	System.out.println(" The number of elements of type links in the Header Block of TSRTC Application HomePage are :- "+tsrtc_HeaderBlockLinksCount);

	for(int index=0;index<tsrtc_HeaderBlockLinksCount;index++)
	{
	String tsrtc_headerBlockLinkName=tsrtc_HeaderBlockLinks.get(index).getText();
	System.out.println(index+" "+tsrtc_headerBlockLinkName);
	tsrtc_HeaderBlockLinks.get(index).click();

	String webPageTitle=driver.getTitle();
	System.out.println(webPageTitle);

	String actual_webPageCurrentUrlAddress=driver.getCurrentUrl();
	System.out.println("The Actual Url Address of the links of the WebPage is :- "+actual_webPageCurrentUrlAddress);

	System.out.println();

	driver.navigate().back();

	tsrtc_HeaderBlock=driver.findElement(tsrtc_HeaderBlockProperty);
	tsrtc_HeaderBlockLinks=tsrtc_HeaderBlock.findElements(linksProperty);

	}

	driver.quit();

	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
