package ParallelWebTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTest {

	WebDriver driver;

	@Test
	@Parameters("browser")
	public void getFF(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.get("https://www.flipkart.com/");
			Thread.sleep(5);
			String t1 = driver.getTitle();
			System.out.println("title=" + t1);
			/*
			 * driver.switchTo().frame("logo-doodle-iframe"); //WebElement
			 * searchbar=driver.findElement(By.id("realbox")); WebElement
			 * searchbar=driver.findElement(By.name("q"));
			 * 
			 * searchbar.sendKeys("cross browser testing");
			 * System.out.println(searchbar.getText());
			 */
			driver.close();
		}
	}
}

/*
 * @Test public void getChrome() throws InterruptedException {
 * WebDriverManager.chromedriver().setup(); WebDriver driver=new ChromeDriver();
 * driver.get("https://www.fliplart.com/"); String t1=driver.getTitle();
 * System.out.println("Chrome title="+t1);
 * //driver.switchTo().frame("logo-doodle-iframe"); //WebElement
 * searchbar=driver.findElement(By.id("realbox")); WebElement
 * searchbar=driver.findElement(By.name("q"));
 * 
 * searchbar.sendKeys("desk testing"); Thread.sleep(10); String
 * s=searchbar.getText(); System.out.println("text is "+s);
 * 
 * 
 * /* driver.get("https://www.flipkart.com/"); String t2=driver.getTitle();
 * System.out.println("Chrome title="+t2); driver.close();
 */
