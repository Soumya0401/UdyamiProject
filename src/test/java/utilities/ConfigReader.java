package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties configData = new Properties();
    private static Properties registrationData = new Properties();
    private static Properties loginData = new Properties();
  
    static {
        try {
            // General application config (URLs, environment, etc.)
            FileInputStream configFis = new FileInputStream("src/test/resources/testdata/config.properties");
            configData.load(configFis);

            // Registration data (like Aadhaar, names)
            FileInputStream regFis = new FileInputStream("src/test/resources/testdata/registrationData.properties");
            registrationData.load(regFis);

            // Login data (password etc.)
            FileInputStream loginFis = new FileInputStream("src/test/resources/testdata/loginData.properties");
            loginData.load(loginFis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Read URL or other global config values from config.properties
    public static String getConfigValue(String key) {
        return configData.getProperty(key);
    }

    // ✅ Aadhaar from registrationData.properties
    public static String getAadhaar() {
        return registrationData.getProperty("aadhaar");
    }

    // ✅ Password from loginData.properties
    public static String getPassword() {
        return loginData.getProperty("password");
    }
}
