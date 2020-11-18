package class1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Baseclass;

public class AmazonSearch extends Baseclass {
	public static Logger log=LogManager.getLogger(Amazon1.class.getName());
	public WebDriver driver;
	Actions actions;
	
	@Parameters({"URL"})
	@BeforeMethod
	public void initializeDriverWithURL(String URL) throws IOException
	{
		driver=initializeDriver(URL);
		actions=new Actions(driver);
		log.info("driver got initialized");
	}
	
	@Test(groups = {"smoke"})
	public void  searchForProduct()
	{
		driver.findElement(By.xpath("//a[text()='Books']")).click();
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void quitDriver()
	{
		driver.quit();
		log.info("driver got closed");
	}

}
