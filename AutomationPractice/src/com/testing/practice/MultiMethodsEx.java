package com.testing.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiMethodsEx {
	//Create object and use it
	WebDriver driver;
	
	@BeforeClass
	public void bClass() {
		System.out.println("Database connecion opened");
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
	
	@Test (priority = 1)
	public void actions1() {
		
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement Element_Enabled = driver.findElement(By.xpath("//a[text()='Enabled']"));
		WebElement Element_Downloads = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement Element_Excel = driver.findElement(By.xpath("//a[text()='Excel']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(Element_Enabled).pause(2000).moveToElement(Element_Downloads).pause(2000).moveToElement(Element_Excel).click().build().perform();
		
		
	}
	
	@Test (priority = 0)
	public void actions2() {

		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement element_dragA = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement element_drabB = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(element_dragA, element_drabB).build().perform();
		
	}
}
