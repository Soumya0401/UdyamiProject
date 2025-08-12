package pages;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReportManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class DocumentUpload {
	WebDriver driver;
	ExtentTest logger = ExtentReportManager.getTest();
	WebDriverWait wait;

	public DocumentUpload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250);");
	}
	
	  @FindBy(xpath = "//button[normalize-space()='OK']")
      WebElement loginSuccess;

	// Header
	@FindBy(xpath = "//h6[contains(text(),'दस्तावेज़ अपलोड')]")
	WebElement documentUploadHeader;

	// Certificate Labels
	@FindBy(xpath = "//label[@for='file-upload-casteCertificate']")
	WebElement casteCertificate;

	@FindBy(xpath = "//label[@for='file-upload-matricCertificate']")
	WebElement matricCertificate;

	@FindBy(xpath = "//label[@for='file-upload-intermediateCertificate']")
	WebElement interCertificate;

	@FindBy(xpath = "//label[@for='file-upload-highestEducationCertificate']")
	WebElement highestCertificate;

	@FindBy(xpath = "//label[@for='file-upload-residentialCertificate']")
	WebElement residentialCertificate;

	@FindBy(xpath = "//label[@for='file-upload-skillTrainingCertificate']")
	WebElement skillCertificate;

	@FindBy(xpath = "//label[@for='file-upload-signature']")
	WebElement signUpload;

	// Common Upload Button
	@FindBy(xpath = "//button[@label='UPLOAD']")
	WebElement uploadButton;

	// OK Button after upload
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement clickOk;

	/** Navigates to the document upload section */
	public void goToDocumentUploadForm() {
		documentUploadHeader.click();
		logger.info("📘 Navigated to Document Upload Module");
	}

//	/** Reusable method to upload a document using Robot */
//	private void uploadDocumentUsingRobot(WebElement label, String filePath) {
//		try {
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", label);
//			label.click(); // Triggers the file picker dialog
//			uploadFileUsingRobot(filePath); // Automates file picker
//			wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();
//			clickOkAfterUpload(); // Handle confirmation popup
//			logger.info("📎 Uploaded using Robot: " + filePath);
//		} catch (Exception e) {
//			logger.fail("❌ Failed to upload using Robot: " + filePath + " - " + e.getMessage());
//			e.printStackTrace();
//		}
//	}

	/** Upload file using Robot class for native dialogs */
	private void uploadFileUsingRobot(String filePath) {
		try {
			Robot robot = new Robot();
			robot.delay(1000);

			StringSelection selection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			logger.info("📂 File path pasted and Enter pressed.");
		} catch (Exception e) {
			logger.fail("❌ Failed to upload file using Robot: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	//** Uploads all required documents using Robot */
//	public void uploadAllDocumentsUsingRobot() {
//		Map<WebElement, String> documentMap = new LinkedHashMap<>();
//		documentMap.put(casteCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
//		documentMap.put(matricCertificate, "C:\\Users\\rajso\\Downloads\\Login&formSubmission.pdf");
//		documentMap.put(interCertificate, "C:\\Users\\rajso\\Downloads\\Login&formSubmissionReport.pdf");
//		documentMap.put(highestCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
//		documentMap.put(residentialCertificate, "C:\\Users\\rajso\\Downloads\\BLUY.pdf");
//		documentMap.put(skillCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
//		documentMap.put(signUpload, "C:\\Users\\rajso\\Downloads\\download (3).png");
//
//		for (Map.Entry<WebElement, String> entry : documentMap.entrySet()) {
//			try {
//				// Scroll to upload label
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entry.getKey());
//				Thread.sleep(500);
//
//				// Click label to open file dialog
//				entry.getKey().click();
//				Thread.sleep(1000);
//
//				// Use Robot to upload file
//				uploadFileUsingRobot(entry.getValue());
//
//				// Scroll to upload button if needed
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
//
//				// Wait and click Upload
//				wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
//				uploadButton.click();
//				logger.info("⬆️ Upload button clicked for: " + entry.getValue());
//
//				// Wait for OK and click if appears
//				try {
//					wait.until(ExpectedConditions.visibilityOf(clickOk));
//					clickOk.click();
//					logger.info("✅ Clicked OK after uploading: " + entry.getValue());
//				} catch (TimeoutException e) {
//					logger.info("⚠️ OK button not shown for: " + entry.getValue());
//				}
//
//				Thread.sleep(500); // Pause before next document
//
//			} catch (Exception e) {
//				logger.fail("❌ Failed to upload: " + entry.getValue() + " - " + e.getMessage());
//				e.printStackTrace();
//			}
//		}
//
//		logger.info("🎯 All documents uploaded with upload button clicked after each.");
//	}

	public void uploadAllDocumentsUsingRobot() {
	    Map<WebElement, String> documentMap = new LinkedHashMap<>();
	    documentMap.put(casteCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
	    documentMap.put(matricCertificate, "C:\\Users\\rajso\\Downloads\\Login&formSubmission.pdf");
	    documentMap.put(interCertificate, "C:\\Users\\rajso\\Downloads\\Login&formSubmissionReport.pdf");
	    documentMap.put(highestCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
	    documentMap.put(residentialCertificate, "C:\\Users\\rajso\\Downloads\\BLUY.pdf");
	    documentMap.put(skillCertificate, "C:\\Users\\rajso\\Downloads\\Personal detail Submit report.pdf");
	    documentMap.put(signUpload, "C:\\Users\\rajso\\Downloads\\download (3).png");

	    for (Map.Entry<WebElement, String> entry : documentMap.entrySet()) {
	        try {
	            WebElement label = entry.getKey();
	            String filePath = entry.getValue();

	            // Scroll to label
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", label);
	            Thread.sleep(500);

	            // Click label to trigger file dialog
	            label.click();
	            Thread.sleep(1000);

	            // Upload file using Robot
	            uploadFileUsingRobot(filePath);

	            // Re-locate fresh upload button
	            WebElement freshUploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@label='UPLOAD']")));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", freshUploadButton);
	            freshUploadButton.click();
	            logger.info("⬆️ Upload button clicked for: " + filePath);

	            // Handle OK button
	            try {
	                WebElement okBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
	                okBtn.click();
	                logger.info("✅ Clicked OK after uploading: " + filePath);
	            } catch (TimeoutException e) {
	                logger.info("⚠️ OK button not shown for: " + filePath);
	            }

	            // Wait 2 seconds before next document
	            Thread.sleep(2000);

	        } catch (Exception e) {
	            logger.fail("❌ Failed to upload: " + entry.getValue() + " - " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    logger.info("🎯 All documents uploaded with proper delay and upload button click.");
	}

	/** Clicks on OK button after successful upload */
	public void clickOkAfterUpload() {
		try {
			wait.until(ExpectedConditions.visibilityOf(clickOk));
			clickOk.click();
			logger.info("✅ Clicked OK after upload success.");
		} catch (Exception e) {
			logger.info("⚠️ OK button not found or not clickable: " + e.getMessage());
		}
	}
}


