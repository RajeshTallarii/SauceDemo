package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import testcases.BaseClass;

public class Scenario5 extends BaseClass{
	WebDriver driver;
	BasePage basePageObject;
	By filter = By.xpath("//select");
	By Product3 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By Product1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By count = By.xpath("//span[@class='shopping_cart_badge']");
	By MenuIcon = By.xpath("//button[@id='react-burger-menu-btn']");
	By ClickRestApp = By.xpath("//a[@id='reset_sidebar_link']");
	By logout = By.xpath("//a[@id='logout_sidebar_link']");

	public Scenario5(WebDriver driver) {
		this.driver = driver;
		basePageObject = new BasePage(driver);
	}

//method for scenario5
	public void filterDrp() {
		test=extent.createTest("filterDrp").assignCategory("Functional Testing").assignDevice("Windows");
		System.out.println("Scenaro:5");
		// Selecting the desired filter
		WebElement Filter = driver.findElement(filter);
		Select Drp = new Select(Filter);
		Drp.selectByIndex(1);
		System.out.println("Step:1 Selecting Name (Z to A)\" from dropdown.\n");
		// adding the desired items to the cart
		basePageObject.click(Product1);
		basePageObject.click(Product3);
		String Count = driver.findElement(count).getText();
		// verifying weather cart displaying the number of products in it correctly
		if (Count.equals("2")) {
			System.out.println("Step:2 Cart icon displaying number of products correctly\n");
		} else {
			System.out.println("Step:2 Cart icon displaying number of products incorrectly\n");
		}
	}

	// Resetting the App state
	public void resetApp() {
		test=extent.createTest("resetApp").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(MenuIcon);
		basePageObject.waitForElement(ClickRestApp);
		basePageObject.click(ClickRestApp);
		System.out.println("Step:3 Resetting the website\n");
		// Validating whether cart is empty or not

		try {
			if (driver.findElement(count).isDisplayed()) {
				System.out.println("App state is not reset\n");
			} else {
				System.out.println("App state is reset\n");
			}
		} catch (Exception e) {
			System.out.println("Step:4 App state is reset\n");
		}
	}

	// Logging out from the page
	public void logOut() {
		test=extent.createTest("logOut").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(logout);
		System.out.println("Step:5 Successfully logged out from the page");
	}

}
