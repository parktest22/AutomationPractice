package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptEx1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://onlinetestinghelp.com/projects/banking/admin/login.php");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//WebElement userName = driver.findElement(By.name("username"));
		WebElement userName = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.getElementsByName('username')[0]");
		WebElement password = driver.findElement(By.name("password"));
		
		userName.sendKeys("admin");
		password.sendKeys("admin123");
		
		WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", signIn);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Get the title
		String title = (String) ((JavascriptExecutor)driver).executeScript("return document.title;");
		System.out.println("Title is : "+ title);
		
	}

}
