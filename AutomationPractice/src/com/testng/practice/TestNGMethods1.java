package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNGMethods1 {
	WebDriver driver;
	
	@BeforeSuite
	public void bSuite() {
		System.out.println("Report Creation Started");
	}
	
	@AfterSuite
	public void aSuite() {
		System.out.println("Report closed");
	}
	
	@BeforeClass
	public void bClass() {
		System.out.println("Database connection started");
	}
	
	@AfterClass
	public void aClass() {
		System.out.println("Database connection closed");
	}
	
	
	@BeforeMethod
	public void bMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@AfterMethod
	public void aMethod() {
		driver.quit();
	}
	
	@Test (groups ="smoke")
	public void WebTableEx() {
		driver.get("https://webdatacommons.org/webtables/");
		
		driver.manage().window().maximize();
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
	
	@Test (groups ="Regression")
	public void testcase() {
		System.out.println("Testcase executed");
	}
	
}
