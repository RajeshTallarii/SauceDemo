package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import testcases.BaseClass;

public class Scenario2 extends BaseClass {
	WebDriver driver;
	BasePage basePageObject;
	public String homepagePrice;
	public String cartpagePrice;
	By ThirdProduct = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By Cartpage = By.xpath("//a[@class='shopping_cart_link']");
    By MenuIcon = By.xpath("//button[@id='react-burger-menu-btn']");
	By ClickRestApp = By.xpath("//a[@id='reset_sidebar_link']");
	By HomePage = By.xpath("//a[@id='inventory_sidebar_link']");
	By HomePagePrice = By.xpath("(//div[@class='inventory_item_price'])[3]");
	By CartPagePrice = By.xpath("//div[@class='inventory_item_price']");
	By ContinueShopping = By.xpath("//button[@id='continue-shopping']");
	By CrossBtn = By.xpath("//button[@id='react-burger-cross-btn']");

	public Scenario2(WebDriver driver) {
		this.driver = driver;
		basePageObject = new BasePage(driver);
	}

	// Adding 3rd product in the cart
	public void thirdProduct() {
		test=extent.createTest("thirdProduct").assignCategory("Functional Testing").assignDevice("Windows");
		System.out.println("Scenario:2");
	    homepagePrice = driver.findElement(HomePagePrice).getText();
		basePageObject.click(ThirdProduct);
		System.out.println("Step:1 Selected the third product\n");
	}

	// Viewing the cart page
	public void cart() {
		test=extent.createTest("cart").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(Cartpage);
		System.out.println("Step:2 Product is visible in the cart\n");
	}

	// Validate whether selected Item price in the cart and
	// validate that the price of the product is same as in the home page.
	public void verifyPrice() {
		test=extent.createTest("verifyPrice").assignCategory("Functional Testing").assignDevice("Windows");
		//String homepagePrice = driver.findElement(HomePagePrice).getText();
		cartpagePrice = driver.findElement(CartPagePrice).getText();
		Assert.assertEquals(homepagePrice, cartpagePrice);
		System.out.println("Step:3 Product price is same in both home page and cart page\n");
//		if (homepagePrice.equals(cartpagePrice)) {
//			System.out.println("Step:3 Product price is same in both home page and cart page\n");
//		} else {
//			System.out.println("Step:3 Product price verification failed for Script1\n");
//		}
	}
//		String productname = driver.findElement(productName).getText();
//		driver.findElement(AddToCart).click();
//		String homePagePrice=driver.findElement(PriceHomePage).getText();		
//		driver.findElement(cart).click();
//		String productnameCart = driver.findElement(productName).getText();
//		String price_Cart = driver.findElement(priceCart).getText();
//		if(productname.equals(productnameCart)) {
//			System.out.println("Product title verified for Script2");
//		}
//		else {
//			System.out.println("Product title verification failed for Script2");
//		}
//		System.out.println("Price of product in homepage" +homePagePrice);
//		System.out.println("Price of product in cart" +price_Cart);
//
//
//		if(homePagePrice.equals(price_Cart)) {
//
//			System.out.println("price verified");
//		}
//		else {
//			System.out.println("price verification failed");
//		}
//		
//		driver.findElement(continueShopping).click();
//		WebElement Filter = driver.findElement(filter);
//		if(Filter.isDisplayed()) {
//			System.out.println("navigated to home page");
//		}
//		else {
//			System.out.println("navigation to home page failed");
//		}
//	}

	// Clicking on continue shopping
//	public void continueSh() {
//		basePageObject.click(ContinueShopping);
//		System.out.println("Step:4 Navigated to the Home page\n");
//	}
	 //Reset the App state
    public void resetApp() {
		test=extent.createTest("resetApp").assignCategory("Functional Testing").assignDevice("Windows");
    	//basePageObject.hardWait();
    	basePageObject.click(ContinueShopping);
		System.out.println("Step:4 Navigated to the Home page\n");
    	basePageObject.click(MenuIcon);
    	basePageObject.waitFor(ClickRestApp);
    	basePageObject.click(ClickRestApp);
    	System.out.println("Step:5 Resetting the website\n");
    }
    // Back to HomePage
    public void homePage() {
		test=extent.createTest("homePage").assignCategory("Functional Testing").assignDevice("Windows");
    	basePageObject.click(HomePage);
    	basePageObject.click(CrossBtn);
    	System.out.println("Step:6 Navigated to the Home page\n");
    }
}
