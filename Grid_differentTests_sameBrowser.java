package com.destinationqa.grid;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* This is an example of Selenium GRID
 * 
 * Before executing, please start a HUB and atleast 1 NODE
 * By default, a Selenium node will run 5 sessions of Firefox, 5 sessions of Chrome 
 * and 1 session of IE, but it can only run a total of 5 sessions on parallel.
 * 
 * HUB and NODE needs to be started before this file is executed.
 * To Start HUB: Go to the folder where Selenium Standalone Jar is present
 * and type the following command
 * 
 * java -jar selenium-server-standalone-2.41.0.jar -role hub
 * 
 * To Start NODE: Go to the folder where Selenium Standalone Jar is present
 * and type the following command
 * 
 * java -jar selenium-server-standalone-2.41.0.jar -role node -hub http://localhost:4444/grid/register
 * 
 * Here, we are starting the node on the same machine as the HUB, hence 'localhost' above.
 * 
 * In this example, our test accepts 1 parameter 'browser' which is supplied from the testng.xml
 * file. The corresponding xml file for this example is grid_differenttests_samebrowser.xml
 * To execute this example, the xml file needs to be executed using Run As -> TestNG Suite
 * The XML file supplies same browser parameter to each test, but these browsers 
 * are executed in parallel.
 * 
 * Please note that Internet Explorer can run only 1 instance on 1 node. Hence if you select
 * Internet Explorer as the browser, it will execute sequentially.
 * 
 * Firefox and Chrome can run 5 instances on 1 node.
*/

public class Grid_differentTests_sameBrowser {

	
	
	//This method needs a browser parameter to be sent form testng xml file.
	//Please run grid_differenttests_samebrowser.xml to execute this
	@Parameters({ "browser" })
	@Test
	public void test1(String browsername) throws MalformedURLException, InterruptedException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		
		//Here we are disabling all extensions in Chrome as they sometimes interfere with execution
		if (browsername.equals("chrome")) {
			capabilities.setCapability("chrome.switches",  
					Arrays.asList("--disable-extensions"));
		}		 
		URL server = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(server, capabilities);
		driver.get("http://www.google.com");
		System.out.println("test1: Google: "+browsername);
		driver.quit();
	}
	
	@Parameters({ "browser" })
	@Test
	public void test2(String browsername) throws MalformedURLException, InterruptedException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		
		//Here we are disabling all extensions in Chrome as they sometimes interfere with execution
		if (browsername.equals("chrome")) {
			capabilities.setCapability("chrome.switches",  
					Arrays.asList("--disable-extensions"));
		}		 
		URL server = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(server, capabilities);
		driver.get("http://www.yahoo.com");
		System.out.println("test2: Yahoo: " + browsername);
		driver.quit();
	}
	
	@Parameters({ "browser" })
	@Test
	public void test3(String browsername) throws MalformedURLException, InterruptedException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browsername);
		
		//Here we are disabling all extensions in Chrome as they sometimes interfere with execution
		if (browsername.equals("chrome")) {
			capabilities.setCapability("chrome.switches",  
					Arrays.asList("--disable-extensions"));
		}		 
		URL server = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(server, capabilities);
		driver.get("http://www.msn.com");
		System.out.println("test3: MSN: "+browsername);
		driver.quit();
	}
}
