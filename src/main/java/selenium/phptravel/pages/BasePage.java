package selenium.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor jsExecutor;

    private int waitTimeout = 60;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(waitTimeout));
        jsExecutor = (JavascriptExecutor) webDriver;

        PageFactory.initElements(webDriver, this);
    }

    protected void scrollClick(WebElement el) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", el);
//        jsExecutor.executeScript("window.scrollBy(0,250)");
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(el))
                .click();
    }



    protected void click(WebElement el) {
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(el))
                .click();
    }

    protected void click(By by) {
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    public void inputText(WebElement el, String text) {
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(el));
        el.clear();
        el.sendKeys(text);
    }

    public void inputText(By by, String text) {
        WebElement el = webDriverWait
                .until(ExpectedConditions.elementToBeClickable(by));
        el.clear();
        el.sendKeys(text);
    }

    protected void setText(WebElement el, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(el));
        jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1]);", el, text);
    }


}
