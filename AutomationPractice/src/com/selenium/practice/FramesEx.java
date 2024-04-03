package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/autocomplete/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Switch to your control into Frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("tags")).sendKeys("Venkat");
		
		//Come out from frame
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		
	}

}
