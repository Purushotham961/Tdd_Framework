package purushotham.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purushotham.abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents
{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confMsg;
	
	public void printConfirmationMessage()
	{
		System.out.println(confMsg.getText());
	}
}
