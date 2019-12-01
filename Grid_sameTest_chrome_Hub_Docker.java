package com.destinationqa.grid;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* This is an example of Selenium GRID
 * 
 * Before executing, please start a HUB and atleast 1 NODE
 * By default, a single Selenium node will run 5 sessions of Firefox, 5 sessions of Chrome 
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
 * file. The corresponding xml file for this example is grid_sametest_differentbrowsers.xml
 * To execute this example, the xml file needs to be executed using Run As -> TestNG Suite
 * The XML file supplies different browser parameters to the same test, and these browsers 
 * are executed in parallel.
 * 
 * Internet Explorer Security Properties - Ensure that 'Enable Protected Mode' is either ON for all Levels or OFF for all levels. 
 * 
*/


public class Grid_sameTest_chrome_Hub_Docker {

	//@Parameters({ "browser", "Hub" })
	@Test
	public void test1() throws InterruptedException, MalformedURLException {
	//public void test1(String browsername, String Hubname) throws InterruptedException, MalformedURLException {
		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
	 
		URL server = new URL("http://localhost:32769/wd/hub");
		//URL server = new URL(Hubname);
		driver = new RemoteWebDriver(server, capabilities);	
		
		driver.get("http://www.google.com");
		Thread.sleep(15000);
		System.out.println("test1: "+driver.getTitle()+ " :" + "chorme");
		//System.out.println("test1: "+driver.getTitle()+ " :" + browsername);
		driver.quit();
	}
	
}

