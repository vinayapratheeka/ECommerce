package base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() throws IOException {
        ConfigReader.loadConfig();
        String browser = ConfigReader.getProperty("browser");
        CrossBrowser.initDriver(browser);
        String env = ConfigReader.getProperty("env");
        String url = ConfigReader.getProperty(env + ".url");
        CrossBrowser.getDriver().get(url);
    }
    @AfterMethod
    public void tearDown() {
        CrossBrowser.quitDriver();
    }
}