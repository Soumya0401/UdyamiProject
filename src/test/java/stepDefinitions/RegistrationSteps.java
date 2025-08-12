package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.UserRegistrationPage;

public class RegistrationSteps extends TestBase {
	UserRegistrationPage regPage;


	@Given("I launch the registration page")
	public void launch_registration_page() {
		initialization("registration_url");  // Reads URL from config via key
		regPage = new UserRegistrationPage(TestBase.driver);
	}

	@When("I fill the registration form with fake data")
	public void fill_form() throws InterruptedException {
		regPage.fillRegistrationForm();
	}

	@And("I submit the form")
	public void submit_form() throws InterruptedException  {
		regPage.clickGetOtp();
	}

	@Then("I confirm the registration")
	public void confirm_registration() throws InterruptedException {
		regPage.clickOnOk();
	}

	@Then("I confirm the success message")
	public void confirm_success() {
		regPage.clickOnSuccess();
	}

	@And("user enter the OTP")
	public void enter_otp() {
		regPage.enterOTP();
	}
	@Then("user verify the OTP")
	public void verify_otp() {
		regPage.verifyotp();
	}
	@ Then("user click on success")
	public void success() {
		regPage.success();
		driver.quit();
	}	 
}
