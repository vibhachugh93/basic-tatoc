import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class flipkart 
{
	 public static void main(String[] args)
	{
	   File fExecutable=new File("/home/vibhachugh/firefox/firefox");
	   FirefoxBinary ffBinary=new FirefoxBinary(fExecutable);
	   FirefoxProfile ffProfile=new FirefoxProfile();
	   WebDriver driver=new FirefoxDriver(ffBinary,ffProfile);
	   driver.get("https://www.flipkart.com");
	   System.out.println(driver.getTitle());
	   driver.close();
	}
	
	
}
