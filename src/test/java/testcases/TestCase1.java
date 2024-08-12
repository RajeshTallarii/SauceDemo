package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Scenario1;
import pages.Scenario2;
import pages.Scenario3;
import pages.Scenario4;
import pages.Scenario5;

public class TestCase1 extends BaseClass {

	WebDriver driver;
	Scenario1 scenario1;
	Scenario2 scenario2;
	Scenario3 scenario3;
	Scenario4 scenario4;
	Scenario5 scenario5;



	@BeforeTest
	public void setUp() {

		driver = driverCreation();
		scenario1 = new Scenario1(driver);
		scenario2 = new Scenario2(driver);
		scenario3 = new Scenario3(driver);
		scenario3 = new Scenario3(driver);
		scenario4 = new Scenario4(driver);
		scenario5 = new Scenario5(driver);
		driver.get("https://www.saucedemo.com/");

	}

	@Test
	public void testCase1() throws Exception {
		scenario1.clickLogin();
		scenario1.addtoCart();
		scenario1.cart();
		scenario1.verifyTitle();
		scenario1.resetApp();
		scenario1.homePage();
		scenario2.thirdProduct();
		scenario2.cart();
		scenario2.verifyPrice();
		scenario2.resetApp();
	    scenario2.homePage();
	    scenario3.thirdProduct();
	    scenario3.firstProduct();
	    scenario3.cart();
	    scenario3.removeProduct();
	    scenario3.resetApp();
	    scenario4.verifyAscendingOrderPrice();
	    scenario5.filterDrp();
	    scenario5.resetApp();
	    scenario5.logOut();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
