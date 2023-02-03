package purushotham.abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import purushotham.pageobjects.CartPage;
import purushotham.pageobjects.OrdersPage;

public class AbstractComponents 
{
	WebDriver driver;
	public AbstractComponents(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForWebElementsToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public void waitForListOfElementsToAppear(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));		
	}
	
	public void waitForListOfWebElementsToAppear(List<WebElement> elements)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));		
	}
	
	public void waitForElementToDissappear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForELementToBeClickableByJs(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersHeader;
	
	public CartPage clickOnCartHeader()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage clickOnOrdersHeader()
	{
		ordersHeader.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
}
