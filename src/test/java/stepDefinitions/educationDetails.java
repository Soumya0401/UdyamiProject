package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.*;
import pages.EducationDetails;
import pages.PersonalDetails;

public class educationDetails extends TestBase {

	EducationDetails eduPage;
	PersonalDetails personalPage;

	@Given("User is on the Education Details form page")
	public void user_on_education_details_page() throws InterruptedException {
		initialization("login_url"); // Ensure WebDriver is initialized

		// Submit personal details before education form
		personalPage = new PersonalDetails(driver);

		// Now navigate to Education form
		eduPage = new EducationDetails(driver);
		eduPage.goToEducationForm();
	}

	@When("User fills in the education details form with valid data")
	public void user_fills_education_details_form() {
		eduPage.fillEducationForm();
	}

	@And("User clicks on the Add button")
	public void user_clicks_add_button() {
		eduPage.clickAddButton();
	}

	@Then("User Click on ok for Add the document")
	public void user_click_on_ok_button()
	{
		eduPage.clickokforSuccess();

	}

	//    @Then("Education details should be saved successfully")
	//    public void education_details_saved_confirmation() {
	//        eduPage.verifyEducationDetailsSaved();
	//    }
}

