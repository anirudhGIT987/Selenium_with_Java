package com.BrowsersAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class StepByStep_WebPage_Navigation {
	public static void main(String[] args) {
		WebDriver driver;
		String applicationUrlAddress="http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe ");
		driver = new ChromeDriver();
		driver.navigate().to(applicationUrlAddress);
		
		
		//<a data-event-category="nav" data-event-action="click" data-event-label="subscribe-button" tabindex="0" theme="" href="/subscribe?itm_source=nav-button&amp;itm_medium=onsite&amp;itm_campaign=subscribe-BAU" class="homepageButton__primary--WE1_K homepageButton__wrapper--RLuyc homepageButton__brand--1NVWT homepageButton__navbar--346IM"><div class="homepageButton__content--3MXNx">Subscribe</div></a>
		
		//<input class="RNmpXc" value="I'm Feeling Lucky" aria-label="I'm Feeling Lucky" name="btnI" type="submit" jsaction="trigger.kWlxhc" data-ved="0ahUKEwiC8bG5hZ2BAxXN0mEKHaN5A2AQ19QECA8">
		
		//<a class="gb_wa gb_gd gb_Id gb_ge" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.co.in/%3Fgws_rd%3Dssl&amp;ec=GAZAmgQ" target="_top"><span class="gb_Dd">Sign in</span></a>
		
		
				
		
		//<a href="https://www.google.co.in/setprefs?sig=0_S-NiFH1AgGB0mEp2iChOqMCcrKk%3D&amp;hl=te&amp;source=homepage&amp;sa=X&amp;ved=0ahUKEwiC8bG5hZ2BAxXN0mEKHaN5A2AQ2ZgBCBM">తెలుగు</a>
		
		//a - is anchor tag
		// href-- attribute
		// whenever an element has an a tag and href attribute- confirm it as LINK TYPE ELEMENTrather than button.
		
		//Now we have to find the element.
		// Decide which locator must be used and store it in a variable.
		
		By teluguWebPageLinkProperty=By.linkText("తెలుగు");		
		
		WebElement teluguWebPage=driver.findElement(teluguWebPageLinkProperty);
		teluguWebPage.click();
		
		//<a class="gb_wa gb_gd gb_Id gb_ge" href="https://accounts.google.com/ServiceLogin?hl=te&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top"><span class="gb_Dd">సైన్ ఇన్</span></a>
		By teluguSigninLinkProperty=By.linkText("సైన్ ఇన్");
		WebElement teluguSignin=driver.findElement(teluguSigninLinkProperty);
		String teluguSigninText=teluguSignin.getText();
		System.out.println("The text of Telugu Signin Element is :- "+teluguSigninText);
	
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
