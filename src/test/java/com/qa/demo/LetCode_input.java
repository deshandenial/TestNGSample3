package com.qa.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LetCode_input 
{
	WebDriver driver;
	
	@DataProvider(name = "login")
	public String[][] getData()
	{
		String[][] data = new String[2][2];
		data[0][0]  = "deshancse@gmail.com";
		data[0][1]  = "deshan@123";
		data[1][0]  = "deshancse@gmail.com";
		data[1][1]  = "deshan@123";
		return data;
		
		
		
	}
	
  @Test(dataProvider = "login")
  public void test1(String uname,String pass) 
  {
	driver.get("https://letcode.in/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class='button is-info']")).click();
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
	driver.findElement(By.xpath("//input[@name='email']")).click();
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	 
	 
	  
  }
  

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
