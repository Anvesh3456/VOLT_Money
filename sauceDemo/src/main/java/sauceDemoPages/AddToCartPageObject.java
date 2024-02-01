package sauceDemoPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class AddToCartPageObject extends Login {

	public static String addToCartXpath = "//button[contains(@class,'btn_inventory')]";
	public static String cartLinkxpath = "//a[@class='shopping_cart_link']";
	public static String checkout_firstname = "//input[@id='first-name']";
	public static String checkout_lastname = "//input[@id='last-name']";
	public static String checkout_zipcode = "//input[@id='postal-code']";
	public static String continue_button = "//input[@id='continue']";
	
	public static String finish_button_Xpath = "//button[@id='finish']";
	public void addToCart() {
		
		List<WebElement> cartlist = driver.findElements(By.xpath(addToCartXpath));
		for(WebElement individualcart : cartlist ) {
			individualcart.click();
		}
	}
	public void navigateToCartPAge() {
		try {
			WebElement myCart = driver.findElement(By.xpath(cartLinkxpath));
			System.out.println("Navigate to My Cart page");
			myCart.click();
			
		}catch(Exception e) {
			System.out.println("Exceptione in navigate to cart Page"+e.getMessage());
		}
	}
	public static String yourcartCheckout ="//button[@id='checkout']";
	public void clickOncheckoutBtn() {
		try {
			WebElement mycheckoutBtn = driver.findElement(By.xpath(yourcartCheckout));
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", mycheckoutBtn);
		        System.out.print("Scroll into view of my checkout button");
		        Thread.sleep(4000);
		        mycheckoutBtn.click();
		}catch(Exception e) {
			System.out.println("exception in click on checkout button"+e.getMessage());
		}
	}
	
	public void checkoutFormPage(String firstname , String lastname,String zipcode) {
		try {
			driver.findElement(By.xpath(checkout_firstname)).sendKeys(firstname);
			Thread.sleep(4000);
			System.out.println("Entered first name"+firstname);
			driver.findElement(By.xpath(checkout_lastname)).sendKeys(lastname);
			Thread.sleep(5000);
			System.out.println("Entered  lastname"+lastname);
			driver.findElement(By.xpath(checkout_zipcode)).sendKeys(zipcode);
			Thread.sleep(5000);
			System.out.println("Entered  zipcode"+zipcode);
			Thread.sleep(5000);
			driver.findElement(By.xpath(continue_button)).click();
			Thread.sleep(5000);
			System.out.println("click on continue_button");
			
		}catch(Exception e) {
			System.out.println("checkout form page "+e.getMessage());
		}
	}
	
	public void clickonFinish() {
		try {
			driver.findElement(By.xpath(finish_button_Xpath)).click();
			System.out.println("click on finish button");
		}catch(Exception e) {
			System.out.println("click on finish Failed");
		}
	}
}
