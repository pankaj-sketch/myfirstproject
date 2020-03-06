package AmazonTestCases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseAmazon.Testutil;

public class xlReading {
	WebDriver driver;
@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumdemos\\FlipCartFramework\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		}
@DataProvider
	public Object[][] getLogData() throws InvalidFormatException {
	Object data [][]=Testutil.getTestdata("Sheet1");
	return data;
}


@Test(dataProvider = "getLogData")	
    public void loginTest(String username, String password) {
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	     
}
@AfterMethod
    public void teardown() {
	  driver.quit();
}

}
