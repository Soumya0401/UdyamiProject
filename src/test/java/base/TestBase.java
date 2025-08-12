package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;

    public static void initialization(String urlKey) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();

            // Fetch URL from config.properties using the key (e.g., "login_url", "registration_url")
            String url = ConfigReader.getConfigValue(urlKey);
            System.out.println("Navigating to: " + url);
            driver.get(url);
        }
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; //  Nullify after quitting
        }
    }
}

