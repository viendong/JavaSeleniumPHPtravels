package selenium.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.phptravel.dto.Account;

public class SignupPage extends BasePage{

    @FindBy (xpath = ".//input[@name='first_name']")
    private WebElement tbFirstName;

    @FindBy (xpath = ".//input[@name='last_name']")
    private WebElement tbLastName;

    @FindBy (xpath = ".//input[@name='phone']")
    private WebElement tbPhone;

    @FindBy (xpath = ".//input[@name='email']")
    private WebElement tbEmail;

    @FindBy (xpath = ".//input[@name='password']")
    private WebElement tbPass;

    @FindBy(xpath = "//button[normalize-space(.)='Signup']")
    private WebElement btnSignup;

    @FindBy(xpath = ".//h5[@class='modal-title title']")
    private WebElement elTitle;

    public SignupPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void inputFirstName(String firstname) {
        inputText(tbFirstName,firstname);
    }

    public void inputLastName(String lastname) {

        inputText( tbLastName, lastname);
    }

    public void inputPhone(String phone) {

        inputText(tbPhone, phone);
    }

    public void inputEmail(String email) {

        inputText(tbEmail, email);
    }

    public void inputPassword(String password) {
        inputText(tbPass, password);
    }

    public void clickSignup() {
        scrollClick( btnSignup);
    }

    public WebElement getTbFirstName() {
        return tbFirstName;
    }

    public WebElement getTbLastName() {
        return tbLastName;
    }

    public WebElement getTbPhone() {
        return tbPhone;
    }

    public WebElement getTbEmail() {
        return tbEmail;
    }

    public WebElement getTbPassword() {
        return  tbPass;
    }

    public WebElement getBtnSignup() {
        return  btnSignup;
    }


    public void selectAccountType(String accountType) {
        By by = By.id("select2-account_type-container");
        scrollClick(webDriver.findElement(by));

        By byAccountType = By.xpath(String.format("//li[.='%s']", accountType));
        scrollClick(webDriver.findElement(byAccountType));
    }

    public void signup(String firstname, String lastname, String phone, String email, String password, String accountType) throws InterruptedException {
        inputFirstName(firstname);
        inputLastName(lastname);
        inputPhone(phone);
        scrollPixel();
        inputEmail(email);
        inputPassword(password);
        selectAccountType(accountType);

        clickSignup();
        Thread.sleep(5000);
    }

    public void signup(Account account) throws InterruptedException {
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

    public String getTitle(){
        return elTitle.getText();
    }

}
