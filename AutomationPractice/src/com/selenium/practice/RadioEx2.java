package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioEx2 {

	public static void main(String[] args) throws InterruptedException {
		
		//Provide driverpath
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
				
		//Driver setup
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		
		List<WebElement> radiosService = driver.findElements(By.xpath("//input[@name='servClass']"));
		for(int i=0;i<radiosService.size();i++) {
			radiosService.get(i).click();
			System.out.println("Services Radio "+radiosService.get(i).getAttribute("value"));
			Thread.sleep(3000);
		}
		
		driver.close();
		
	}

}
