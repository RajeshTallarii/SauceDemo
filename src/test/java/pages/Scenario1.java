package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import testcases.BaseClass;

public class Scenario1 extends BaseClass {
	WebDriver driver;
	BasePage basePageObject;
	public String homepageTitle;
	public String cartpageTitle;
	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By Login_Btn = By.xpath("//input[@id='login-button']");
	By AddToCartBtn = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
	By Cartmenu = By.xpath("//a[@class='shopping_cart_link']");
	By HomePageTitle = By.xpath("(//div[@class='inventory_item_name '])[6]");
	By CartPageTitle = By.xpath("//div[@class='inventory_item_name']");
	By MenuIcon = By.xpath("//button[@id='react-burger-menu-btn']");
	By ClickRestApp = By.xpath("//a[@id='reset_sidebar_link']");
	By HomePage = By.xpath("(//a[@class='bm-item menu-item'])[1]");

	public Scenario1(WebDriver driver) {
		this.driver = driver;
		basePageObject = new BasePage(driver);
	}

	// Login into saucedemo
	public void clickLogin() throws Exception {
		test = extent.createTest("clickLogin").assignCategory("Functional Testing").assignDevice("Windows");
//		driver.findElement(username).sendKeys("standard_user");
//		driver.findElement(password).sendKeys("secret_sauce");
//		basePageObject.click(Login_Btn);
		System.out.println("Scenario:1");
		FileInputStream fi = new FileInputStream(
				"C:\\Users\\RTALLARI\\Downloads\\SauceDemo1\\SauceDemo1\\Utilities\\SauceDemo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Sheet1");
		Row row;
		row = ws.getRow(1);
		driver.findElement(username).sendKeys(row.getCell(0).getStringCellValue());
		driver.findElement(password).sendKeys(row.getCell(1).getStringCellValue());
		driver.findElement(Login_Btn).click();
		System.out.println("Step:1 Logged into SauceDemo website\n");
	}

	// Adding product to the cart
	public void addtoCart() {
		test = extent.createTest("addtoCart").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.scrollUntilVisible(AddToCartBtn);
		homepageTitle = driver.findElement(HomePageTitle).getText();
		basePageObject.click(AddToCartBtn);
		System.out.println("Step:2 Product is added into the cart\n");

	}

	// Viewing the cart page
	public void cart() {
		test = extent.createTest("cart").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(Cartmenu);
		System.out.println("Step:3 Product is visible in the cart\n");

	}

	// Validate whether selected Item is present in the cart and
	// validate that the title of the product is same as in the home page.
	public void verifyTitle() {
		test = extent.createTest("verifyTitle").assignCategory("Functional Testing").assignDevice("Windows");
		cartpageTitle = driver.findElement(CartPageTitle).getText();
		Assert.assertEquals(homepageTitle, cartpageTitle);
		System.out.println("Step:4 Product title is same in both home page and cart page\n");
//		if (homepageTitle.equals(cartpageTitle)) {
//			System.out.println("Step:4 Product title is same in both home page and cart page\n");
//		} else {
//			System.out.println("Step:4 Product title verification failed for Script1\n");
//		}
	}

	// Reset the App state
	public void resetApp() {
		test = extent.createTest("resetApp").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(MenuIcon);
		basePageObject.waitForElement(ClickRestApp);
		basePageObject.click(ClickRestApp);
		System.out.println("Step:5 Reseting the website\n");
	}

	// Back to HomePage
	public void homePage() {
		test = extent.createTest("homePage").assignCategory("Functional Testing").assignDevice("Windows");
		basePageObject.click(HomePage);
		System.out.println("Step:6 Returned to the homepage\n");
	}

}
