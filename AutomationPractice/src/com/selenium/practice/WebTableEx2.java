package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://webdatacommons.org/webtables/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int rows = driver.findElements(By.xpath("//table[1]/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[1]/tbody/tr[2]/td")).size();
		
		//rows
		for(int row=2;row<=rows;row++) {
			//columns
			for(int col=1;col<=columns;col++) {
				System.out.println("Table row"+ row +" & column"+ col +" data: "+driver.findElement(By.xpath("//table[1]/tbody/tr["+row+"]/td["+col+"]")).getText());
			}
		}
		
	}

}
