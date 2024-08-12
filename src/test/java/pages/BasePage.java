package pages;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// method used for clicking
	public void click(By locator) {

		driver.findElement(locator).click();
	}
	
	
	// clickUsingJavaScript method
	public void clickUsingJavaScript(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(locator));

	}

	// scrollUntilVisible method
	public void scrollUntilVisible(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", flag);
	}

	// scrollBy method
	public void scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400)", "");
	}

	// scrollBy1 method
	public void scrollBy1(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
	}
	// waitFor method
		public void waitFor(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		// waitUntilElementIsClickable
		public void waitForElement(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		// waitForInvisibility method
		public void waitForInvisibility(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}
		//Thread.sleep
		public void hardWait() {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	

	
}

