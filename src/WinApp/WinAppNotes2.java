package WinApp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppNotes2 {
	
public static  WindowsDriver driver=null;

@BeforeMethod
public  void setUp() {
DesiredCapabilities cap = new DesiredCapabilities();
cap.setCapability("app","C:\\Windows\\notepad.exe");
cap.setCapability("platformName","Windows");
cap.setCapability("deviceName","WindowsPC");
//driver=new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
try {
driver=new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
}catch(MalformedURLException e) {
	e.printStackTrace();
}
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}

@Test
public void helpButton() {
	//driver.findElementByName("Help").click();
	driver.findElementByClassName("Help").click();
}

@Test(enabled=false)
public void enterTextinNotes()
{	
WebElement editor=driver.findElement(By.name("Text Editor"));
editor.sendKeys("testing windows App Note and Also test editor page");
System.out.println(editor.getText());
}

@Test(enabled=false)
public void enterDateAndTime() {
	driver.findElementByName("Edit").click();
	driver.findElementByAccessibilityId("26").click();
	String value=driver.findElementByName("Text Editor").getAttribute("Value.Value");
	System.out.println(value);			
}

@AfterMethod
	public void TearDown() {
driver.quit();
	}
}
