package purushotham.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import purushotham.pageobjects.LandingPage;

public class BaseTest 
{
	public String browserName;
	public String emailId;
	public String passwordId;
	public String productId;
	public String countryId;
	
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeTheDriver() throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");
		emailId = prop.getProperty("email");
		passwordId = prop.getProperty("password");
		productId = prop.getProperty("productName");
		countryId = prop.getProperty("countryName");
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws Exception
	{
		driver = initializeTheDriver();
		landingPage = new LandingPage(driver);
		landingPage.goToUrl();
		return landingPage;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws Exception
	{
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(srcFile, destFile);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
}
