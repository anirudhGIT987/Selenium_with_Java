package com.Assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;



public class TSRTC_HomePage_HeaderBlockElements {
	public static void main(String[]args){
		
		WebDriver driver;
		String tsrtcWebApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		//System.setProperty("webdriver.gecko.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\geckodriver.exe");
	//driver = new FirefoxDriver();
	
	System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(tsrtcWebApplicationUrl);
		
			/*		//Total Number of Link Elements in TSRTC HomePage
		By linkElementsCommonProperty=By.tagName("a");
		List<WebElement>linkElements=driver.findElements(linkElementsCommonProperty);
		int headerBlockLinksCount=linkElements.size();
		System.out.println("The total number of link Elements in TSTRC HomePage is: "+headerBlockLinksCount);
		
		
		int index =0;
		while(index<linkElements.size())
		{
			String linksText=linkElements.get(index).getText();
			System.out.println(index+" "+linksText);
			index++;
		}
		System.out.println();
		*/
				//TSRTCwebApplication HeaderBlock Elements Validation
		
		By tsrtc_WebApplication_HeaderBlockProperty=By.className("menu-wrap");
		WebElement tsrtc_WebApplication_HeaderBlock=driver.findElement(tsrtc_WebApplication_HeaderBlockProperty);
		
		By headerBlockLinksProperty=By.tagName("a");
			//Now we are not finding on driver, but only on HeaderBlock.
		List<WebElement>headerBlockLinksList=tsrtc_WebApplication_HeaderBlock.findElements(headerBlockLinksProperty);
		System.out.println("The total number of Link Elements in HeaderBlock is: "+headerBlockLinksList.size());
		
		System.out.println();
		
		byte position = 0;
		while(position<headerBlockLinksList.size())
		{
			String headerBlockLinkName=headerBlockLinksList.get(position).getText();
			System.out.println(position+" "+headerBlockLinkName);
			
			headerBlockLinksList.get(position).click();
			String actualWebPageTitle=driver.getTitle();
			System.out.println(actualWebPageTitle);
		
			String expectedWebPageTitle=driver.getTitle();
			System.out.println(expectedWebPageTitle);
			
		if(actualWebPageTitle.contains(expectedWebPageTitle))
		{	
			System.out.println("The Actual Result of the above Link Element's WebPage Title is matched with the Expected WebPage Title :- Pass");
		}
		else 
		{
			System.out.println("The Actual Result of the above Link Element's WebPage Title is not matched with the Expected WebPage Title :- Fail");
		}
			System.out.println();
			
			String actualCurrentUrl=driver.getCurrentUrl();
			System.out.println("The actual URL Address of the above Link Element's WebPage is:- "+actualCurrentUrl);
		
			String expectedCurrentUrl=driver.getCurrentUrl();
			System.out.println("The expected URL Address of the above Link Element's WebPage is: "+expectedCurrentUrl);
		
		if(actualCurrentUrl.equals(expectedCurrentUrl))
		{
			System.out.println("The Actual Result of URL Address of above the Link Element's WebPage is matched with the Expected Result :- Pass");
		}
		else
		{
			System.out.println("The Actual Result of URL Address of the above Link Element's WebPage is not matched with the Expected Result:- Fail");

		}
		System.out.println();
		System.out.println();
			
		driver.navigate().back();
		 tsrtc_WebApplication_HeaderBlock=driver.findElement(tsrtc_WebApplication_HeaderBlockProperty);
		headerBlockLinksList=tsrtc_WebApplication_HeaderBlock.findElements(headerBlockLinksProperty);

			position++;	
		}
		System.out.println("Validation of TSRTC HeaderBlock Link Elements is Completed");
		driver.quit();
	}
	
}	
		
		
		
		
		
		/*Not getting texts of elements when using for-each loop
		for(Object ind:linkElements)
		{
			System.out.println(ind);
		}
		*/
		//for(int index=0;index<linkElements.size();index++)
		//{	
			//String linkElementsText=linkElements.get(index).getText();
			//System.out.println(index+" "+linkElementsText);
		//}
		
		
		
		
		
		
		
	

