package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Click on 'js alert' button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		System.out.println("Alert text 1st button is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Result is: "+driver.findElement(By.id("result")).getText());
		
		//Click on 'Click for JS Confirm' button
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		System.out.println("Alert text 2nd button is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println("Result is: "+driver.findElement(By.id("result")).getText());
		
		//Click on 'Click for JS Prompt' button
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		System.out.println("Alert text 3rd button is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("3rd Alert");
		driver.switchTo().alert().accept();
		System.out.println("Result is: "+driver.findElement(By.id("result")).getText());
		
	}

}
