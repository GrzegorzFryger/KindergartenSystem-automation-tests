package pl.edu.pja.prz.guardian.child;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pja.prz.BaseAutomationTest;
import pl.edu.pja.prz.TestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChildTest extends BaseAutomationTest {
    public static final int PESEL_LENGTH = 11;
    public static final int DATE_LENGTH = 10;
    public static final String BOY = "Chłopiec";
    public static final String GIRL = "Dziewczynka";

    @BeforeEach
    public void setUp() {
        initializeDriver();
        loginAsAdministrator();
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    @Test
    @TestCase("PT_42")
    public void Should_CheckChildData() {
        // Child button
        driver.clickByXPath("/html/body/app-root/app-guardian/div/mat-card/div[1]/div/mat-card/div/div[2]/app-navbar/div/div[2]/div/button");
        // Child PESEL
        String pesel = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]");
        assertEquals(PESEL_LENGTH, pesel.length());
        // Child birth date
        String birthDate = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[2]/div/div[3]/div/div[2]");
        assertEquals(DATE_LENGTH, birthDate.length());
        // Child gender
        String gender = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[2]/div/div[2]/div/div[2]");
        assertTrue(gender.equals(BOY) || gender.equals(GIRL));
        // Child start date
        String startDate = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[2]/div/div[4]/div/div[2]");
        assertEquals(DATE_LENGTH, startDate.length());
        // Child end date
        String endDate = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[2]/div/div[5]/div/div[2]");
        assertEquals(DATE_LENGTH, endDate.length());
        // Child street
        String street = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[3]/div/div[1]/div/div[2]");
        assertTrue(street.length() > 0);
        // Child postal code
        String postalCode = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[3]/div/div[2]/div/div[2]");
        assertTrue(postalCode.length() > 0);
        // Child city
        String city = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-children-details/div/div[1]/div/div/div[3]/div/div[3]/div/div[2]");
        assertTrue(city.length() > 0);
    }
}
