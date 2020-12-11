package edu.ipl.techmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchIT {
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		
		//For Windows
		//System.setProperty("webdriver.chrome.driver", "C:\\ameya\\eclipse-workspace\\techmanagement\\chromedriver");
		
		
		//Set the Browser driver path for MAC
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/eclipse-workspace/techmanagement/chromedriver");
		
		//Open Browser
		WebDriver driver = new ChromeDriver();
		
		//Go to google.com
		driver.navigate().to("https://www.google.com");
		
		//Enter string IPL
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("IPL");
		
		//Pause for 100 milliseconds
		Thread.sleep(100);
		
		//Click on Search button
		WebElement searchbutton = driver.findElement(By.className("gNO89b"));
		searchbutton.click();
		
		
		//Verify that the first result is IPL official Web page
		WebElement firstlink = driver.findElement(By.className("yuRUbf"));
		
		String actual = firstlink.getText();
		String expected = "IPLT20.com - Indian Premier League Official Website\n"
				+ "www.iplt20.com";
				
		Assert.assertEquals(actual, expected);
		
	}

}
