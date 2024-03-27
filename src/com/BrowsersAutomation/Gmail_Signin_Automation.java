package com.BrowsersAutomation;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Gmail_Signin_Automation{
	
	public static void main(String[] args) {
		
		WebDriver mover;
	
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe ");
		mover = new ChromeDriver();
		mover.get(OrangehrmWebApplicationUrl);
		
		
		By loginButtonProperty=By.id("btnLogin");
		WebElement loginButton=mover.findElement(loginButtonProperty);
		System.out.println(loginButton.getText());
		loginButton.click();
	
		
		/*	
 red=By.name("openIdLogin");
		WebElement rd=mover.findElement(red);
	rd.getText();
		System.out.println(rd.getText());
		rd.click();

		/*
		By lp=By.id("logInPanelHeading");
		WebElement lpp=mover.findElement(lp);
		lpp.getText();
		System.out.println(lpp.getText());
		
		By userNameProperty=By.name("txtUsername");
		WebElement userName=mover.findElement(userNameProperty);
		userName.sendKeys("AnirudhHRM");
		
		By passwordProperty=By.name("txtPassword");
		WebElement password=mover.findElement(passwordProperty);
		password.sendKeys("Ohrm@987");
		
		By loginButtonProperty=By.className("button");
		WebElement loginButton=mover.findElement(loginButtonProperty);
		System.out.println(loginButton.getText());
		//loginButton.click();
		
		/*
String url="https://www.facebook.com/";
		
		System.setProperty("webdriver.chrome.driver","D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe ");
		mover = new ChromeDriver();
		mover.get(url);
		
		By prop=By.id("email");
		WebElement el=mover.findElement(prop);
		el.sendKeys("abc@.gmail.com");
		
		By prop1=By.id("pass");
		WebElement el1=mover.findElement(prop1);
		el1.sendKeys("password");
		
		
		
		
		//mover.manage().timeouts().implicitlyWait(220,TimeUnit.SECONDS);
		
		
		By loginButtonProperty=By.name("login");
		WebElement loginButton=mover.findElement(loginButtonProperty);
		System.out.println(loginButton.getText());
		loginButton.click();
		//mover.quit();
		
		//https://www.facebook.com/
		
		//<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_5_Nf">Log in</button>
		
		//<div class="x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1xmf6yo x1e56ztr x540dpk x1m39q7l x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1"><button class="_acan _acap _acas _aj1-" disabled="" type="submit"><div class="x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1">Log in</div></button></div>
		
		
		/*
		mover.navigate().to(gmailWebApplicationUrl);
		mover.findElement(By.className("VfPpkd-RLmnJb")).click();
		//<input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" value="" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">
		
		//mover.findElement(By.name("identifier")).sendKeys("ajayjujare9@gmail.com");
		mover.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span")).click();
		mover.findElement(By.className("VfPpkd-StrnGf-rymPhb-b9t22c")).click();
		mover.findElementByXPath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/button/div[3]").click();
		//mover.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[3]")).click();
		// mover.findElement(By.className("VfPpkd-RLmnJb")).click();
		*/
	
	}
	
}
