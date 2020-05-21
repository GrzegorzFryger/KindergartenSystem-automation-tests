package pl.edu.pja.prz;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.edu.pja.prz.config.TestConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static pl.edu.pja.prz.config.ChromeOptions.START_MAXIMIZED;
import static pl.edu.pja.prz.config.Constants.USER_DIRECTORY;
import static pl.edu.pja.prz.config.TestConfiguration.*;

/**
 * pl.edu.pja.prz.DriverWrapper - delegates already existing WebDriver methods and adds custom methods.
 * The intent of this wrapper is to add customized behaviour to default driver in order to enable easier usage of it.
 */
public class DriverWrapper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DriverWrapper() {
        driver = new ChromeDriver(getChromeOptions());
        wait = new WebDriverWait(driver, WAIT_TIME_IN_SECONDS_BEFORE_TEST_FAILS);
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments(START_MAXIMIZED);
        return co;
    }

    public void makeScreenShot(String name) throws IOException {
        String resourcesDirectory = System.getProperty(USER_DIRECTORY) + SCREEN_SHOTS_FOLDER_RELATIVE_PATH;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(resourcesDirectory + name + JPG_FORMAT));
    }

    public void clickByXPath(String xPath) {
        findElement(By.xpath(xPath)).click();
    }

    public void clickById(String id) {
        findElement(By.id(id)).click();
    }

    public void sendKeysByXPath(String xPath, String keys) {
        findElement(By.xpath(xPath)).sendKeys(keys);
    }

    public void sendKeysById(String id, String keys) {
        findElement(By.id(id)).sendKeys(keys);
    }

    public void get(String s) {
        driver.get(s);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Customized method for finding elements.<br>
     * It waits {@value TestConfiguration#WAIT_TIME_IN_SECONDS_BEFORE_TEST_FAILS} seconds before failing, so that
     * view can load without any issues.
     */
    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    /**
     * Customized method for finding element.<br>
     * It waits {@value TestConfiguration#WAIT_TIME_IN_SECONDS_BEFORE_TEST_FAILS} seconds before failing, so that
     * view can load without any issues.
     */
    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public String getText(String xPath) {
        return findElement(By.xpath(xPath)).getText();
    }
}
