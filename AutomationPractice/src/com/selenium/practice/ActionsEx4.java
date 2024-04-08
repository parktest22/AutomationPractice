package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx4 {

	public static void main(String[] args) throws InterruptedException {

		//Create object and use it
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement element_slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions a = new Actions(driver);
		a.dragAndDropBy(element_slider, 200, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(element_slider, -150, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(element_slider, 400, 0).build().perform();
		Thread.sleep(2000);
		a.dragAndDropBy(element_slider, 1000, 0).build().perform();
	}

}
