package com.Assignments;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;


public class OrangeHRM_EmployeeDetailsValidation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Jaava\\Eclipse Workspace\\Selenium_with_Java\\BrowserDriver_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		String OrangehrmWebApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		driver.get(OrangehrmWebApplicationUrl);
		
					//Validation of Title of OrangeHrm WebApplication
		String expectedOrangeHrmHomePageTitle="OrangeHRM";
				
		String actualOrangeHrmHomePageTitle=driver.getTitle();
		if(actualOrangeHrmHomePageTitle.equals(expectedOrangeHrmHomePageTitle))
			{
				System.out.println("Navigated to the Expected OrangeHRM HomePage:- Pass ||WebPageTitle:- "+actualOrangeHrmHomePageTitle);
			}
		else	{
				System.out.println("NOT Navigated to the Expected Orange HRM HomePage: Fail || Title:- "+actualOrangeHrmHomePageTitle);
			}
				System.out.println();
					
					//Validating the URL of ORANGEHRM HomePage
		String expectedOrangehrmHomepageURL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.out.println("The expected URL of OrangeHRM Homepage is :- "+expectedOrangehrmHomepageURL );
		
		String actualOrangehrmHomePageURL=driver.getCurrentUrl();
		System.out.println("The actual URL of OrangeHRM Homepage is :- "+actualOrangehrmHomePageURL);
		
		if(actualOrangehrmHomePageURL.equals(expectedOrangehrmHomepageURL))
			{
				System.out.println("Navigated to the Expected OrangeHRM HomePage:- Pass ||The Acutal Result of OrangeHRM Homepage URL matches with the Expected Result");
			}
		else
			{
				System.out.println("NOT navigated to the Expected OrangeHRM HomePage:- Fail || The Acutal Result of OrangeHRM Homepage URL does not match with the Expected Result");
			}
								//End of URL Validation
		System.out.println();

								
							//Entering Valid Credentials
		By userIdProperty=By.id("txtUsername");
		WebElement userId=driver.findElement(userIdProperty);
		userId.sendKeys("AnirudhHrm");
		
		By passwordProperty=By.name("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys("Ohrm@987");
		
		By loginButtonProperty=By.className("button");
		WebElement loginButton=driver.findElement(loginButtonProperty);
		//System.out.println(loginButton.getText());
		loginButton.click();
		
						//Validation of HomePage after login
		String expectedHomePageTitleAfterLogin="OrangeHRM";
	//	System.out.println("The expected HomePage title after Logging in:- "+expectedHomePageTitleAfterLogin);
		String actualHomepageTitleafterLogin=driver.getTitle();
		//System.out.println("The actual HomePage title after Logging in:- "+actualHomepageTitleafterLogin);
		if(actualHomepageTitleafterLogin.equals(expectedHomePageTitleAfterLogin))
		{
			System.out.println("Navigated to the Expected OrangeHRM Page After Login :- Pass || The Actual Result of HomePage Title is matched with Expected Result");
		}
		else {
			System.out.println("NOT navigated to the Expected Page After Login :- Fail || The Actual result of HomePage title not matched with Expected Result");
		}
							//End of validation of HomePage title after logging in
		System.out.println();
			
		
							//Validation of Admin element Text
		
		By adminElementProperty=By.className("firstLevelMenu");
		WebElement adminElement=driver.findElement(adminElementProperty);
		String expectedAdminElementText="Admin";
		//System.out.println("The expected Admin Element Text is :- "+expectedAdminElementText );
				
		String actualAdminElementText=adminElement.getText();
		//System.out.println("The actual Admin Element Text is :- "+actualAdminElementText );
			
		if(actualAdminElementText.equals(expectedAdminElementText))
		{
			System.out.println("The Actual Result of Admin Element Text is matched with the Expected Result:- Pass");
		}
		else {
			System.out.println("The Actual Result of Admin Element Text is not matched with the Expected Result:- Fail");
		}
				
								// End of Validation of Admin Element Text
		System.out.println();
				
									//Automating PIM element 
		
		By pimProperty=By.linkText("PIM");
			WebElement pim=driver.findElement(pimProperty);
			//Mouse Hovering on the PIM element
			Actions act = new Actions(driver);
			act.moveToElement(pim).build().perform();
		
		By addEmployeeLinkProperty=By.linkText("Add Employee");
		WebElement addEmployeeLink=driver.findElement(addEmployeeLinkProperty);
				
		String expectedAddEmployeePageURL=addEmployeeLink.getAttribute("href");
		System.out.println("The expected AddEmployee Page URL is:- "+expectedAddEmployeePageURL);
	
		addEmployeeLink.click();
		Thread.sleep(2000);
		//Same validation of URL is not happening after Clicking the element		
				
						//Validation of Add Employee Page
		//driver.navigate().back();
		//addEmployeeProperty=By.linkText("Add Employee");
		//addEmployee=driver.findElement(addEmployeeProperty);
		//String expectedAddEmployeePageURL=addEmployee.getAttribute("href");
		//System.out.println(expectedAddEmployeePageURL);
		String actualAddEmployeePageURL=driver.getCurrentUrl();
		System.out.println("The actual AddEmployee Page URL:- "+actualAddEmployeePageURL);
		if(actualAddEmployeePageURL.equals(expectedAddEmployeePageURL))
		{
			System.out.println(" Navigated to the Expected Add Employee WebPage:- Pass || The Actual Result of Add Employee URL Address is matched with the Expected Result");
		}
		else {
			System.out.println("NOT Navigated to the Expected Add Employee WebPage:- Fail || The Actual Result of Add Employee URL Address is not matched with the Expected Result");
		}
		
		System.out.println();
		
							//<h1>Add Employee</h1>

		By addEmployeeProperty=By.tagName("h1");
		WebElement addEmployee=driver.findElement(addEmployeeProperty);
		String expectedAddEmployeeHeadingText="Add Employee";
System.out.println("The expected AddEmployee Heading Text is:- "+expectedAddEmployeeHeadingText);
		String actualaddEmployeeHeadingText=addEmployee.getText();
		System.out.println("The actual AddEmployee Heading Text is:- "+actualaddEmployeeHeadingText);
		if(actualaddEmployeeHeadingText.equals(expectedAddEmployeeHeadingText))
		{
			System.out.println("Navigated to the Expected AddEmployee Page: Pass ||The Actual Result of AddEmployee Heading text is matched with the Expected Result");
		}
		else {
			System.out.println("NOT navigated to the Expected AddEmployee Page: Fail ||The Actual Result of AddEmployee Heading text is not matched with the Expected Result");
		}
		System.out.println();

		
		By fullNameListItemProperty=By.className("hasTopFieldHelp");
		WebElement fullNameListItem=driver.findElement(fullNameListItemProperty);
		String expectedFullNameListItemText="Full Name";
		System.out.println("The expected text of FullName ListItem Element is:- "+expectedFullNameListItemText);
		
		String actualFullNameListItemText=fullNameListItem.getText();
		System.out.println("The actual text of fullName ListItem Element is:- "+actualFullNameListItemText);
		if(actualFullNameListItemText.equals(expectedFullNameListItemText))
		{
			System.out.println("Navigated to the Expected Add Employee Page:- Pass || The Actual Result of the Element FullName text is matched with the Expected Result");
		}
		else {
			System.out.println(" NOT Navigated to the Expected Add Employee Page:- Fail ||The Actual Result of the Element FullName text is not matched with the Expected Result");
		}
			System.out.println();
		
							// End of Validation of Add Employee Page
			
				//Entering Valid Expected Employee Data into Fields
		
		By firstNameProperty=By.id("firstName");
		WebElement firstName=driver.findElement(firstNameProperty);
		 String expectedEmployeeFirstName="Gidugu";
		firstName.sendKeys(expectedEmployeeFirstName);
		 
		By middleNameProperty=By.name("middleName");
		WebElement middleName=driver.findElement(middleNameProperty);
		String expectedEmployeeMiddleName="Venkata";
		middleName.sendKeys(expectedEmployeeMiddleName);
		
		By lastNameProperty=By.id("lastName");
		WebElement lastName=driver.findElement(lastNameProperty);
		String expectedEmployeeLastName="Rama Murthy";
		lastName.sendKeys(expectedEmployeeLastName);
		
		By employeeIdProperty=By.id("employeeId");
		WebElement employeeId=driver.findElement(employeeIdProperty);
		String expectedEmployeeId=employeeId.getAttribute("Value");
		
		By saveButtonProperty=By.id("btnSave");
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
		
						//Validating EmployeeList WebPage
		By employeeListLinkProperty=By.linkText("Employee List");
		WebElement employeeListLink=driver.findElement(employeeListLinkProperty);
		String expectedEmployeeListPageUrl=employeeListLink.getAttribute("href");
		System.out.println("The expected EmployeeList Page URL is: "+expectedEmployeeListPageUrl);
		
		String actualEmployeeListUrl=driver.getCurrentUrl();
		System.out.println("The actual EmployeeList page URL is:- "+actualEmployeeListUrl);
		if(actualEmployeeListUrl.equals(expectedEmployeeListPageUrl))
		{
			System.out.println("Navigated to the Expected EmployeeList Page:- Pass ||The Actual EmployeeList WebPage Url is matched with the Expected Result");
		}
		else {
			System.out.println("NOT Navigated to the Expected EmployeeList Page:- Fail || The Actual EmployeeList WebPage Url is not matched with the Expected Result");
		}
		System.out.println();
		System.out.println("SO, BY GOING THORUHG CURRENT URL METHOD FOR ACTUAL RESULT, IT IS NOT MATCHING WITH Href BEING THE EXPECTED RESULT");
		System.out.println("AS THE WHEN NEW EMPLOYEE ID IS GENERATED AUTOMATICALLY FOR NEW REGISTRATION, IT CHANGES THE CURRENT URL ADDRESS");
		System.out.println("BUT THE Href STAYS THE SAME FOR EMPLOYEE LIST LINK");
		System.out.println("SO THIS IS NOT A VALID COMPARISION OF A WEBPAGE");
		System.out.println();
		
		//<h1>Personal Details</h1>		//<h1>Personal Details</h1>
	
		String expectedPersonalDetailsHeaderText="Personal Details";
		System.out.println("The expected PersonalDetails Header Element Text is:- "+expectedPersonalDetailsHeaderText);
		
		By personalDetailsHeaderProperty=By.tagName("h1");
		List<WebElement> personalDetailsHeaderElements=driver.findElements(personalDetailsHeaderProperty);
		int count=personalDetailsHeaderElements.size();
		System.out.println("The no.of Elements with h1 tag as property:- "+count);
		for(int position =0; position<count; position++)
		{
			String h1ElementsNames=personalDetailsHeaderElements.get(position).getText();
			System.out.println(position+" "+ h1ElementsNames);
		}
		
		String acutalPersonalDetailsHeaderText=personalDetailsHeaderElements.get(1).getText();
		System.out.println("The actual PersonalDetails Header Element Text is:- "+acutalPersonalDetailsHeaderText);
		if(acutalPersonalDetailsHeaderText.equals(expectedPersonalDetailsHeaderText))
		{
			System.out.println("Navigated to the Expected EmployeeList Page:- Pass ||The Actual Result of PersonalDetails Header Element Text is matched with the Expected Result");
		}
		else {
			System.out.println("NOT navigated to the Expected EmployeeList Page:- Fail ||The Actual Result of PersonalDetails Header Element Text is not matched with the Expected Result");
		}
		System.out.println();
		
		fullNameListItemProperty=By.className("hasTopFieldHelp");
		 fullNameListItem=driver.findElement(fullNameListItemProperty);
		 expectedFullNameListItemText="Full Name";
		System.out.println("The expected text of FullName ListItem Element is:- "+expectedFullNameListItemText);
		 
		actualFullNameListItemText=fullNameListItem.getText();
		System.out.println("The actual text of fullName ListItem Element is:- "+actualFullNameListItemText);
		if(actualFullNameListItemText.equals(expectedFullNameListItemText))
		{
			System.out.println("Navigated to Expected EmployeeList Page:- Pass || The Actual Result of the Element FullName text is matched with the Expected Result");
		}
		else {System.out.println(" NOT Navigated to Expected EmployeeList Page:- Fail ||The Actual Result of the Element FullName text is not matched with the Expected Result");
		}
		System.out.println();
					
				//Validating the Actual Employee Data with the Given Expected Data 
		System.out.println("----------------------Validating the Actual Employee Data with the Given Expected Data----------------");
		System.out.println();
		
		By registeredfirstNameProperty=By.id("personal_txtEmpFirstName");
		WebElement registeredFirstName=driver.findElement(registeredfirstNameProperty);
		String actualEmployeeFirstName=registeredFirstName.getAttribute("Value");
		if(actualEmployeeFirstName.equals(expectedEmployeeFirstName))
		{
			System.out.println("Both the Actual & Expected Employee FirstName are matched:- Pass ||"+actualEmployeeFirstName);
		}
		else {
			System.out.println("Employee FirstName is not matched :Fail "+actualEmployeeFirstName);
		}
		System.out.println();
		
		By registeredMiddleNameProperty=By.id("personal_txtEmpMiddleName");
		WebElement registeredMiddleName=driver.findElement(registeredMiddleNameProperty);
		String actualEmployeeMiddleName=registeredMiddleName.getAttribute("Value");
		if(actualEmployeeMiddleName.equals(expectedEmployeeMiddleName))
		{
			System.out.println("Both the Actual & Expected Employee MiddleName are matched:- Pass ||"+actualEmployeeMiddleName);
		}
		else {
			System.out.println("Employee MiddleName is not matched :Fail "+actualEmployeeMiddleName);
		}
	System.out.println();
	
		By registeredLastNameProperty=By.id("personal_txtEmpLastName");
		WebElement registeredLastName=driver.findElement(registeredLastNameProperty);
		String actualEmployeeLastName=registeredLastName.getAttribute("Value");
		if(actualEmployeeLastName.equals(expectedEmployeeLastName))
		{
			System.out.println("Both the Actual & Expected Employee LastName are matched:- Pass ||"+actualEmployeeLastName);
		}
		else {
			System.out.println("Employee LastName is not matched :Fail "+actualEmployeeLastName);
		}
	System.out.println();
	
		By registeredEmployeeIdProperty=By.id("personal_txtEmployeeId");
		WebElement registeredEmployeeId=driver.findElement(registeredEmployeeIdProperty);
		String actualEmployeeId=registeredEmployeeId.getAttribute("Value");
		if(actualEmployeeId.equals(expectedEmployeeId))
		{
			System.out.println("Both the Actual & Expected Employee ID are matched:- Pass ||"+actualEmployeeId);
		}
		else {
			System.out.println("Employee ID is not matched :Fail "+actualEmployeeId);
		}
	System.out.println();
			System.out.println("The Actual Employee Data is matched with the Expected Employee Data:- Pass");
			
			By welcomeAdminProperty=By.className("panelTrigger");
			WebElement welcomeAdminElement=driver.findElement(welcomeAdminProperty);
			welcomeAdminElement.click();
			
			Thread.sleep(5000);
			
			By logoutElementProperty=By.linkText("Logout");
			WebElement logoutElement=driver.findElement(logoutElementProperty);
			logoutElement.click();
			
			
			
			System.out.println("	*****THE END OF ASSIGNMENT**********");
	
driver.quit();	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
