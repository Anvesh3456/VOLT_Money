package sauceDemoTestRunner;

import org.testng.annotations.Test;

import sauceDemoPages.AddToCartPageObject;
import sauceDemoPages.Login;

public class TestPage {
	String browsername = "chrome";
	String baseUrl = "https://www.saucedemo.com/";
	String username = "standard_user";
	String password = "secret_sauce";
	String first = "first";
	String last = "last";
	String zip = "123456";
	@Test
	public void loginUser() {
		try {
			AddToCartPageObject obj = new AddToCartPageObject();
			Login lp = new Login();
		    lp.launch(browsername, baseUrl);
		    lp.login(username, password);
		    obj.addToCart();
		    obj.navigateToCartPAge();
		    obj.checkoutFormPage(first, last, zip);
		    obj.clickOncheckoutBtn();
		    obj.clickonFinish();
		}catch(Exception e) {
			System.out.println("failed login user");
		}
	}
}
