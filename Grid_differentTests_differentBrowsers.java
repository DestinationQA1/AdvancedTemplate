package com.destinationqa.grid;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Grid_differentTests_differentBrowsers {

	@Parameters({ "browser" })
	@Test
	public void test1(String browsername) throws MalformedURLException, InterruptedException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		
		driver = new RemoteWebDriver(
				new URL("http://localhost:4444/wd/hub"), 
        		capabilities
        		);
		driver.get("http://www.google.com");
		Thread.sleep(10000);
		Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println("test1: "+driver.getTitle()+ " :" + actualCapabilities.getBrowserName());
		driver.quit();
	}
	
	@Parameters({ "browser" })
	@Test
	public void test2(String browsername) throws MalformedURLException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		driver = new RemoteWebDriver(
				new URL("http://localhost:4444/wd/hub"), 
        		capabilities
        		);
		driver.get("http://www.yahoo.com");
		Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println("test2: "+driver.getTitle()+ " :" + actualCapabilities.getBrowserName());
		driver.quit();
	}
	
	@Parameters({ "browser" })
	@Test
	public void test3(String browsername) throws MalformedURLException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		driver = new RemoteWebDriver(
				new URL("http://localhost:4444/wd/hub"), 
        		capabilities
        		);
		driver.get("http://www.msn.com");
		Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println("test3: "+driver.getTitle()+ " :" + actualCapabilities.getBrowserName());
		driver.quit();
	}
}
