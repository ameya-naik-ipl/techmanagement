package edu.ipl.techmanagement;

import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.grid.web.utils.BrowserNameUtils;
import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerExampleTestNGIT {

		@Parameters({"browser"})
		@Test
		public void testGoogle(String browser) throws MalformedURLException {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(browser);
			
	        WebDriver driver = new RemoteWebDriver(
	        		new URL("http://c14735bc9c10.ngrok.io/wd/hub"), 
	        		capabilities
	        		);

			//And now use it
			
	        driver.get("http://www.google.com");
	        System.out.println(driver.getTitle());
			// Query the driver to find out more information
	        Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
			System.out.println(actualCapabilities.getBrowserName());
			System.out.println(actualCapabilities.getVersion());
			System.out.println(actualCapabilities.isJavascriptEnabled());
			System.out.println(actualCapabilities.getPlatform());		
			
			driver.quit();
		}

	}

	//Another way of Setting browser
	//capabilities.setBrowserName(BrowserType.CHROME);
	//capabilities.setBrowserName(BrowserType.IEXPLORE);
	//capabilities.setBrowserName(BrowserType.FIREFOX);

	//If I set platform to Windows or XP or VISTA, without specifying the browser, IE opens. Otherwise Firefox opens
			//capabilities.setPlatform(Platform.XP);
			//capabilities.setPlatform(Platform.VISTA);
			//capabilities.setPlatform(Platform.WINDOWS);
			//capabilities.setPlatform(Platform.extractFromSysProperty("XP"));
			//System.out.println(capabilities.getCapability(CapabilityType.PLATFORM));
