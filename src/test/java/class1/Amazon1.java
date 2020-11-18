package class1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjects.AmazonHomePage;
import PageObjects.AmazonLoginPage;
import Utilities.Baseclass;
import Utilities.DataDrive;

public class Amazon1 extends Baseclass {
	
	public static Logger log=LogManager.getLogger(Amazon1.class.getName());

	public WebDriver driver;
	Select select;
	Actions actions;
	List<WebElement> itemsdisplayedonnavbar;
	List<WebElement> itemsonnavbar;
	WebElement navaccount;
	WebElement searchTextbox;
	AmazonLoginPage alp;
	AmazonHomePage ahomep;
	
	@Parameters({"URL"})
	@BeforeMethod
	public void initializeBDriver() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://www.amazon.in/");
		actions=new Actions(driver);
		log.info("driver got initialized");
		
	}
	
	@AfterMethod
	public void quitDriver()
	{
		driver.quit();
		log.info("driver got closed");
	}
	
	@Test(groups = {"smoke"},dataProvider = "getData")
	public void amazonLogin(String username, String password) throws IOException {
		// TODO Auto-generated method stub
		
		//DesiredCapabilities dc=new DesiredCapabilities().chrome();
		//WebDriver driver=new RemoteWebDriver(new URL("http://192.168.43.128:4444/wd/hub"), dc);
		ahomep=new AmazonHomePage(driver);
		actions.moveToElement(ahomep.navaccountList()).build().perform();
		alp=ahomep.clickSigninButton();
		//DataDrive dd=new DataDrive();
		//ArrayList al=dd.getData("user1");
		alp.username().sendKeys(username);
		alp.continueButton().click();
	    alp.password().sendKeys((password));
		alp.signinButton().click();
		log.info("successfully logged in");
		actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		ahomep.getSignoutButton().click();
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File(System.getProperty("user.dir")+"\\screenshots\\screenshot1.png"));
		
		}
		
		@Test
		public void selectAndSearchItem()
		{
			//select = new Select(driver.findElement(By.cssSelector("select#searchDropdownBox")));
			//select.selectByVisibleText("Computers & Accessories");
			
			searchTextbox = driver.findElement(By.id("twotabsearchtextbox"));
			//searchTextbox=ahomep.searchTextbox();
			// searchTextbox.sendKeys("laptops");
			actions.moveToElement(searchTextbox).click().keyDown(Keys.SHIFT).sendKeys("laptops").build().perform();
			driver.findElement(By.cssSelector("span[id='nav-search-submit-text'] input")).click();
			log.debug("clicked on search icon");
		}

		

		
		@Test
		public void amazonMenuLinks()
		{
			WebElement navbaronhomepage=driver.findElement(By.cssSelector("#nav-xshop"));
			itemsonnavbar=navbaronhomepage.findElements(By.tagName("a"));
			itemsdisplayedonnavbar=new ArrayList();
			for(int i=0;i<itemsonnavbar.size();i++)
			{
				if(itemsonnavbar.get(i).isDisplayed())
				{
					itemsdisplayedonnavbar.add(itemsonnavbar.get(i));
					String keybordchord=Keys.chord(Keys.CONTROL,Keys.ENTER);
					itemsonnavbar.get(i).sendKeys(keybordchord);
					
				}
			}
			
			Set<String> windowhandles=driver.getWindowHandles();
				System.out.println(itemsdisplayedonnavbar.size());
				System.out.println(windowhandles.size()-1);
			
			Iterator<String> it=windowhandles.iterator();
			it.next();
			while(it.hasNext())
			{
				String curwindowid=it.next();
				driver.switchTo().window(curwindowid);
				System.out.println(driver.getTitle());
			}
		}
		
		@DataProvider
		public Object[][] getData()
		{
			Object[][] data=new Object[2][2];
			data[0][0]="malge@gmail.com";
			data[0][1]="1234";
			data[1][0]="bhagyashreemalge@gmail.com";
			data[1][1]="Access@123";
			return data;
		}

}
