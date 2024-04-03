package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioEx1 {

	public static void main(String[] args) throws InterruptedException {
		
		//Provide driverpath
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Driver setup
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		
		//Click on onway radio button
		driver.findElement(By.xpath("//input[@type='radio' and @value='oneway']")).click();
		Thread.sleep(2000);
		
		List<WebElement> radios = driver.findElements(By.xpath("//input[@name='tripType']"));
		for(int i=0;i<radios.size();i++) {
			radios.get(i).click();
			Thread.sleep(2000);
		}
		
		driver.close();
	}
}
