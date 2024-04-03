package com.selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsEx {

	public static void main(String[] args) throws InterruptedException {
		
		// Provide driver path
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Starting window
		String mainwindow = driver.getWindowHandle();
		
		for(int i=0;i<5;i++) {
			driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		}
		
		//All Windows
		List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i=0;i<allHandles.size();i++) {
		
			if(allHandles.get(i)!=mainwindow) {
				driver.switchTo().window(allHandles.get(i));
				System.out.print("Each Handle is: "+allHandles.get(i));
				System.out.println(" >> Window "+i+" all Title is "+driver.getTitle());
			}
		}

		//driver.close();
		
//		Thread.sleep(5000);
//		driver.quit();
		
	}
}
