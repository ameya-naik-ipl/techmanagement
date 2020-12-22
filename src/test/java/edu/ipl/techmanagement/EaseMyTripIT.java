package edu.ipl.techmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test; //TestNG Library

public class EaseMyTripIT {
	
	@Test //This is coming from TestNG Library
	public void testLowestPrice() throws InterruptedException {
		
		//Tell java and selenium where the chrome driver is kept
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/eclipse-workspace/techmanagement/chromedriver");
				
		//1. Open Browser in a new profile (like incognito)
		WebDriver browser = new ChromeDriver();
		
		//Selenium provides implicit wait to Wait for element to be present or visible
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Implicit wait is a dynamic wait - Only waits until the element is NOT present. 
		//As soon as the element is present, selenium will proceed
		//To achieve this Selenium polls the DOM every 500ms 
		
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
		Thread.sleep(200); //200 milliseconds
		browser.findElement(By.id("17/12/2020")).click();
		
		//6. Enter To Date 19 Dec
		browser.findElement(By.id("rdate")).click();
		Thread.sleep(200); //Thread.sleep is a Java method not Selenium
		
		browser.findElement(By.id("19/12/2020")).click();
		
		//Explicit Wait can wait for element to contain text 
		//or no of elements to be some number
		//WebDriverWait mywait = new WebDriverWait(driver, 30);
		//mywait.until(ExpectedConditions.textToBePresentInElement(e1, "samsung"));
		
		//7. Search
		//Absolute Xpath for search button: /html/body/form/div[14]/div[2]/div[3]/div[1]/div[7]/input
		//Relative Xpath: //input[@value='Search']
		browser.findElement(By.xpath("//input[@value='Search']")).click();
		
		//implicit wait only waits for element to be present
		
		//Thread.sleep(5000);
		
		//8. Verify that the total cost is < 15000 - Expected Result 
		WebElement price = browser.findElement(By.xpath("//p[@class='stk_btm_price ']/span[2]"));
		
		//Explicit Wait for comma to appear in the price field. 
		//This will prove that the page has completed loading and we cna move ahead to next step
		WebDriverWait mywait = new WebDriverWait(browser, 10);
		mywait.until(ExpectedConditions.textToBePresentInElement(price, ","));
		//mywait.until(ExpectedConditions.textToBePresentInElement(anotherelement, ","));
		
		String actual = price.getText();
		String expected = "15,000";
		
		actual = actual.replace(",", "");
		expected = expected.replace(",", "");
		
		double actualprice = Double.parseDouble(actual);
		double expectedprice = Double.parseDouble(expected);
		
		System.out.println(actualprice);
		System.out.println(expectedprice);
		
		Assert.assertTrue(actualprice < expectedprice);
		
		//Close the browser tab
		browser.close();
		
		//Close the browser
		browser.quit();
		
	}

}
