package pl.edu.pja.prz.general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pja.prz.BaseAutomationTest;

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
}
