import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.security.auth.login.LoginContext;
import java.time.Duration;

public class TestNG {

    @Test
    @Parameters("browserName")
    public void Login(String browserName) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.getInstance(browserName).create();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;

        Thread.sleep(1000);
    }
}
