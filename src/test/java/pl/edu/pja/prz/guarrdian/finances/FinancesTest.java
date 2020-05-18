package pl.edu.pja.prz.guarrdian.finances;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pja.prz.BaseAutomationTest;
import pl.edu.pja.prz.TestCase;

public class FinancesTest extends BaseAutomationTest {

    @BeforeEach
    public void setUp() {
        initializeDriver();
        login();
    }

    @AfterEach
    public void close() {
        driver.close();
    }

    @Test
    @TestCase("PT_04")
    public void Should_VisitFinancesPanel() {
        driver.clickElementByXPath("/html/body/app-root/app-guardian/div/mat-card/div[1]/div/mat-card/div/div[2]/app-navbar/div/div[3]/div/button");

        // Balance amount
        assertElementExists("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[1]/div/div[2]");
        // Receivables amount
        assertElementExists("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[2]/div/div[2]");
        // Liabilities amount
        assertElementExists("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[3]/div/div[2]");
        // Table with receivables
        assertElementExists("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[3]/app-receiables/mat-card");
    }

}
