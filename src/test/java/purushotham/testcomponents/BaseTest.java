package purushotham.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
	public WebDriver initializeTheDriver(String OS, String browser) throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		browserName = browser != null ? browser : prop.getProperty("browser");
		String os = OS != null ? OS : prop.getProperty("os");

		emailId = prop.getProperty("email");
		passwordId = prop.getProperty("password");
		productId = prop.getProperty("productName");
		countryId = prop.getProperty("countryName");

		String executionEnv = prop.getProperty("executionEnv");

		if (executionEnv.equalsIgnoreCase("remote")) {
			String hubUrl = "http://localhost:4444/wd/hub";
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

			switch (os.toLowerCase()) {
				case "windows" -> {
					desiredCapabilities.setPlatform(Platform.WIN11);
					setBrowser(desiredCapabilities);
				}
				case "linux" -> {
					desiredCapabilities.setPlatform(Platform.LINUX);
					setBrowser(desiredCapabilities);
				}
				case "mac" -> {
					desiredCapabilities.setPlatform(Platform.MAC);
					setBrowser(desiredCapabilities);
				}
				default -> throw new RuntimeException();
			}
			driver = new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);


		} else {
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
		}

		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	private void setBrowser(DesiredCapabilities desiredCapabilities) {
		switch (browserName.toLowerCase()) {
			case "chrome" -> desiredCapabilities.setBrowserName("chrome");
			case "edge" -> desiredCapabilities.setBrowserName("MicrosoftEdge");
			case "firefox" -> desiredCapabilities.setBrowserName("firefox");
			default -> throw new RuntimeException();
		}
	}

	@Parameters({"os", "browser"})
	@BeforeMethod
	public LandingPage launchApplication(
			@Optional("windows") String os,
			@Optional("chrome") String browser
	) throws Exception {

		driver = initializeTheDriver(os, browser);
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
