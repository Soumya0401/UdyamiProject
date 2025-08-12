package stepDefinitions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps extends TestBase {

	LoginPage loginPage;

	@Given("User is on the login page with a registered Aadhaar")
	public void user_is_on_login_page() {
		initialization("login_url");  // Reads URL from config via key
		loginPage = new LoginPage(TestBase.driver);
	}

	@When("User enters valid Aadhaar and password")
	public void user_enters_valid_credentials() {
		loginPage.enterAadhaarAndPassword(); // Reads Aadhaar & Password from ConfigReader
	}

	@And("User clicks the Login button")
	public void user_clicks_login_button() throws InterruptedException {
		loginPage.clickLogin();
		Thread.sleep(10000);
	}

	@Then("User should be logged in successfully")
	public void verify_login_success() {
		try {

			// Wait until a known dashboard element is visible after login
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			loginPage.loginSuccess();
			System.out.println("✅ Login success. User redirected to dashboard.");

		} catch (TimeoutException e) {
			System.out.println("❌ Login failed or dashboard not loaded in time.");
			throw new AssertionError("Dashboard did not appear after login");
		}
	}

}


