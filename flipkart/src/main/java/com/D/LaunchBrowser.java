package com.D;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public WebDriver driver;
	
	@Test 
	public void getWindowHandles() {
		
	String parentwindow=driver.getWindowHandle();	
	Set<String> s=driver.getWindowHandles();
	Iterator<String> i1=s.iterator();
	while(i1.hasNext()) {
		String childwindow = i1.next();
		if(!parentwindow.equals(childwindow)) {
			driver.switchTo().window(childwindow);
			System.out.println(driver.switchTo().window(childwindow).getTitle());
			driver.close();
			
		}
		
	}
		driver.switchTo().window(parentwindow);
		
	}

	@Test
	public  void browserLaunch() throws Exception {
		
		//String[] products= {"",""};

		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
	
		String ss=System.getProperty("user.dir");
		System.out.println(ss);
		System.setProperty("Webdriver.chrome.driver","ss+\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).clear();
		Thread.sleep(1000);
		
		 driver.findElement(By.name("q")).sendKeys("laptops");
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		 
		 List<WebElement> productslist=driver.findElements(By.cssSelector("div._4rR01T"));
		 
		 for(int i=1;i<productslist.size();i++) {
			 
			 String laptops=productslist.get(i).getText();
			 
			 System.out.println(laptops);
			 
		 }
		 
		 
		 
		
		
		
		
		
		
		
		
	}

}
