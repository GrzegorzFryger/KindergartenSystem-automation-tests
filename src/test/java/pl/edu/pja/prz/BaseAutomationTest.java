package pl.edu.pja.prz;

import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Each test class should extend this class.
 * This class contains core methods, that are necessary for testing KindergartenSystem application.
 */
public abstract class BaseAutomationTest {
    protected DriverWrapper driver;

    public BaseAutomationTest() {
        String userDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userDirectory + TestConfiguration.CHROME_DRIVER_RELATIVE_PATH);
    }

    public void initializeDriver() {
        driver = new DriverWrapper();
        driver.get(TestConfiguration.TESTED_APPLICATION_BASE_URL);
    }

    public void login() {
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", "user3@test.com");
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", "user03");
        driver.clickElementByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
    }

    public void assertElementExists(String xPath) {
        assertFalse(driver.findElements(By.xpath(xPath)).isEmpty());
    }

    public void assertElementDoesNotExists(String xPath) {
        assertTrue(driver.findElements(By.xpath(xPath)).isEmpty());
    }
}
