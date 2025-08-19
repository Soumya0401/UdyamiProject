package stepDefinitions;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Setting;
import utilities.ExtentReportManager;

import java.time.Duration;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void setup(Scenario scenario) {

		//🔧 Initialize browser from TestBase for registration
		TestBase.initialization("registration_url");

		// 🔧 Initialize browser from TestBase for login
		  // TestBase.initialization("login_url");
		   driver = TestBase.driver;

		// 📊 Start Extent Report logging
		ExtentReportManager.createTest(scenario.getName());
		ExtentReportManager.getTest().info("🚀 Browser launched for: " + scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (driver != null) {
				//Setting settingPage = new Setting(driver);
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//				try {
//					// Use Setting class method to go to settings page
//					settingPage.goToSettingPage();
//					ExtentReportManager.getTest().info("⚙️ Navigated to Settings page.");
//
//					// Wait and click Logout button
//					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@label='लॉग आउट']"))).click();
//					ExtentReportManager.getTest().info("🔒 Logged out successfully.");
//				} catch (TimeoutException e) {
//					ExtentReportManager.getTest().warning("⚠️ Logout button not clickable or not found within timeout.");
//				} catch (NoSuchElementException e) {
//					ExtentReportManager.getTest().warning("⚠️ Logout button not found.");
//				} catch (Exception e) {
//					ExtentReportManager.getTest().warning("⚠️ Exception during logout: " + e.getMessage());
//				}
//
//				// Log scenario result
//				if (scenario.isFailed()) {
//					ExtentReportManager.getTest().fail("❌ Test Failed: " + scenario.getName());
//				} else {
//					ExtentReportManager.getTest().pass("✅ Test Passed: " + scenario.getName());
//				}
			}
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("⚠️ Error during teardown: " + e.getMessage());
			e.printStackTrace();
		} finally {
			ExtentReportManager.getTest().info("🧹 Closing the browser...");
			TestBase.quitDriver();
			ExtentReportManager.getInstance().flush();
		}
	}
}




