package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.aventstack.extentreports.ExtentTest;
import utilities.DataGenerator;
import utilities.ExtentReportManager;
import utilities.userData;

import java.time.Duration;

public class UCUpload {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest logger = ExtentReportManager.getTest();

    public UCUpload(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // --- Module Navigation ---
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement loginSuccess;

    @FindBy(xpath = "//h6[contains(text(),'उपयोगिता प्रमाण पत्र')]")
    WebElement utilizationModule;

    @FindBy(xpath = "(//button[contains(text(),'भरने के लिए यहाँ क्लिक करें')])[1]")
    WebElement addUtilizationDetails;

    // --- Form Fields ---
    @FindBy(name = "entries.0.machineInventory")
    WebElement supplierDetails;

    @FindBy(name = "entries.0.gstno")
    WebElement gstName;

    @FindBy(name = "entries.0.billno")
    WebElement billNumber;

    @FindBy(name = "entries.0.machinename")
    WebElement machineName;

    @FindBy(name = "entries.0.mahicnecost")
    WebElement machineCost;
    
    @FindBy(xpath = "//label[@for='file-upload-utilizationCertificate1']")
    WebElement utilizationCertificate;

    @FindBy(id= "file-upload-machineToolsPhoto1")
    WebElement machineTools;

    @FindBy(id= "file-upload-shedPhoto1")
    WebElement shedPhoto;

    @FindBy(xpath = "//button[@label='Save']")
    WebElement clickOnSave;
    
    
    // --- Step 1: Navigate to the UC Module ---
    public void goToUCUpload() throws InterruptedException {
    	utilizationModule.click();
    	Thread.sleep(1000);        
    	logger.info("📘 Navigated to Utilization Module");
    	
        addUtilizationDetails.click();
        logger.info("➕ Clicked on 'Add Utilization Details'");
        
       // utilizationCertificate.click();
        // machineTools.click();
         //shedPhoto.click();
        
        
      
       
    }
    // --- Step 2: Fill in the UC Details Form ---
    public void fillUCDetailsForm() throws InterruptedException {
        userData data = DataGenerator.generateUserData(); // Assumes data includes the below fields

        logger.info("📝 Filled Utilization details ");
        
        supplierDetails.sendKeys(data.supplierDetails);
        gstName.sendKeys(data.supplierGst);
        billNumber.sendKeys(data.supplierBill);
        machineName.sendKeys(data.machineName);
        machineCost.sendKeys(data.machineCost);
        
       
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 450);");
        Thread.sleep(1000);
        
//        utilizationCertificate.click();
//        utilizationCertificate.sendKeys(data.utilizationCertificatePath);
//        
//        machineTools.sendKeys(data.machineToolsPath);
//        shedPhoto.sendKeys(data.shedPhotoPath);
         logger.info("➕ Utilization images Uploaded successfully'");
      
         
    }
   
//    public void submitForm() {
//        wait.until(ExpectedConditions.elementToBeClickable(clickOnSave)).click();
//        logger.info("💾 Clicked on Save button");
//    }
}
