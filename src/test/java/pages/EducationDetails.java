package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import utilities.DataGenerator;
import utilities.ExtentReportManager;
import utilities.userData;

public class EducationDetails {

    WebDriver driver;
    ExtentTest logger = ExtentReportManager.getTest();

    public EducationDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement loginSuccess;
    
    // --- Web Elements ---
    @FindBy(xpath = "//h6[contains(text(),'शिक्षा')]")
    WebElement educationModule;

    @FindBy(xpath = "//p[contains(text(),'शैक्षणिक विवरण जोड़ें')]")
    WebElement addEducationDetails;

    @FindBy(name = "grade")
    WebElement className;

    @FindBy(name = "board")
    WebElement boardName;

    @FindBy(name = "rollNumber")
    WebElement boardrollNumber;

    @FindBy(name = "yearOfPassing")
    WebElement passingYear;
    
    @FindBy(name = "subject")
    WebElement subjectName;
    
    @FindBy(xpath = "//button[@label='जोड़ें']")
    WebElement clickonAdd;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement success;

    // --- Step 1: Navigate to the Education Module ---
    public void goToEducationForm() {
        educationModule.click();
        logger.info("📘 Navigated to Education Module");
        addEducationDetails.click();
        logger.info("➕ Clicked on 'Add Education Details'");
    }

    // --- Step 2: Fill in the Education Details Form ---
    public void fillEducationForm() {
        userData data = DataGenerator.generateUserData();

        className.sendKeys(data.className);
        boardName.sendKeys(data.boardName);
        boardrollNumber.sendKeys(data.boardrollNumber); 
        passingYear.sendKeys(data.passingYear);
        subjectName.sendKeys(data.subjectName);

        logger.info("📝 Education details form filled with valid data.");
    }

    // --- Step 3: Click Add Button ---
    public void clickAddButton() {
        clickonAdd.click();
        logger.info("✅ Clicked on Add button");
    }
    
 // --- Step 3: Click on OK Button  ---
    public void clickokforSuccess() {
    	success.click();
        logger.info("✅ Clicked on Add button");
    }

//    // --- Step 4: Verify the Education Details are Saved ---
//    public void verifyEducationDetailsSaved() {
//        if (successMessage.isDisplayed()) {
//            logger.pass("🎓 Education details saved successfully.");
//        } else {
//            logger.fail("❌ Failed to save education details.");
//            throw new AssertionError("Education details not saved.");
//        }
    }
