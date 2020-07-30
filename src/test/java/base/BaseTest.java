package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import pages.HomePage;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//executable//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
			//If the page's SSH certificate is acting up, please use commented section below if you wish to allow the test to proceed
			//driver.findElement(By.xpath("//button[@id='details-button']")).click();
			//driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
	}
	
	public HomePage getDriver() {
		return new HomePage(driver);
	}
	

}
