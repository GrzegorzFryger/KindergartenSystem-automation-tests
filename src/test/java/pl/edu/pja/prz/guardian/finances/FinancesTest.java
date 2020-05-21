package pl.edu.pja.prz.guardian.finances;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pja.prz.BaseAutomationTest;
import pl.edu.pja.prz.TestCase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinancesTest extends BaseAutomationTest {

    @BeforeEach
    public void setUp() {
        initializeDriver();
        loginAsAdministrator();
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
        String balance = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[1]/div/div[2]");
        assertTrue(balance.contains("PLN"));
        // Receivables amount
        String receivables = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[2]/div/div[2]");
        assertTrue(receivables.contains("PLN"));
        // Liabilities amount
        String liabilities = driver.getText("/html/body/app-root/app-guardian/div/mat-card/div[2]/div/mat-card/div/div[2]/app-finances/div/div[1]/div/div[1]/div/mat-card[3]/div/div[2]");
        assertTrue(liabilities.contains("PLN"));
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
        String childBalance = driver.getText("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[1]/div/div[2]");
        assertTrue(childBalance.contains("PLN"));
        // Child Receivables
        String childReceivables = driver.getText("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[2]/div/div[2]");
        assertTrue(childReceivables.contains("PLN"));
        // Child Liabilities
        String childLiabilities = driver.getText("//*[@id=\"cdk-accordion-child-0\"]/div/div[1]/div[3]/div/div[2]");
        assertTrue(childLiabilities.contains("PLN"));
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
