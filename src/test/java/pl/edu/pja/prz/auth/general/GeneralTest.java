package pl.edu.pja.prz.auth.general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pja.prz.BaseAutomationTest;
import pl.edu.pja.prz.TestCase;

/**
 * This test suite checks correctness of general application functions
 */
public class GeneralTest extends BaseAutomationTest {

    @BeforeEach
    public void setUp() {
        initializeDriver();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void Should_VisitLoginPage() {
        // Do nothing - initializing web driver starts from login page
    }

    @Test
    @TestCase("PT_01")
    public void Should_LogIn_When_UserCredentialsAreCorrect() {
        // Email text input
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", "user3@test.com");
        // Password text input
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", "user03");
        // Sign in button
        driver.clickByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
        // Menu panel with logged user name in top right corner
        assertElementExists("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[1]/div/div/app-user/div/mat-card");
        // Icon with user image
        driver.clickByXPath("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[1]/div/div/app-user/div/mat-card/div/div[2]/img");
        // Log out button
        driver.clickByXPath("//*[@id=\"mat-menu-panel-0\"]/div/button[2]");
        // Login button
        assertElementExists("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
    }

    @Test
    @TestCase("PT_02")
    public void Should_NotLogIn_When_UserCredentialsAreNotCorrect() {
        // Email text input
        driver.sendKeysByXPath("//*[@id=\"mat-input-0\"]", "bad_email");
        // Password text input
        driver.sendKeysByXPath("//*[@id=\"mat-input-1\"]", "bad_password");
        // Sign in button
        driver.clickByXPath("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
        // Login button
        assertElementExists("/html/body/app-root/app-login/div/div/mat-card/mat-card-content/div/div[2]/form/div/button/span");
    }
}
