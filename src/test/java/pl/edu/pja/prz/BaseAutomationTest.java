package pl.edu.pja.prz;

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
}
