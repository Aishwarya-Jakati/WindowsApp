package WinApp;

import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidCalculator
 {
	//static AppiumDriver<WebElement> adriver;
	static AndroidDriver<WebElement> adriver;

	public static void main (String [] args) throws Exception
	{
		openCalculator();
		}
	
	public static <MobileElement> void  openCalculator() throws Exception {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Aishwarya Jakati");
		cap.setCapability("udid", "20fbc63d");
		cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11.0.3.0");
        cap.setCapability("appPackage", "com.miui.calculator");
        cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        adriver=new AndroidDriver<WebElement>(url, cap);
        System.out.println("Application started");
        
		
	}
	
	

}		



