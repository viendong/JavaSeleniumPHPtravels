package selenium.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.phptravel.dto.Account;

public class SignupPage extends BasePage{

    @FindBy (xpath = ".//input[@name='first_name']")
    private WebDriver tbFirstName;

    @FindBy (xpath = ".//input[@name='last_name']")
    private WebDriver tbLastName;

    @FindBy (xpath = "phone")
    private WebDriver tbPhone;

    @FindBy (xpath = "email")
    private WebDriver tbEmail;

    @FindBy (xpath = "password")
    private WebDriver tbPass;

    @FindBy(xpath = "//button[normalize-space(.)='Signup']")
    private WebDriver btnSignup;

    public SignupPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void inputFirstName(String firstname) {

        inputText((By) tbFirstName, firstname);
    }

    public void inputLastName(String lastname) {

        inputText((By) tbLastName, lastname);
    }

    public void inputPhone(String phone) {

        inputText((By) tbPhone, phone);
    }

    public void inputEmail(String email) {

        inputText((By) tbEmail, email);
    }

    public void inputPassword(String password) {
        inputText((By) tbPass, password);
    }

    public void clickSignup() {
        scrollClick((WebElement) btnSignup);
    }

    public WebElement getTbFirstName() {
        return (WebElement) tbFirstName;
    }

    public WebElement getTbLastName() {
        return (WebElement) tbLastName;
    }

    public WebElement getTbPhone() {
        return (WebElement) tbPhone;
    }

    public WebElement getTbEmail() {
        return (WebElement) tbEmail;
    }

    public WebElement getTbPassword() {
        return (WebElement) tbPass;
    }

    public WebElement getBtnSignup() {
        return (WebElement) btnSignup;
    }

    public void selectAccountType(String accountType) {
        By by = By.id("select2-account_type-container");
        scrollClick(webDriver.findElement(by));

        By byAccountType = By.xpath(String.format("//li[.='%s']", accountType));
        scrollClick(webDriver.findElement(byAccountType));
    }

    public void signup(String firstname, String lastname, String phone, String email, String password, String accountType) {
        inputFirstName(firstname);
        inputLastName(lastname);
        inputPhone(phone);
        inputEmail(email);
        inputPassword(password);
        selectAccountType(accountType);

        clickSignup();
    }

    public void signup(Account account) {
        signup(
                account.getFirstName(),
                account.getLastName(),
                account.getPhone(),
                account.getEmail(),
                account.getPassword(),
                account.getAccountType());
    }

    public String getFirstNameRequiredMessage() {
        return webDriverWait
                .until(ExpectedConditions.visibilityOf((WebElement) tbFirstName))
                .getAttribute("validationMessage");
    }

    public String getLastNameRequiredMessage() {
        return webDriverWait
                .until(ExpectedConditions.visibilityOf((WebElement) tbLastName))
                .getAttribute("validationMessage");
    }

    public String getPhoneRequiredMessage() {
        return webDriverWait
                .until(ExpectedConditions.visibilityOf((WebElement) tbPhone))
                .getAttribute("validationMessage");
    }

    public String getRequiredMessage(WebElement el) {
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(el))
                .getAttribute("validationMessage");
    }


}
