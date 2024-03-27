package com.Assignments;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot_tsrtc_HeaderBlock_Elements {
	//Global Variables
		WebDriver driver;

	
	//User Defined Methods
	public void applicationLaunch()	//with No parameters, but with Local Variables
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		String tsrtcWebApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		driver.navigate().to(tsrtcWebApplicationUrl);
	}
	
	void closingApplication()
	{
		driver.quit();
	}
	
	public static void main(String[]args) throws IOException
	{
		ScreenShot_tsrtc_HeaderBlock_Elements scrsht = new ScreenShot_tsrtc_HeaderBlock_Elements();
		scrsht.applicationLaunch();
		try{
			scrsht.headerLinks();
		}catch(Exception errorStorage)
		{
			System.out.println("The Exception is:- "+errorStorage);
		}
		scrsht.closingApplication();
		/*try {
			scrsht.headerLinks();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private void headerLinks() throws IOException, InterruptedException
	{
		WebElement header=driver.findElement(By.className("menu-wrap"));
		List<WebElement>headerLinks=header.findElements(By.tagName("a"));
		int headerLinksCount=headerLinks.size();
		System.out.println("The total Links Count of tsrtc_HeaderBlock is :- "+headerLinksCount);
		for(int i = 0; i<headerLinksCount; i++)
		{
			String headerLinksName=headerLinks.get(i).getText();
			System.out.println(i+" "+headerLinksName);
			headerLinks.get(i).click();
			Thread.sleep(2999);
			File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ss, new File("D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\SnapShots\\TSRTCHeaderLink"+i+" "+headerLinksName+".png"));
			driver.navigate().back();
			header=driver.findElement(By.className("menu-wrap"));
			headerLinks=header.findElements(By.tagName("a"));

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
