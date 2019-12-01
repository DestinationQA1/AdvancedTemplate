package com.destinationqa.grid;
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


public class remoteWebDriverExample {
	
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//This will give you how browsers are identified on your system
		System.out.println(DesiredCapabilities.internetExplorer().getBrowserName());
		System.out.println(DesiredCapabilities.chrome().getBrowserName());
		System.out.println(DesiredCapabilities.firefox().getBrowserName());
		
		//This is how you can set browser. The parameter is the output of above commands.
		//capabilities.setBrowserName("chrome");
		//capabilities.setBrowserName("internet explorer");
		capabilities.setBrowserName("firefox");
		
		
			
		/* Remote Web Driver is used to
		 * 	- execute tests on a different machine
		 * 	- execute tests on a different browser (using user input)
		 * 	- execute tests in parallel (on multiple machines)
		*/ 
		
		/*We first need to start the Remote Server on the execution machine by executing this command - 
		*	From command line: 
		*
		*	java -jar selenium-server-standalone-2.41.0.jar
		*
		*
		*	We need to pass the location of the remote Web Driver HUB to the driver instance. 
		*	If your Hub is on the same machine, then you can use localhost. Otherwise, the machine IP
		*   Then You need to start the node by using the following command
		*   
		*   
		*   java -jar selenium-server-standalone-2.41.0.jar -role node -hub http://localhost:4444/grid/register
		*   
		*   
		*   Please use the correct jar file name and make sure that the command is being executed from the 
		*   command prompt and inside the directory where your selenium standalone jar is present.
		*/
		
		
        WebDriver driver = new RemoteWebDriver(
        		new URL("http://localhost:4444/wd/hub"), 
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
		
		//driver.quit();
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
