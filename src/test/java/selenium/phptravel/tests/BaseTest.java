package selenium.phptravel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    private final int pageLoadTimeout = 60;
    private final int timeOut = 60;

    @Parameters("browserName")
    @BeforeTest
    public void beforeTest(String browserName) {
        System.out.println("----- Before Test -----");
        webDriver = WebDriverManager.getInstance(browserName).create();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        webDriver.manage().window().maximize();

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOut));
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("----- Before Method -----");
    }

    @AfterTest
    public void afterTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
