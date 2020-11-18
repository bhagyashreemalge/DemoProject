package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

	WebDriver driver;
	
	public AmazonLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[type='email']")
	private WebElement username;
	
	@FindBy(css = "#continue")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(css="#signInSubmit")
	private WebElement signinButton;
	
	public WebElement username()
	{
		return username;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	
	public WebElement signinButton()
	{
		return signinButton;
	}

	public WebElement continueButton()
	{
		return continueButton;
	}
	
	
}
