package pl.edu.pja.prz;

public class TestConfiguration {

    public static final Integer WAIT_TIME_IN_SECONDS_BEFORE_TEST_FAILS = 5;
    public static final String CHROME_DRIVER_RELATIVE_PATH = "\\src\\test\\resources\\selenium\\chromedriver.exe";
    public static final String TESTED_APPLICATION_BASE_URL = "https://localhost:4200/auth/login";

    private TestConfiguration() {

    }
}
