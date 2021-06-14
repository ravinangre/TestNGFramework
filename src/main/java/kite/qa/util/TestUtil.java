package kite.qa.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import kite.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long page_load_timeout = 30;
	public static long implicit_wait = 20;
	public static ITestResult result;
	public static String screenshotName;
	public static WebDriver driver;
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
			screenshotName=result.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
