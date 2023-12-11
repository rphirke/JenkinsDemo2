package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.out.println("User is on login page.");
		if(System.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(System.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if(System.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} 
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
//	    driver.findElement(By.id("login-button")).click();
	    System.out.println("Login Successfully.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
