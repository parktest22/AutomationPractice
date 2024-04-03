package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchApp {

	public static void main(String[] args) throws InterruptedException {
		
		// Provide Driver
		System.setProperty("webdriver.chrome.driver", "C:\\CodeHome\\jars\\chromedriver-win64\\chromedriver.exe");
		
		//Create Object and use it
		WebDriver driver = new ChromeDriver();
		driver.get("https://onlinetestinghelp.com/projects/banking/admin/login.php");
		
		driver.manage().window().maximize();
		System.out.println("Title is :"+driver.getTitle());

		boolean isDisplay = driver.findElement(By.xpath("//b[text()='Admin Login']")).isDisplayed();
		System.out.println("Admin login display: " + isDisplay);

		//clear the data
		driver.findElement(By.name("username")).clear();

		//Get the link text
		String linkText = driver.findElement(By.xpath("//div[@class='col-8']/a")).getText();
		System.out.println("User login Hyperlink text :"+linkText);

		//want to get href
		String linkUserLoginUrl =  driver.findElement(By.xpath("//div[@class='col-8']/a")).getAttribute("href");
		System.out.println("User Login href value: "+linkUserLoginUrl);
		
		//Enter the username
		driver.findElement(By.name("username")).sendKeys("admin");
		
		
		//verify username is entered or not or fetch the value from username
		String userNameValue = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Username field value is :" +userNameValue);
	
		
		//whether submit button is editable
		boolean isEditable = driver.findElement(By.xpath("//button[text()='Sign In']")).isEnabled();
		System.out.println("Submit button: "+isEditable);
		
		//Enter password and click submit button
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[contains(text(),'Account Management')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//p[contains(text(),'New Account')]")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("74125336");
		driver.findElement(By.xpath("(//input)[3]")).sendKeys("FName");
		driver.findElement(By.xpath("(//input)[4]")).sendKeys("test");
		driver.findElement(By.xpath("(//input)[5]")).sendKeys("LName74125336");
		driver.findElement(By.xpath("(//input)[6]")).sendKeys("LName74125336@Testemail.com");
		
		driver.findElement(By.xpath("//button[text()='Generate']")).click();
		String sPassword = driver.findElement(By.xpath("//input[@name='generated_password']")).getAttribute("value");
		System.out.println("Password value : "+sPassword);
		
		
		driver.findElement(By.xpath("(//input)[8]")).sendKeys("1234");
		driver.findElement(By.xpath("(//input)[9]")).clear();
		driver.findElement(By.xpath("(//input)[9]")).sendKeys("1050");
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		
		//driver.close();
		driver.quit();
		
	}

}
