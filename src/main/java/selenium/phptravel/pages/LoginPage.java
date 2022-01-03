package selenium.phptravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "email")
    private WebElement tbEmail;

    @FindBy(name = "password")
    private WebElement tbPassword;

    @FindBy(xpath = "//button[normalize-space(.)='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='message']/div[@class='alert alert-danger failed']")
    private WebElement elErrorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputEmail(String email) {
        inputText(tbEmail, email);
    }

    public void inputPassword(String password) {
        inputText(tbPassword, password);
    }

    public void clickLogin() {
        scrollClick(btnLogin);
    }

    public String getErrorMessage() {
        return elErrorMessage.getText();
    }

    public void login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickLogin();
    }

}
