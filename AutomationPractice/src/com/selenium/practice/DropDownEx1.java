package com.selenium.practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownEx1 {

	public static void main(String[] args) throws InterruptedException {
		
		//Provide driverpath
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		Select drp= new Select(driver.findElement(By.name("country")));
		List<WebElement> allOptions = drp.getOptions();
		
		for(int i=0;i<allOptions.size();i++) {
			System.out.println("Option is " +allOptions.get(i).getText());
		}
		
		//Select 'INDIA'
		drp.selectByIndex(15);
		Thread.sleep(2000);
		System.out.println("by index is over");
		drp.selectByValue("INDIA");
		Thread.sleep(2000);
		System.out.println("by value is over");
		drp.selectByVisibleText("GUATEMALA");
		System.out.println("by VisibleText");
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
