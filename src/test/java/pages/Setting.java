package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentReportManager;

public class Setting {

    WebDriver driver;
    ExtentTest logger = ExtentReportManager.getTest();

    public Setting(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Web Elements ---
    @FindBy(xpath = "//h6[contains(text(),'सेटिंग्स')]")
    WebElement settingModule;

    @FindBy(name = "password")
    WebElement oldPassword;

    @FindBy(name = "newPassword")
    WebElement newPassword;

    @FindBy(name = "reEnteredPassword")
    WebElement confirmPwd;

    @FindBy(xpath = "//button[@label='पासवर्ड बदलें']")  // Corrected locator
    WebElement changePasswordBtn;

    @FindBy(xpath = "//div[contains(text(),'Password changed successfully') or contains(text(),'सफलतापूर्वक')]")
    WebElement successMsg;

    // --- Step 1: Navigate to Setting Page ---
    public void goToSettingPage() {
        settingModule.click();
        logger.info("⚙️ Navigated to Settings module.");
    }

    // --- Step 2: Fill password fields ---
    public void enterPasswords(String oldPwd, String newPwd, String confPwd) {
        oldPassword.sendKeys(oldPwd);
        newPassword.sendKeys(newPwd);
        confirmPwd.sendKeys(confPwd);
        logger.info("🔑 Entered old, new, and confirm password.");
    }

    // --- Step 3: Click on Change Password button ---
    public void clickChangePassword() {
        changePasswordBtn.click();
        logger.info("✅ Clicked on Change Password button.");
    }

//    // --- Step 4: Verify password changed ---
//    public void verifyPasswordChange() {
//        if (successMsg.isDisplayed()) {
//            logger.pass("🔐 Password changed successfully.");
//        } else {
//            logger.fail("❌ Failed to change password.");
//            throw new AssertionError("Password change failed.");
//        }
//    }
}
