package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "aadhaar")
    WebElement aadhaar;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;
 
    @FindBy(xpath = "//button[normalize-space()='OK']")
      WebElement loginSuccess;
    
    public void enterAadhaarAndPassword() {
        String aadhaarNum = ConfigReader.getAadhaar();    // from registrationData.properties
        String passwordVal = ConfigReader.getPassword();  // from loginData.properties

        aadhaar.sendKeys(aadhaarNum);
        password.clear();
        password.sendKeys(passwordVal);
    }

    public void clickLogin() {
        loginBtn.click();
    }
    
    public void loginSuccess() {
    	loginSuccess.click();
    }
}

    

