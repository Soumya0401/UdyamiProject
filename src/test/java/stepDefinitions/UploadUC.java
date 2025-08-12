package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.LoginPage;
import pages.UCUpload;
import base.TestBase;

public class UploadUC extends TestBase {

    UCUpload ucdetPage;

    @Given("User is on the UC form page")
    public void user_is_on_uc_form_page() throws InterruptedException {
        initialization("login_url");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterAadhaarAndPassword();
        loginPage.clickLogin();
        loginPage.loginSuccess();
        ucdetPage = new UCUpload(driver);
        ucdetPage.goToUCUpload();
    }

    @When("User fills in the UC details form with valid data")
    public void user_fills_in_uc_details_form_with_valid_data() throws InterruptedException {
        ucdetPage.fillUCDetailsForm();
    }
//
//    @And("User clicks on the submit button")
//    public void user_clicks_on_the_submit_button() {
//    	ucdetPage.submitForm();
//    }
}
