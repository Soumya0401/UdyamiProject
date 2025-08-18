//package stepDefinitions;
//
//import base.TestBase;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import pages.DocumentUpload;
//import pages.EducationDetails;
//import pages.Setting;
//
//public class changePassword extends TestBase {
//
//	EducationDetails eduDetails;
//	DocumentUpload docPage;
//	Setting chngPwd;
//
//	@Given("User is on the settings page")
//	public void user_on_settings_page() {
//		// 🚀 Launch browser and open the login page
//		initialization("login_url");
//
//		// 📄 Go to document upload form
//		docPage = new DocumentUpload(driver);
//		docPage.goToDocumentUploadForm();
//
//		// ⚙️ Now go to Settings page
//		chngPwd = new Setting(driver);
//		chngPwd.goToSettingPage();
//	}
//
//	@When("User enters the old password, new password, and confirm password")
//	public void user_enters_password_details() {
//		chngPwd.enterPasswords("OldPass123", "NewPass@123", "NewPass@123");
//	}
//
//	//    @And("User clicks on the Change Password button")
//	//    public void user_clicks_change_password_button() {
//	//        chngPwd.clickChangePassword();
//	//    }
//
//	//    @Then("Password should be changed successfully")
//	//    public void password_should_be_changed_successfully() {
//	//        chngPwd.verifyPasswordChange();
//	//    }
//}
