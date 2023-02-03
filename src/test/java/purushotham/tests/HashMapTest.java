package purushotham.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import purushotham.pageobjects.CartPage;
import purushotham.pageobjects.ConfirmationPage;
import purushotham.pageobjects.PaymentPage;
import purushotham.pageobjects.ProductCatalogue;
import purushotham.testcomponents.BaseTest;

public class HashMapTest extends BaseTest
{
	@Test(dataProvider = "getDataFromHashMap")
	public void HashMapOrder(HashMap<String, String> input) throws Exception
	{
		ProductCatalogue productCatalogue = landingPage.loginToApplication(input.get("email"), input.get("password"));
		productCatalogue.getProductByName(input.get("product"));
		productCatalogue.clickOnAddToCart(input.get("product"));
		CartPage cartPage = productCatalogue.clickOnCartHeader();
		Boolean productMatch = cartPage.verifyTheProductAdded(input.get("product"));
		Assert.assertTrue(productMatch);
		PaymentPage paymentPage = cartPage.clickOnProceedToCheckOut();
		paymentPage.selectTheCountry(input.get("country"));
		ConfirmationPage confirmationPage = paymentPage.clickOnPlaceOrder();
		confirmationPage.printConfirmationMessage();
	}
	
	@DataProvider
	public Object[][] getDataFromHashMap()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("email", "purushothamtest@gmail.com");
		data.put("password", "Puru@12345");
		data.put("product", "ADIDAS ORIGINAL");
		data.put("country", "india");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "purushothamtest@gmail.com");
		map2.put("password", "Puru@12345");
		map2.put("product", "ZARA COAT 3");
		map2.put("country", "india");
		
		return new Object[][] {{data}, {map2}};
	}
}
