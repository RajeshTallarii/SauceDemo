package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark = new ExtentSparkReporter("target/report.html");
	public static ExtentTest test;

	public WebDriver driverCreation() {
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public static void setUpExtendReport() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
	}

	@AfterMethod
	public void closeExtend() {
		extent.flush();
	}

	public static void checkStatus(ITestResult result) throws IOException
	{

		if(result.getStatus()==ITestResult.FAILURE)
		{
			setUpExtendReport();
			test.log(Status.FAIL, result.getThrowable());
		}
		else
		{
			setUpExtendReport();
			test.log(Status.PASS, result.getThrowable());
		}

	}
}
