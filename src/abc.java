import org.openqa.selenium.Cookie;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class abc 
{
	public static void main(String[] args) throws InterruptedException 
	{
		File ffExecutable=new File("/home/vibhachugh/firefox/firefox");
	    FirefoxBinary ffBinary=new FirefoxBinary(ffExecutable);
    	FirefoxProfile ffProfile=new FirefoxProfile();
		WebDriver driver=new FirefoxDriver(ffBinary,ffProfile);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
		//Problem 1
		
		driver.findElement(By.className("greenbox")).click();
		Thread.sleep(1000);
		//driver.navigate().to("http://10.0.1.86/tatoc/basic/frame/dungeon");
		//driver.findElement(By.className("redbox")).click();
		//driver.navigate().to("http://10.0.1.86/tatoc/error");
		
		//Problem 2
		
		driver.switchTo().frame("main");
		String class1=driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().frame("child");
		String class2=driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		
		while(!class1.equals(class2))
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			Thread.sleep(1000);
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			class2=driver.findElement(By.id("answer")).getAttribute("class");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Proceed")).click();
		
		//Problem 3
		
		WebElement element=driver.findElement(By.id("dragbox"));
		WebElement target=driver.findElement(By.id("dropbox"));
		(new Actions(driver)).dragAndDrop(element,target).perform();
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(100);
		
		//Problem 4
		
		String mainwindow=driver.getWindowHandle();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		for(String winhandle:driver.getWindowHandles())
		{
			driver.switchTo().window(winhandle);
			if(driver.getTitle().equals("Popup - Basic Course - T.A.T.O.C"))
			{
				break;
			}
		}
        driver.findElement(By.id("name")).sendKeys("vibhachugh");
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window(mainwindow);
        Thread.sleep(1000);
        driver.findElement(By.linkText("Proceed")).click();
        Thread.sleep(1000);
        
        
        //Problem 5
        
        driver.findElement(By.linkText("Generate Token")).click();
        String s =driver.findElement(By.id("token")).getText();
        int k=s.length();
        String s3=s.substring(7,k);
        s3="Token="+s3;
        Cookie c=new Cookie("mycookie",s3);
        driver.manage().addCookie(c);
        driver.findElement(By.linkText("Proceed")).click();
        driver.quit();
	}
}