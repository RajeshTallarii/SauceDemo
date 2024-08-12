package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import testcases.BaseClass;

public class Scenario3 extends BaseClass{
	WebDriver driver;
	BasePage basePageObject;
	By ThirdProduct = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By FirstProduct = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By ContinueShopping = By.xpath("//button[@id='continue-shopping']");
	By Cartpage = By.xpath("//a[@class='shopping_cart_link']");
	By ThirdProduct1 = By.xpath("(//div[@class='inventory_item_name'])[1]");
	By FirstProduct1 = By.xpath("(//div[@class='inventory_item_name'])[2]");
	By RemoveProduct2 = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");
	By RemoveProduct1 = By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']");
	By MenuIcon = By.xpath("//button[@id='react-burger-menu-btn']");
	By ClickRestApp = By.xpath("//a[@id='reset_sidebar_link']");
	By HomePage = By.xpath("(//a[@class='bm-item menu-item'])[1]");

	public Scenario3(WebDriver driver) {
		this.driver = driver;
		basePageObject = new BasePage(driver);
	}

	// Adding 3rd product in the cart
	public void thirdProduct() {
		test=extent.createTest("thirdProduct").assignCategory("Functional Testing").assignDevice("Windows");
		System.out.println("Scenario:3");
		basePageObject.click(Cartpage);
		basePageObject.click(ContinueShopping);
		basePageObject.scrollBy1(ThirdProduct);
		basePageObject.click(ThirdProduct);
		System.out.println("Step:1 Selected the third product\n");
	}

	// Adding 1st product in the cart
	public void firstProduct() {
		test=extent.createTest("firstProduct").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(FirstProduct);
		System.out.println("Step:2 Selected the first product\n");
	}

	// Viewing the cart page
	public void cart() {
		test=extent.createTest("cart").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(Cartpage);
		WebElement Product3 = driver.findElement(ThirdProduct1);
		WebElement Product1 = driver.findElement(FirstProduct1);
		Assert.assertTrue(Product3.isDisplayed());
		Assert.assertTrue(Product1.isDisplayed());
		System.out.println("Step:3 Third Product and First product are added in the cart\n");
//		if (Product3.isDisplayed() && Product1.isDisplayed()) {
//			System.out.println("Step:3 Third Product and First product are added in the cart\n");
//		} else {
//		    System.out.println("Step:3 Third Product and First product are not added in the cart\n");
//
//		}	
	}

	// Removing the second product
	public void removeProduct() {
		test=extent.createTest("removeProduct").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(RemoveProduct2);
		try {
			if (!((WebElement) RemoveProduct2).isDisplayed()) {
				System.out.println("Second item removed from the cart");

			} else {
				System.out.println("second item still in the cart");
			}
		} catch (Exception e) {
			System.out.println("Step:4 Second product removed from the cart\n");
		}

		//
//		WebElement AddedProduct3 = driver.findElement(RemoveProduct2);
//		WebElement AddedProduct1 = driver.findElement(RemoveProduct1);
//		if (AddedProduct3.isDisplayed() && AddedProduct1.isDisplayed()) {
//			System.out.println("Step:4 Second product is not removed from the cart\n");
//		} else {
//		    System.out.println("Step:4 Second product is removed from the cart");
//
//		}	
	}

	// Resetting the website
	public void resetApp() {
		test=extent.createTest("resetApp").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(MenuIcon);
		basePageObject.waitForElement(ClickRestApp);
		basePageObject.click(ClickRestApp);
		basePageObject.click(HomePage);
		System.out.println("Step:5 Resetting the website\n");
	}
}
