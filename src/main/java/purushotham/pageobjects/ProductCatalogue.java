package purushotham.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents
{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="#toast-container")
	WebElement toastElement;
	
	By productText = By.cssSelector(".card-body b");
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("[class='btn w-10 rounded']");
	public List<WebElement> getListOfProductsAvalaible()
	{
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement productReq = getListOfProductsAvalaible().stream().filter(product->product.findElement(By.cssSelector(".card-body b")).getText().equalsIgnoreCase(productName))
		.findFirst().orElse(null);
		return productReq;
	}
	
	public void clickOnAddToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToDissappear(toastElement);
	}
	
}
