package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import com.aventstack.extentreports.ExtentTest;
import utilities.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class UserRegistrationPage {
    WebDriver driver;
    ExtentTest logger = ExtentReportManager.getTest();
    ConfigReader config;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        config = new ConfigReader();
    }

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "mobile")
    WebElement mobile;

    @FindBy(name = "aadhaar")
    WebElement aadhaar;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getOtpBtn;

    public void fillRegistrationForm() throws InterruptedException {
        userData data = DataGenerator.generateUserData();
        saveRegistrationData(data);

        logger.info("📝 Filling registration form with test data.");
        firstName.sendKeys(data.firstName);
        middleName.sendKeys(data.middleName);
        lastName.sendKeys(data.lastName);
        email.sendKeys(data.email);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
        Thread.sleep(1000);

        selectDropdown("isCompanyFormed", data.businessStatus);
        selectDropdown("gender", data.gender);

        mobile.sendKeys(data.mobile);
        aadhaar.sendKeys(data.aadhaar);

        selectDropdown("schemeType", data.schemeType);
    }

    public void selectDropdown(String fieldName, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.name(fieldName)));
        input.click();
        input.sendKeys(visibleText);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + visibleText + "')]")));
        option.click();
    }

    public void clickGetOtp() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getOtpBtn);
        getOtpBtn.click();
        Thread.sleep(1000);
    }

    public void clickOnOk() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='ok' or normalize-space()='OK']")));
        okBtn.click();
        Thread.sleep(1000);   }

    public void clickOnSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        okBtn.click();
    }

    public void enterOTP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp-input-0"))).sendKeys("1");
        driver.findElement(By.id("otp-input-1")).sendKeys("2");
        driver.findElement(By.id("otp-input-2")).sendKeys("3");
        driver.findElement(By.id("otp-input-3")).sendKeys("4");
    }

    public void verifyotp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=':rg:']")));
        submitBtn.click();
    }

    public void success() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickOk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        clickOk.click();
    }

    // ✅ Fixed method to save user registration data
    public void saveRegistrationData(userData data) {
        try (FileOutputStream fos = new FileOutputStream("src/test/resources/testdata/registrationData.properties")) {
            Properties props = new Properties();
            props.setProperty("firstName", data.firstName);
            props.setProperty("middleName", data.middleName);
            props.setProperty("lastName", data.lastName);
            props.setProperty("email", data.email);
            props.setProperty("mobile", data.mobile);
            props.setProperty("gender", data.gender);
            props.setProperty("businessStatus", data.businessStatus);
            props.setProperty("schemeType", data.schemeType);
            props.setProperty("aadhaar", data.aadhaar);
            props.store(fos, "User Registration Data");
            logger.info("✅ Registration data saved to properties file.");
        } catch (IOException e) {
            logger.fail("❌ Failed to save registration data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
