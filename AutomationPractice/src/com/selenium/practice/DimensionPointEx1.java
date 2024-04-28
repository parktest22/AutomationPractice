package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DimensionPointEx1 {
	static WebDriver driver;
	
	public static void main(String[] args) {
		//Provide driver
		//System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//webdriver manager with all dependencies
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Create object and use it
		//WebDriver driver = new ChromeDriver();
		driver.get("https://easyupload.io/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dimensionMethod();
		System.out.println("Script Execution is done");
		
	}
	
	public static void dimensionMethod() {
		//Get dimensions, width and height
		System.out.println("X position is: "+driver.manage().window().getPosition().getX());
		System.out.println("Y position is: "+driver.manage().window().getPosition().getY());
		
		System.out.println("Width is ::"+driver.manage().window().getSize().getWidth());
		System.out.println("Height is ::"+driver.manage().window().getSize().getHeight());
		
		//Set position
		Point p = new Point(500, 500);
		driver.manage().window().setPosition(p);
		
		//Set Size
		Dimension d = new Dimension(100, 200);
		driver.manage().window().setSize(d);
		
		
	}

}
