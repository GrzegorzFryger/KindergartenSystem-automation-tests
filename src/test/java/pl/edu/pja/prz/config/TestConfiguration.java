package pl.edu.pja.prz.config;

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
     * Path where screenshots created during test execution will be placed
     */
    public static final String SCREEN_SHOTS_FOLDER_RELATIVE_PATH = "\\src\\test\\resources\\selenium\\screenshots";

    /**
     * File format in which screen shots will be created
     */
    public static final String JPG_FORMAT = ".jpg";

    /**
     * Login page of tested application. It is the starting point for each test case
     */
    public static final String TESTED_APPLICATION_BASE_URL = "https://localhost:4200/auth/login";

    private TestConfiguration() {

    }
}
