# KindergartenSystem-automation-tests
This repository contains all automated tests for *KindergartenSystem* application.

## Getting started
In order to run this application, you need to download and put chromedriver.exe 
into `src/test/resources/selenium` directory.  
You can find this driver here: [Downloads](https://chromedriver.chromium.org/downloads)  
Make sure that you use proper version, which is matching your current browser version.  
Current stable version: `ChromeDriver 81.0.4044.138`


We can't put this binary into repository unless we will be in compliance with this licene:
[LICENSE](https://github.com/geonetwork/chromedriver/blob/master/LICENSE)

## Running tests
To run all tests using `IntelliJ IDEA` rightclick on `test/java` directory and click `Run 'All Tests'` option.

## Development - Important rules
1 - Each new test class must extend `BaseAutomationTest`  

2 - Always put this code into your test class:
```
    @AfterEach
    public void quit() {
        driver.quit();
    }
```

Without this code each time you run test you will run new separate process for chromedriver and
eventually you may run out of system resources.  

3 - Always put this code into your test class:
```
    @BeforeEach
    public void setUp() {
        initializeDriver();
    }
```
This code will initialize web driver for further operations

4 - Always mark your test using `@TestCase()` annotation  
This needs to be done from documentation perspective in order to mark unit tests with proper test cases
from documentation.  

Example usage:
```
@TestCase("PT_04")
```