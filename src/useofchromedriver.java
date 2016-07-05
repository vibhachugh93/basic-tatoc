import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class useofchromedriver 
{
	public static void main(String[]args) throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver", "/home/vibhachugh/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		//DesiredCapabilities caps = DesiredCapabilities.chrome();
		//caps.setJavascriptEnabled(true);
		//caps.setCapability("chrome.binary", "/home/vibhachugh/Downloads/google-chrome-stable_current_amd64.deb");
		//System.setProperty("webdriver.chrome.driver","/home/vibhachugh/Downloads/chromedriver");
		/*WebDriver driver = new RemoteWebDriver(new URL("http://10.0.9.159:4444/wd/hub"), 
                caps);*/
		//ChromeDriver driver = new ChromeDriver(caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	
}
