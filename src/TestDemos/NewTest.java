package TestDemos;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {

  private static WebDriver driver;
	
	@BeforeTest
	@Parameters({"Browser"})
	public void Driverinit(@Optional("chrome") String browserName) {
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sairajath.s\\Downloads\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
		
	
		
	}
	
	@BeforeMethod
	@Parameters({"applicationURL"})
	public void LoadPage(String appURL) {
		
		driver.get(appURL);
		
		
	}
	
	@Test
	public  void alertTestCase() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/input")).click();
		
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());

		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	
	
}
