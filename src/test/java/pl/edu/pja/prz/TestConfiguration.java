package pl.edu.pja.prz;

public class TestConfiguration {

    /**
     * How many seconds test will wait for element to load before failing
     */
    public static final Integer WAIT_TIME_IN_SECONDS_BEFORE_TEST_FAILS = 10;

    /**
     * Realative path to Google Web Chrome Driver
     */
    public static final String CHROME_DRIVER_RELATIVE_PATH = "\\src\\test\\resources\\selenium\\chromedriver.exe";

    /**
     * Login page of tested application. It is the starting point for each test case
     */
    public static final String TESTED_APPLICATION_BASE_URL = "https://localhost:4200/auth/login";

    private TestConfiguration() {

    }
}
