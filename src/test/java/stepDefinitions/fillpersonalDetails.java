package stepDefinitions;
import base.TestBase;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.PersonalDetails;

public class fillpersonalDetails extends TestBase {

	PersonalDetails detPage;

	@Given("User is on the Personal Details form page")
	public void user_on_personal_details_page() {
		initialization("login_url");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterAadhaarAndPassword();
		loginPage.clickLogin();
		loginPage.loginSuccess();
		detPage = new PersonalDetails(driver);
	}

	@When("User fills in the personal details form with valid data")
	public void user_fills_personal_details_form() throws InterruptedException {
		detPage.fillDetailsForm();
	}

	@And("User clicks on the Save button")
	public void user_clicks_save_button() {
		detPage.submitForm();
	}

	//	@Then("Personal details should be saved successfully")
	//	public void personal_details_saved_confirmation() {
	//		detPage.verifyFormSubmission();
	//	}
}
