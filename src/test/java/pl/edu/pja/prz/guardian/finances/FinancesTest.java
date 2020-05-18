package pl.edu.pja.prz.guardian.finances;

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
        // Finances button in left menu
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

    @Test
    @TestCase("PT_05")
    public void Should_CheckChildBalance() {
        // Finances button in left menu
        driver.clickElementByXPath("/html/body/app-root/app-guardian/div/mat-card/div[1]/div/mat-card/div/div[2]/app-navbar/div/div[3]/div/button");
        // Financial information of child
        driver.clickElementByXPath("//*[@id=\"mat-expansion-panel-header-0\"]/span[2]");
        // Child Balance
        assertElementExists("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[1]/div/div[2]");
        // Child Receivables
        assertElementExists("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[2]/div/div[2]");
        // Child Liabilities
        assertElementExists("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[3]/div/div[2]");
        // Generate data for transfer
        driver.clickElementByXPath("//*[@id=\"cdk-accordion-child-0\"]/div/div[2]/button");
        // Organization name
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[2]/div");
        // City and postal code
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[3]/div");
        // Street
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[4]/div");
        // Account number
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[7]/div");
        // Amount
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[10]/div");
        // Transfer title
        assertElementExists("//*[@id=\"mat-dialog-0\"]/app-payment-data/div[2]/div/div[13]/div");
    }

}
