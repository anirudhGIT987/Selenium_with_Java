package com.BrowsersAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
	public static void main(String[] args) {

		WebDriver driver;
	String gmailWebApplicationUrl="https://www.eenadu.net/";
	
	System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get(gmailWebApplicationUrl);
	/*By SigninElementProperty=By.linkText("Sign in");
	WebElement Signin=driver.findElement(SigninElementProperty);
	
	String SigninText=Signin.getText();
	System.out.println("THe text of Signin element on UI is :-"+ SigninText);
	
	String SigninAttribute=Signin.getAttribute("Class");
	System.out.println("The attribute value of class of Signin element is :-"+ SigninAttribute);
	
	
	
	driver.quit();
	*/
	}
	
	
}
