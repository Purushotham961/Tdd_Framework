package purushotham.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productsAdded;
	
	@FindBy(css=".ng-star-inserted:nth-child(3) button")
	WebElement checkOutBtn;
	
	
	
	public List<WebElement> getListOfProductsAdded()
	{
		waitForListOfWebElementsToAppear(productsAdded);
		return productsAdded;
	}
	
	public Boolean verifyTheProductAdded(String productName)
	{
		Boolean match = getListOfProductsAdded().stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public PaymentPage clickOnProceedToCheckOut()
	{
		checkOutBtn.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}
	
	
}
