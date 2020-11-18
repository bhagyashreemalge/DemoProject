package class1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

public class WebTable {

	@Test(groups = {"smoke"})
	public void cricbuzzfun2() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ganes\\Desktop\\softwares\\latestDrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//DesiredCapabilities dc=new DesiredCapabilities().firefox();
		//WebDriver driver=new RemoteWebDriver(new URL("http://192.168.43.128:4444/wd/hub"), dc);
		driver.get("https://www.cricbuzz.com/");
		String crictrName="";
		int runs=0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='cb-mat-mnu-itm cb-ovr-flo']/following-sibling::a[1]")).click();
		driver.findElement(By.xpath("//a[text()='Scorecard']")).click();
		List<WebElement> webtables=driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		List<WebElement> table1rows=webtables.get(0).findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		//System.out.println(table1rows.size());
		
        for(int i=0;i<table1rows.size()-3;i++)
        {
        	System.out.print(i+" ");
        	crictrName=table1rows.get(i).findElements(By.xpath("//a[@class='cb-text-link']")).get(i).getText();
        	String cruns=table1rows.get(i).findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).getText();
        	runs=Integer.parseInt(cruns);
        	System.out.println(crictrName+" scored = "+runs);
        }
        Log.error("could not execute testcase");
          
	}

}
