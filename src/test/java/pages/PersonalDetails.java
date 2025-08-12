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

public class PersonalDetails {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest logger = ExtentReportManager.getTest();

    public PersonalDetails(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(name = "dob") WebElement dateofBirth;
    @FindBy(name = "guardian") WebElement guardianName;
    @FindBy(name = "disability") WebElement disability;
    @FindBy(name = "locality") WebElement address;
    @FindBy(name = "city") WebElement cityType;
    @FindBy(name = "panchayat") WebElement panchayatName;
    @FindBy(name = "ps") WebElement policeStation;
    @FindBy(name = "districtId") WebElement districtName;
    @FindBy(name = "blockId") WebElement blockName;
    @FindBy(name = "pin") WebElement pinCode;
    @FindBy(name = "scstType") WebElement categoryType;
    @FindBy(name = "caste") WebElement casteName;

    @FindBy(xpath = "//button[@label='Save']") 
    WebElement clickOnSave;

   // @FindBy(xpath = "//div[contains(text(),'saved successfully') or contains(text(),'successfully submitted')]")
    //WebElement successMessage;

    public void fillDetailsForm() throws InterruptedException {
        userData data = DataGenerator.generateUserData();
        logger.info("📝 Filling personal details form with generated test data.");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350);");
        wait.until(ExpectedConditions.visibilityOf(dateofBirth));

        dateofBirth.clear();
        dateofBirth.sendKeys(data.dateofBirth);

        guardianName.clear();
        guardianName.sendKeys(data.guardianName);

        // ✅ Correct handling of radio button for guardianType
       // selectGuardianType(data.guardianType);

        selectDropdownByInputName("disability", data.disability);
        
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
//      Thread.sleep(1000);

        address.clear();
        address.sendKeys(data.address);

        cityType.sendKeys(data.cityType);
        panchayatName.clear();
        panchayatName.sendKeys(data.panchayat);
        policeStation.clear();
        policeStation.sendKeys(data.policeStation);

        selectDropdownByInputName("districtId", data.district);
        Thread.sleep(2000);
        selectDropdownByInputName("blockId", data.block);
        
        pinCode.clear();
        pinCode.sendKeys(data.pin);
        
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");

        selectDropdownByInputName("scstType", data.category);
        Thread.sleep(2000);
        selectDropdownByInputName("caste",data.caste);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickOnSave);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSave)).click();
        logger.info("💾 Clicked on Save button");
    }

//    public void verifyFormSubmission() {
//        wait.until(ExpectedConditions.visibilityOf(successMessage));
//        if (successMessage.isDisplayed()) {
//            logger.pass("✅ Personal details submitted successfully");
//        } else {
//            logger.fail("❌ Submission confirmation message not found");
//            throw new AssertionError("Submission not confirmed.");
//        }
//    }

    public void selectDropdownByInputName(String fieldName, String visibleText) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.name(fieldName)));
        input.click();
        input.sendKeys(visibleText);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//li[contains(text(),'" + visibleText + "')]")));
        option.click();
    }

//    public void selectGuardianType(String value) {
//        try {
//            // Wait until any radio button with name 'guardianType' is present
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("guardianType")));
//
//            String xpath = "//input[@type='radio' and @name='guardianType' and @value='" + value + "']";
//            WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioBtn);
////
////            if (!radioBtn.isSelected()) {
////                radioBtn.click();
////                logger.info("✅ Selected guardian type: " + value);
//           // }
//        } catch (TimeoutException | NoSuchElementException e) {
//            logger.fail("❌ Guardian type radio button not found for value: " + value);
//            throw new NoSuchElementException("Guardian type radio button not found for value: " + value, e);
//        }
//    }

}

