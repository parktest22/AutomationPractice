package com.selenium.practice;

import java.util.concurrent.TimeUnit;
import java.awt.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// File upload - Robot

public class FileUploadEx1 {

	public static void main(String[] args) {
		//provide driver
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://easyupload.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//File upload
		WebElement Fileupload = driver.findElement(By.className("dz-button"));
		Fileupload.click();
		
		String path = "C:\\Users\\Nijo_Home\\Documents\\FileUploadSeleniumTest.txt";
		
		/*
		//CTRL+C --> Path is setting to clipboard
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolKit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+V
		Robot r = new Robot();
		r.KeyPress(KeyEvent.VK_CONTROL);
		r.KeyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.KeyRelease(KeyEvent.VK_CONTROL);
		
		//Pass ENTER Key
		r.KeyPress(keyEvent.VK_ENTER);
		r.KeyRelease(KeyEvent.VK_ENTER);
		*/
		
		//Click Upload Button
		driver.findElement(By.xpath("//button[@id='upload']")).click();
		
		System.out.println(driver.findElement(By.xpath("//h6[@id='upload-label-1']")).getText());
		
		

	}

}
