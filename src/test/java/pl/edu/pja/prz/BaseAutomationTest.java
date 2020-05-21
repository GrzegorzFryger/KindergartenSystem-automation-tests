package pl.edu.pja.prz;

import org.openqa.selenium.By;
import pl.edu.pja.prz.config.TestConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.edu.pja.prz.config.Constants.CHROME_WEB_DRIVER;
import static pl.edu.pja.prz.config.Constants.USER_DIRECTORY;
import static pl.edu.pja.prz.config.TestConfiguration.CHROME_DRIVER_RELATIVE_PATH;

/**
 * Each test class should extend this class.
 * This class contains core methods, that are necessary for testing KindergartenSystem application.
 */
public abstract class BaseAutomationTest {
    protected DriverWrapper driver;

    public BaseAutomationTest() {
        String userDirectory = System.getProperty(USER_DIRECTORY);
        System.setProperty(CHROME_WEB_DRIVER, userDirectory + CHROME_DRIVER_RELATIVE_PATH);
    }

    public void initializeDriver() {
        driver = new DriverWrapper();
        driver.get(TestConfiguration.TESTED_APPLICATION_BASE_URL);
    }

    public void loginAsAdministrator() {
        login("user3@test.com", "user03");
    }

    public void loginAsTeacher() {
        login("user2@test.com", "user02");
    }

    public void loginAsUser() {
        login("user1@test.com", "user01");
    }

    public void assertElementExists(String xPath) {
        assertFalse(driver.findElements(By.xpath(xPath)).isEmpty());
    }

    public void assertElementDoesNotExists(String xPath) {
        assertTrue(driver.findElements(By.xpath(xPath)).isEmpty());
    }

    protected void login(String username, String password) {
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", username);
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", password);
        driver.clickElementByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
    }
}
