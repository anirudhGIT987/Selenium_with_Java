package com.Frames;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {
	WebDriver driver;
	String applicationUrl="https://jqueryui.com/droppable/";

	public void websiteLaunch() {
		System.setProperty("webdriver.gecko.driver", "./BrowserDriver_Files/geckodriver.exe");
		driver = new FirefoxDriver();
		//String applicationUrl="https://www.globalsqa.com/demo-site/draganddrop/";
		String applicationUrl="https://jqueryui.com/droppable/";

		driver.get(applicationUrl);
	}//launch method
	/*
	private void dragDropElement() throws InterruptedException {
		//Thread.sleep(3000);
		By webFrameProperty=By.xpath("/html/body/div/div[1]/div[2]/div/div/div[2]/div/div/div[1]/p/iframe");
		//By webFrameProperty=By.tagName("iframe");
		WebElement webPageFrame=driver.findElement(webFrameProperty);
		
		//Getting into the Frame in order to access the drag elements
		driver.switchTo().frame(webPageFrame);
		//Getting property of drag element
		By highTatras2Property=By.xpath("/html/body/div[1]/ul/li[2]");
		WebElement highTatras2 =driver.findElement(highTatras2Property);
		String dragText=highTatras2.getText();
System.out.println("The draggable Element text is:- "+dragText);	
		//Property of Droppable
		By droppableProperty=By.xpath("//*[@id=\"trash\"]");
		WebElement droppable=driver.findElement(droppableProperty);
		
		//Perform drag and drop operation
		Actions act = new Actions(driver);
		act.dragAndDrop(highTatras2, droppable);
System.out.println("Dragged and dropped");
	}
	*/
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Drag_And_Drop mouseOpns = new Drag_And_Drop();
		mouseOpns.websiteLaunch();
		//mouseOpns.dragDropElement();
		mouseOpns.jqueryDragDrop();
	}// main method
		
	l
	private void jqueryDragDrop() throws IOException {
		//By webPageFrameProperty=By.className("demo-frame");
		By webPageFrameProperty=By.xpath("/html/body/div/div[2]/div/div[1]/iframe");
		WebElement webPageFrame=driver.findElement(webPageFrameProperty);
System.out.println("Found the frame");
	driver.switchTo().frame(webPageFrame);
	WebElement draggable=driver.findElement(By.id("draggable"));
System.out.println(draggable.getText());	
	WebElement droppable=driver.findElement(By.id("droppable"));

	//File scrnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(scrnsht, new File("./SnapShots/Beforedragdropscreenshot.png"));
	

	Actions act = new Actions(driver);
	act.dragAndDrop(draggable, droppable).build().perform();
 //scrnsht=((TakesScreenshot)driver).getScreen shotAs(OutputType.FILE);
	//FileUtils.copyFile(scrnsht, new File("./SnapShots/dragdroppedcreenshot.png"));
			
	
System.out.println("Dragged and Dropped");
	
	
	}
	
}
