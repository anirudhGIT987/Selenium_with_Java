package com.Assignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Validating_Pages {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driverC;
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driverC= new ChromeDriver();
		
		driverC.get(OrangehrmWebApplicationUrl);
		//driverC.manage().window().maximize();
		
		
					//Validating the Title of OrangeHRM Homepage
				//FullName Expected Results
		String expectedHomePageTitle="OrangeHRM";
		System.out.println("THe expected title of OrangeHRM Homepage is :- "+expectedHomePageTitle );
		
		String actualHomePageTitle=driverC.getTitle();
		System.out.println("THe acutal title of OrangeHRM Homepage is :- "+ actualHomePageTitle);
		
		
		if(actualHomePageTitle.equals(expectedHomePageTitle)) {
			System.out.println("The Actual Result of HomePage Title is matched with the Expected result:- Passs");
		
		}
		//Whenever we've written if statement for positive test case, there must be else for negative test case
		else {
			System.out.println("The actual result of HomePage Title is not matched with the Expected result:- fail");
		}
					
							//End of Title Validation
		System.out.println();
	
				
					//Validating the URL of ORANGEHRM HomePage
		
		String expectedOrangehrmHomepageURL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.out.println("The Expected URL of Homepage is :- "+expectedOrangehrmHomepageURL );
		
		String actualOrangehrmHomePageURL=driverC.getCurrentUrl();
		System.out.println("The Actual URL of Homepage is :- "+actualOrangehrmHomePageURL);
		
		if(actualOrangehrmHomePageURL.contains(expectedOrangehrmHomepageURL))
		{	
			if(actualOrangehrmHomePageURL.equals(expectedOrangehrmHomepageURL))
			{
				System.out.println("The Acutal Result of OrangeHRM Homepage URL matches the Expected Result:- Pass");
			}
		}
			
		else {
			System.out.println("The Acutal Result of OrangeHRM Homepage URL does not matched with the Expected Result:- Fail");
		}
									//End of URL Validation
		System.out.println();
		
						// Validation of LoginPanel Text
		
		//find the element by its property
		By loginpanelHeadingProperty=By.id("logInPanelHeading");
		WebElement loginPanelHeading=driverC.findElement(loginpanelHeadingProperty);
		
		String expectedLoginPanelText="LOGIN Panel";
		System.out.println("The Expected LoginPanel Text is :- "+expectedLoginPanelText );
		
		String actualLoginPanelText=loginPanelHeading.getText();
		System.out.println("The Actual LoginPanel Text is :- "+ actualLoginPanelText);
		
		if(actualLoginPanelText.equals(expectedLoginPanelText))
		{
			System.out.println("The Actual Result of LoginPanel Element Text is matched with Expected Result:-	Pass ");
		}
		else {
			System.out.println("The Actual Result of LoginPanel Element Text is not mathce with Expected Result:- Fail");
		}
		
							//End of Validation of LoginPanel Text
		System.out.println();
		
							// Validation of Login Credentials with Test Data
		
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
		
					//End of validation of Credentials
		
				
					//Validation of HomePage after login
		
		String expectedHomePageTitleAfterLogin="OrangeHRM";
		System.out.println("The expected HomePage title after Logging in:- "+expectedHomePageTitleAfterLogin);
		String actualHomepageTitleafterLogin=driverC.getTitle();
		System.out.println("The Actual HomePage title after Logging in:- "+actualHomepageTitleafterLogin);
		if(actualHomepageTitleafterLogin.equals(expectedHomePageTitleAfterLogin))
		{
			System.out.println("The Actual Result of HomePage Title is matched with Expected Result:- Pass");
		}
		else {
			System.out.println("THe Actual result of HomePage title not matched with Expected Result:- Fail ");
		}
							//End of validation of HomePage title after logging in
		System.out.println();
			
							//Validation of Admin element Text
		
		By adminElementProperty=By.id("menu_admin_viewAdminModule");
		WebElement adminElement=driverC.findElement(adminElementProperty);
		String expectedAdminElementText="Admin";
		System.out.println("The Expected Admin Element Text is :- "+expectedAdminElementText );
		
		String actualAdminElementText=adminElement.getText();
		System.out.println("The Actual Admin Element Text is :- "+actualAdminElementText );
		
		if(actualAdminElementText.equals(expectedAdminElementText))
		{
			System.out.println("The Actual Result of Admin Element Text is matched with the Expected Result:- Pass");
		}
		else {
			System.out.println("The Actual Result of Admin Element Text is not matched with the Expected Result:- Fail");

		}
		
						// End of Validation of Admin Element Text
		System.out.println();
		
					//Automating the Welcome ADmin Link & Logout link
		
		By welcomeAdminProperty=By.className("panelTrigger");
		WebElement welcomeAdminElement=driverC.findElement(welcomeAdminProperty);
		welcomeAdminElement.click();
		
	//	Thread.sleep(5000);
		
		//The Wait method has been brought from the internet.
		By logoutElementProperty=By.linkText("Logout");
		WebElement logoutElement=driverC.findElement(logoutElementProperty);
		logoutElement.click();
		
							//Validating LoginPage after Logging out
		expectedHomePageTitle="OrangeHRM";
		System.out.println("THe expected title of OrangeHRM Homepage after Logging Out is :- "+expectedHomePageTitle );
		
		 actualHomePageTitle=driverC.getTitle();
		System.out.println("THe acutal title of OrangeHRM Homepage after Logging Out is :- "+ actualHomePageTitle);
		
		if(actualHomePageTitle.equals(expectedHomePageTitle)) {
			System.out.println("The Actual Result of HomePage Title after Logging Out is matched with the Expected result:- Passs");
		
		}
		else {
			System.out.println("The actual result of HomePage Title after Logging Out is not matched with the Expected result:- fail");
		}
		System.out.println();

		
						//Validating LoginPanel Text after Log out
		 loginpanelHeadingProperty=By.id("logInPanelHeading");
		 loginPanelHeading=driverC.findElement(loginpanelHeadingProperty);
		
		 expectedLoginPanelText="LOGIN";
		System.out.println("The Expected LoginPanel Text after Logging Out is :- "+expectedLoginPanelText );
		
		 actualLoginPanelText=loginPanelHeading.getText();
		System.out.println("The Actual LoginPanel Text after Logging Out is :- "+ actualLoginPanelText);
		
		if(actualLoginPanelText.contains(expectedLoginPanelText))
		{
			System.out.println("The Actual Result of LoginPanel Element Text after Logging out is matched with Expected Result:-	Pass ");
		}
		else {
			System.out.println("The Actual Result of LoginPanel Element Text after Logging Out is not mathce with Expected Result:- Fail");
		}
		
		System.out.println("---------------------------------");
		System.out.println("The Validation of OrangeHRM HomePage before and after of Login and Logout is Completed");
				
		//driverC.quit();
	}

}
