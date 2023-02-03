package purushotham.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class PaymentPage extends AbstractComponents
{
	WebDriver driver;
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css="[class='ta-results list-group ng-star-inserted'] button:last-of-type span")
	WebElement countrySelected;
		
	@FindBy(css=".action__submit")
	WebElement placeOrder;
		
	public void selectTheCountry(String countryName)
	{
		selectCountry.sendKeys(countryName);
		waitForWebElementsToAppear(countrySelected);
		countrySelected.click();
	}
	
	public ConfirmationPage clickOnPlaceOrder()
	{
		waitForELementToBeClickableByJs(placeOrder);
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
