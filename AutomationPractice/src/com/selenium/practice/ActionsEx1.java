package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");

		//Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement Element_Enabled = driver.findElement(By.xpath("//a[text()='Enabled']"));
		WebElement Element_Downloads = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement Element_Excel = driver.findElement(By.xpath("//a[text()='Excel']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(Element_Enabled).pause(2000).moveToElement(Element_Downloads).pause(2000).moveToElement(Element_Excel).click().build().perform();
		
		
		
	}

}
