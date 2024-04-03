package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameEx3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Switch your control into parent frame
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		//Switch to LEFT child frame
		driver.switchTo().frame(driver.findElement(By.name("frame-left")));
		
		//Get the text 
		System.out.println("Left Panel text is: "+driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());
		
		//Switch to parent frame
		driver.switchTo().parentFrame();
		
		//-----------------------------------------------------------------
		
		//Switch to MIDDLE child frame
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
				
		//Get the text 
		System.out.println("Middle Panel text is: "+driver.findElement(By.xpath("//div[@id='content']")).getText());
				
		//Switch to parent frame
		driver.switchTo().parentFrame();
		
		//-----------------------------------------------------------------
		
		//Switch to RIGHT child frame
		driver.switchTo().frame(driver.findElement(By.name("frame-right")));
						
		//Get the text 
		System.out.println("Right Panel text is: "+driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText());
						
		//Switch to default content
		driver.switchTo().defaultContent();
		
		//----------------------------------------------------------------------
		
		//Switch to BOTTOM Frame
		driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
		//Get the text from Bottom 
		System.out.println("Bottom panel text is: "+driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText());
		
		//Switch to Parent frame
		driver.switchTo().defaultContent();
		
		driver.close();
	}
}
