package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


//Scroll up and down

public class ScrollUpAndDownEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.costco.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='closeEmailPopup']")).click();
		
		//Scroll down and up
		for(int i=0;i<=10;i++) {
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)","");
			Thread.sleep(2000);
			
		}
		
		for(int j=0;j<=10;j++) {
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,-200)", "");
			Thread.sleep(2000);
			
		}
		
		//Scroll Into view
		WebElement Element_NotAMember = driver.findElement(By.xpath("//img[@alt='Not a member yet? Sign up today!']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Element_NotAMember);

		driver.quit();
		
	}

}
