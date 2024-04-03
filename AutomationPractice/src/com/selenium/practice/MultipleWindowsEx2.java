package com.selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsEx2 {

	public static void main(String[] args) {
		
		//Provide driver path
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'BUSES')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'HOTELS')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Starting window
		String mainwindow = driver.getWindowHandle();
		
		//All Windows
		List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i=0;i<allHandles.size();i++) {
			driver.switchTo().window(allHandles.get(i));
			System.out.print("Window ID :"+allHandles.get(i));
			System.out.println("  >> Window "+i+" Title is : "+driver.getTitle());
		}
	}
}
