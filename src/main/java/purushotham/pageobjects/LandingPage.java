package purushotham.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	public void goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginToApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	
}
