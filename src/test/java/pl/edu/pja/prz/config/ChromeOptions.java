package pl.edu.pja.prz.config;

/**
 * Source of all available properties:
 * @see <a href="https://chromium.googlesource.com/chromium/src/+/master/chrome/common/chrome_switches.cc">Chrome Switches</a>
 */
public class ChromeOptions {

    /**
     * Starts the browser maximized, regardless of any previous settings.
     */
    public static final String START_MAXIMIZED = "--start-maximized";

    private ChromeOptions() {

    }
}
