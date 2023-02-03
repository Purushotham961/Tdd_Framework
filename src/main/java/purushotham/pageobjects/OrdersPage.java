package purushotham.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class OrdersPage extends AbstractComponents
{
	WebDriver driver;
	public OrdersPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersPlaced;
	
	public List<WebElement> getListOfOrdersPlaced()
	{
		return ordersPlaced;
	}
	
	public Boolean verigyTheOrderPlaced(String productName)
	{
		Boolean match = getListOfOrdersPlaced().stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
}
