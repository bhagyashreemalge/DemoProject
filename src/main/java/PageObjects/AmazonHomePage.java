package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Before Login
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement navsigninButton;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	private WebElement navaccountList;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchTextbox;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement SignoutButton;
	
	public WebElement navsigninButton()
	{
		return navsigninButton;
	}
	public WebElement navaccountList()
	{
		return navaccountList;
	}
	
	public WebElement searchTextbox()
	{
		return searchTextbox;
	}
	
	public WebElement getSignoutButton()
	{
		return SignoutButton;
	}
	
	public AmazonLoginPage clickSigninButton()
	{
		navsigninButton.click();
		return new AmazonLoginPage(driver);
	}
}
