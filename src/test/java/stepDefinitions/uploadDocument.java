//package stepDefinitions;
//import base.TestBase;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import pages.DocumentUpload;
//import pages.EducationDetails;
//
//public class uploadDocument extends TestBase {
//
//	DocumentUpload docPage;
//	EducationDetails eduDetails;
//	
//    @Given("User is on the document upload form page")
//    public void user_on_document_upload_page() {
//        initialization("login_url"); // Start browser and open the application
//        
//        eduDetails = new EducationDetails(driver);
//        docPage = new DocumentUpload(driver);
//        docPage.goToDocumentUploadForm();
//    }
//
//    @When("User uploads a valid document")
//    public void user_uploads_all_documents() throws InterruptedException {
//        docPage.uploadAllDocumentsUsingRobot();
//    }
//    
//    @And("User clicks on the ok button")
//    public void user_clicks_on_okbtn() {
//        docPage.clickOkAfterUpload();
//    }
//}
//
