//import java.net.MalformedURLException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

//import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class remoteWebdriver {

	public static void main(String[] args) throws MalformedURLException
	{
		 File fExecutable=new File("/home/vibhachugh/firefox/firefox");
	     String NodeURL="http://10.0.9.159:4444/wd/hub";
	     DesiredCapabilities capa =DesiredCapabilities.firefox();
	     capa.setBrowserName("firefox");
	     capa.setCapability("binary", fExecutable);
	     WebDriver driver=new RemoteWebDriver(new URL(NodeURL),capa);

		
		//WebDriver driver = new RemoteWebDriver(new URL("http://10.0.9.159:4444/wd/hub"), capabilities);
		
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		driver.quit(); 
		
	}
}
