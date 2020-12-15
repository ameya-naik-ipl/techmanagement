package edu.ipl.techmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test; //TestNG Library

public class EaseMyTripIT {
	
	@Test //This is coming from TestNG Library
	public void testLowestPrice() throws InterruptedException {
		
		//Tell java and selenium where the chrome driver is kept
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/eclipse-workspace/techmanagement/chromedriver");
				
		//1. Open Browser
		WebDriver browser = new ChromeDriver();
		
		//2. Navigate to Easemytrip.com
		browser.navigate().to("https://www.easemytrip.com/");
		
		//3. Enter Departure City Pune
		//WebElement searchbar = driver.findElement(By.name("q"));
		//searchbar.sendKeys("institute of product leadership");
		
		browser.findElement(By.id("FromSector_show")).clear();
		browser.findElement(By.id("FromSector_show")).sendKeys("Pune(PNQ)" + Keys.TAB); //Method chaining
		//browser.findElement(By.id("FromSector_show")).sendKeys(Keys.TAB);
		
		//4. Enter Destination City Bangalore
		browser.findElement(By.id("Editbox13_show")).clear();
		browser.findElement(By.id("Editbox13_show")).sendKeys("Bangalore(BLR)");
		
		//5. Enter From Date 17 Dec
		browser.findElement(By.id("ddate")).click();
		Thread.sleep(200);
		browser.findElement(By.id("17/12/2020")).click();
		
		//6. Enter To Date 19 Dec
		browser.findElement(By.id("rdate")).click();
		Thread.sleep(200);
		browser.findElement(By.id("19/12/2020")).click();
		
		//7. Search
		//Absolute Xpath for search button: /html/body/form/div[14]/div[2]/div[3]/div[1]/div[7]/input
		//Relative Xpath: //input[@value='Search']
		browser.findElement(By.xpath("//input[@value='Search']")).click();
		
		Thread.sleep(5000);
		
		//8. Verify that the total cost is < 15000 - Expected Result 
		String actual = browser.findElement(By.xpath("//p[@class='stk_btm_price ']/span[2]")).getText();
		String expected = "15,000";
		
		actual = actual.replace(",", "");
		expected = expected.replace(",", "");
		
		double actualprice = Double.parseDouble(actual);
		double expectedprice = Double.parseDouble(expected);
		
		System.out.println(actualprice);
		System.out.println(expectedprice);
		
		Assert.assertTrue(actualprice < expectedprice);
		
		browser.quit();
		
		
	}

}
