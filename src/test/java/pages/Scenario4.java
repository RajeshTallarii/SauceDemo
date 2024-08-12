package pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import testcases.BaseClass;

public class Scenario4 extends BaseClass{
	WebDriver driver;
	BasePage basePageObject;
	By BeforeFilterPrice = By.xpath("//div[@class='inventory_item_price']");
	By Filter = By.xpath("//select[@class='product_sort_container']");
	By FirstProduct = By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
	By SecondProduct = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By Cartpage = By.xpath("//a[@class='shopping_cart_link']");
	By checkout = By.xpath("//button[@id='checkout']");
	By firstname = By.xpath("//input[@id='first-name']");
	By lastname = By.xpath("//input[@id='last-name']");
	By zipcode = By.xpath("//input[@id='postal-code']");
	By Continue = By.xpath("//input[@id='continue']");
	By finish = By.xpath("//button[@id='finish']");
	By confirmation = By.xpath("//h2[text()='Thank you for your order!']");
	By backtoHome = By.xpath("//button[@id='back-to-products']");
	By MenuIcon = By.xpath("//button[@id='react-burger-menu-btn']");
	By ClickRestApp = By.xpath("//a[@id='reset_sidebar_link']");
	By HomePage = By.xpath("(//a[@class='bm-item menu-item'])[1]");

	public Scenario4(WebDriver driver) {
		this.driver = driver;
		basePageObject = new BasePage(driver);
	}

	// Validate that products are displayed as selected price low to high.
	public void verifyAscendingOrderPrice() throws Exception {
		test=extent.createTest("verifyAscendingOrderPrice").assignCategory("Functional Testing").assignDevice("Windows");
		System.out.println("Scenario: 4");
		System.out.println("Step:1 Price list before filter\n");
		// 1. before filter capture the prices
		List<WebElement> beforeFilterPrice = driver.findElements(BeforeFilterPrice);
		// 1.1 remove the $ symbol from the price and convert the string into double
		List<Double> beforeFilterPriceList = new ArrayList<>();

		for (WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
			//System.out.println(beforeFilterPriceList);
		}

		// 2. filter the price from the dropdown
		WebElement filter = driver.findElement(Filter);
		Select dropdown = new Select(filter);
		dropdown.selectByIndex(2);
		System.out.println("Step:2 Selected the price low to high in dropdown filter\n");

		System.out.println("Step:3 Price list after filter\n");

		// 3. after filter capture the prices
		List<WebElement> afterFilterPrice = driver.findElements(BeforeFilterPrice);
		// 3.1 remove $ symbol from the price and convert the string into double
		List<Double> afterFilterPriceList = new ArrayList<>();

		for (WebElement p : afterFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
			//System.out.println(afterFilterPriceList);
		}

		// 4. Compare the values/Assert the values (first we need to sort the values of
		// beforeFilterPrice)
		Collections.sort(beforeFilterPriceList); // it will sort the values in the list
		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
		System.out.println("Step:4 Products prices are in ascending order\n");
		//basePageObject.hardWait();
//		if (beforeFilterPriceList.equals(afterFilterPriceList)) {
//			System.out.println("Step:4 Products are sorted by price (low to high) successfully!\n");
//		} else {
//			System.out.println("Step:4 Products are not sorted correctly by price (low to high).\n");
//		}

		basePageObject.click(FirstProduct);
		basePageObject.click(SecondProduct);
		basePageObject.click(Cartpage);
		basePageObject.click(checkout);

		FileInputStream fi = new FileInputStream(
				"C:\\Users\\RTALLARI\\Downloads\\SauceDemo1\\SauceDemo1\\Utilities\\SauceDemo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Sheet1");
		Row row;
		row = ws.getRow(1);
		driver.findElement(firstname).sendKeys(row.getCell(2).getStringCellValue());
		driver.findElement(lastname).sendKeys(row.getCell(3).getStringCellValue());
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(row.getCell(4));
		driver.findElement(zipcode).sendKeys(val);
		driver.findElement(Continue).click();
		driver.findElement(finish).click();
		WebElement Confirmation = driver.findElement(confirmation);
		Assert.assertTrue(Confirmation.isDisplayed());
		System.out.println("Step:5 order placed successfully\n");
//		if (Confirmation.isDisplayed()) {
//			System.out.println("Step:5 order placed successfully\n");
//		} else {
//			System.out.println("Step:5 order not placed");
//		}
		driver.findElement(backtoHome).click();
		System.out.println("Step:6 navigated to the homePage\n");

//		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
//		System.out.println("Step:4 Products prices are in ascending order\n");
//		//basePageObject.hardWait();
	}

//	//Resetting the website
//		public void resetApp() {
//			basePageObject.click(MenuIcon);
//			basePageObject.waitForElement(ClickRestApp);
//			basePageObject.click(ClickRestApp);
//			basePageObject.click(HomePage);
//	    	System.out.println("Step:6 Resetting the website\n");
//		}

//	// Add multiple products into the cart
//	public void addProducts() {
//		basePageObject.click(FirstProduct);
//		basePageObject.click(SecondProduct);
//
//	}
//
//	// Viewing the cart page
//	public void cart() {
//		basePageObject.click(Cartpage);
//	}

}
