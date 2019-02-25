//run like testsuite to run in parallel all the browsers
package crossBrowsers;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowser {
	
	WebDriver driver;
	
  
	@Test
	@Parameters ("browser")
  public void verifyPageTitle(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Automation\\Drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			//crossBrowser.captureScreenshot(driver);
		}
		
		driver.manage().window().maximize();
		driver.get("https://shop.demoqa.com/");
		System.out.println(driver.getTitle()+"***"+browserName+"***");
		wait(1000);
		crossBrowser.captureScreenshot(driver);
		driver.quit();
  }
	
	public static void captureScreenshot(WebDriver driver) {
		File src=(File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Automatiion\\Workspace\\learn-crossbrowser\\log\\"+System.currentTimeMillis()+".png"));
		}
		catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		
	}
	
	public static void wait(int valor){
		 try {

				Thread.sleep(valor);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}	

		

	}
	
}
