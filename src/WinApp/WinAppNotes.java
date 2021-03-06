package WinApp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppNotes {
	public static WindowsDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\notepad.exe");
		cap.setCapability("platform", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		}

		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WinAppNotes a = new WinAppNotes();
//a.xPath();
		// a.Actionclass();
//a.RobotHelp();
		// a.JSHelpButton();
//a.FileButtonClick();
		// a.HelpDynamicWait();
		// a.enterTextinNotes();
//a.HelpClickById();
		// a.HelpClickByName1();
		a.HelpClickByName2();
//driver.close();

//a.enterDateAndTime();

	}

	public void JSHelpButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement help2 = driver.findElement(By.name("Help"));

		js.executeScript("arguments[0].click();", help2);
		// js.executeScript("document.getElementByName('Help').click()");
	}

	public void RobotHelp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		driver.findElementByName("Help").click();
	}

	public void Actionclass() throws AWTException {

		WebElement help2 = driver.findElement(By.name("Help"));
		Actions a = new Actions(driver);
		a.moveToElement(help2).perform();
		Robot r = new Robot();
//r.mousePress(MouseEvent.MOUSE_FIRST);
		r.mousePress(MouseEvent.BUTTON1);
	}

	public void xPath() throws InterruptedException {
		driver.findElementsByAccessibilityId("11861");
		Thread.sleep(20);

//driver.findElementByXPath("//button[@Name='Help'])").click();
	}

	public void HelpDynamicWait() {
		try {
			WebElement helpButton = driver.findElement(By.name("Help"));
			WebDriverWait w = new WebDriverWait(driver, 15);
			// WebElement help =
			// w.until(ExpectedConditions.presenceOfElementLocated(By.name("Help")));

			// WebElement help = w.until(ExpectedConditions.visibilityOf(helpButton));
			WebElement help = w.until(ExpectedConditions.elementToBeClickable(helpButton));
			help.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void HelpClickByName1() {
		WebElement helpButton = driver.findElement(By.name("Help"));
		helpButton.click();
	}

	public void HelpClickByName2() {
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();
	}

	public void HelpClickById() {
		driver.findElementById("Help").click();
	}

	public void enterTextinNotes() {
		WebElement editor = driver.findElement(By.name("Text Editor"));
		editor.sendKeys("testing windows App Note and Also test editor page");
		System.out.println(editor.getText());
		driver.close();
		WebElement Save = driver.findElement(By.name("Save"));
		Save.click();
		WebElement FileName = driver.findElement(By.name("File name:"));
		FileName.clear();
		FileName.sendKeys("sherlock.txt");
		WebElement SaveFile = driver.findElement(By.name("Save"));
		SaveFile.click();
		// WebElement SaveFile2 = driver.findElementByAccessibilityId("1001");
		// SaveFile2.click();

		// WebElement dontSave = driver.findElement(By.name("Don't Save"));
		// .click();

	}

	public void enterDateAndTime() {
		driver.findElementByName("Edit").click();
		driver.findElementByAccessibilityId("26").click();
		String value = driver.findElementByName("Text Editor").getAttribute("Value.Value");
		System.out.println(value);
	}

	public void FileButtonClick() {
		driver.findElementByName("File").click();
	}
}
