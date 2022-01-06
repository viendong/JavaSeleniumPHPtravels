package selenium.phptravel.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.phptravel.pages.BasePage;
import selenium.phptravel.pages.LoginPage;
import selenium.phptravel.pages.SignupPage;

public class HeaderTopBar extends BasePage {

    @FindBy(linkText = "Signup")
    private WebElement lkSignup;

    @FindBy(id = "cookie_stop")
    private WebElement btnGotIt;

//    @FindBy(linkText = "Login")
//    private WebElement lkLogin;


    public HeaderTopBar(WebDriver webDriver) {
        super(webDriver);
    }

    public SignupPage openSignupPage() {
        scrollClick(lkSignup);
        return new SignupPage(webDriver);
    }

//    public LoginPage openLoginPage() {
//        scrollClick(lkLogin);
//        return new LoginPage(webDriver);
//    }

    public void cookieGotIt() {
        scrollClick(btnGotIt);
    }

}
