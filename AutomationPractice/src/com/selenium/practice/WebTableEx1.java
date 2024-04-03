package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx1 {

	public static void main(String[] args) {
		
		//Provide driverpath
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int rows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		
		//System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]")).getText());
		
		//rows
		for(int row=1;row<=rows;row++) {
			//columns
			for(int col=1;col<columns;col++) {
				System.out.println("Table row"+row+" & col"+col+" data: "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]")).getText());
			}
		}
		
		
		System.out.println("----------------Second Table---------------");
		rows= driver.findElements(By.xpath("//table[@id='table2']/tbody/tr")).size();
		columns=driver.findElements(By.xpath("//table[@id='table2']/tbody/tr[1]/td")).size();
		
		//rows
		for(int row=1;row<=rows;row++) {
			//columns
			for(int col=1;col<columns;col++) {
				System.out.println("Table 2 row"+row+" & col"+col+" data: "+driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+row+"]/td["+col+"]")).getText());
			}
		}
		;

	}

}
