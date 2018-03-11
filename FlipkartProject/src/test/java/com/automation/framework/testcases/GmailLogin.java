package com.automation.framework.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GmailLogin {

	@Test
	public void doLogin() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		driver.findElement(By.id("Email")).sendKeys("k.manesh@gmail.com");
		driver.findElement(By.id("Next")).click();
		
		driver.findElement(By.id("Email")).sendKeys("k.manesh@gmail.com");

	}

}
