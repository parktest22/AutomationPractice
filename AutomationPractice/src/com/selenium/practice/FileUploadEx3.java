package com.selenium.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//File upload - AutoIT-Path as parameter

public class FileUploadEx3 {

	public static void main(String[] args) throws IOException {

		//Set path
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");

		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://easyupload.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on File upload button
		driver.findElement(By.className("dz-button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Execute AutoIT program
		Runtime.getRuntime().exec("C:\\CodeHome\\AutoIT\\FileUploadPath.exe C:\\CodeHome\\git\\repository\\AutomationPractice\\ExtraResources\\FileUploadSeleniumTest.txt");
		
		//Click on Upload button
		driver.findElement(By.id("upload")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		System.out.println(driver.findElement(By.id("upload-label-1")).getText());
		driver.quit();
		
	}

}
