package pl.edu.pja.prz.general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.edu.pja.prz.BaseAutomationTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This test suite checks correctness of general application functions
 */
public class GeneralTest extends BaseAutomationTest {

    @BeforeEach
    public void setUp() {
        initializeDriver();
    }

    @AfterEach
    public void close() {
        driver.close();
    }

    @Test
    public void Should_VisitLoginPage() {
        // Do nothing - initializing web driver starts from login page
    }

    @Test
    public void Should_LogIn_When_UserCredentialsAreCorrect() {
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", "user3@test.com");
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", "user03");
        driver.clickElementByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
    }

    @Test
    public void Should_NotLogIn_When_UserCredentialsAreNotCorrect() {
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", "bad_email");
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", "bad_password");
        driver.clickElementByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
        assertFalse(driver.findElements(By.xpath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span")).isEmpty());
    }
}
