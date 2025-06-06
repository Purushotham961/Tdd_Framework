package purushotham.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import purushotham.pageobjects.CartPage;
import purushotham.pageobjects.ConfirmationPage;
import purushotham.pageobjects.OrdersPage;
import purushotham.pageobjects.PaymentPage;
import purushotham.pageobjects.ProductCatalogue;
import purushotham.testcomponents.BaseTest;
import purushotham.testcomponents.Retry;

public class Shopping extends BaseTest
{
	@Parameters("userEmail")
	@Test
	public void clientApp(
			@Optional("purushotham@gmail.com") String userEmail
	)
	{
		ProductCatalogue productCatalogue = landingPage.loginToApplication(userEmail, passwordId);
		productCatalogue.getProductByName(productId);
		productCatalogue.clickOnAddToCart(productId);
		CartPage cartPage = productCatalogue.clickOnCartHeader();
		Boolean productMatch = cartPage.verifyTheProductAdded(productId);
		Assert.assertTrue(productMatch);
		PaymentPage paymentPage = cartPage.clickOnProceedToCheckOut();
		paymentPage.selectTheCountry(countryId);
		ConfirmationPage confirmationPage = paymentPage.clickOnPlaceOrder();
		confirmationPage.printConfirmationMessage();
	}
	
	@Test(dependsOnMethods = "clientApp", retryAnalyzer = Retry.class)
	public void verifyTheOrder() throws Exception
	{
		ProductCatalogue productCatalogue = landingPage.loginToApplication(emailId, passwordId);
		OrdersPage ordersPage = productCatalogue.clickOnOrdersHeader();
		Boolean match = ordersPage.verigyTheOrderPlaced(productId);
        Assert.fail();
	}
}
