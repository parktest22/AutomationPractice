package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownEx2 {

	public static void main(String[] args) throws InterruptedException {
		
		//Provide driverpath
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		////Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");

		Select drp1 = new Select(driver.findElement(By.id("dropdown")));
		List<WebElement> allOptions1 = drp1.getOptions();
		
		for(int i=0;i<allOptions1.size();i++) {
			System.out.println("List value "+allOptions1.get(i).getText());
		}
		
		drp1.deselectByValue("1"); //Selecting Option 1
		
		System.out.println("Selecting Option 1");
		Thread.sleep(10000);

		driver.close();
		
		
	}

}
