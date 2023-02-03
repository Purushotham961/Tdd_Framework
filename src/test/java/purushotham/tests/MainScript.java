package purushotham.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainScript 
{
	@Test
	public void clientApp() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("purushothamtest@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Puru@12345");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement actualProduct = products.stream()
		.filter(product->product.findElement(By.cssSelector(".card-body b")).getText().equalsIgnoreCase("IPHONE 13 PRO"))
		.findFirst().orElse(null);
		actualProduct.findElement(By.cssSelector("[class='btn w-10 rounded']")).click();
		
		WebElement toastElement = driver.findElement(By.cssSelector("#toast-container"));
		wait.until(ExpectedConditions.invisibilityOf(toastElement));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> productsAdded = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = productsAdded.stream().anyMatch(product->product.getText().equalsIgnoreCase("IPHONE 13 PRO"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ta-results list-group ng-star-inserted'] button:last-of-type span")));
		driver.findElement(By.cssSelector("[class='ta-results list-group ng-star-inserted'] button:last-of-type span")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String confMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confMsg);
		driver.quit();
	}
}
