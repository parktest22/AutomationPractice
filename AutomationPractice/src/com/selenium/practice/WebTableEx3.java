package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int rows= driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr")).size();
		int columns= driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr[2]/td")).size();
		
		System.out.println("rows: "+rows+"columns: "+columns);
		
		//rows
		for(int row=2;row<=rows;row++) {
			//columns
			for(int col=1;col<=columns;col++) {
				System.out.println("Table row:"+ row +"& column: "+col+"data is: "+driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr["+row+"]/td["+col+"]")).getText());
			}
		}
		
		driver.close();
		
	}

}
