package TestDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPageClass;

public class POMTestCase {

	private static WebDriver driver;
	
	@BeforeTest
	@Parameters({"applicationURL"})
	public void browserSteup(String appurl) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(appurl);
	}
	
	
	@Test
	public void LoginTestCase() {
		
		LoginPageClass obj=PageFactory.initElements(driver, LoginPageClass.class);
		
		obj.login("Steven", "Steven!123");
		
	}
	
	@AfterTest
	public void quitDriver() {	
		driver.quit();
	}
	
}
