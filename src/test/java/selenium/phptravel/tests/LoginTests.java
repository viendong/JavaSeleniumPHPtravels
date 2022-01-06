package selenium.phptravel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.phptravel.dto.Account;
import selenium.phptravel.pages.LoginPage;
import selenium.phptravel.pages.SignupPage;
import selenium.phptravel.pages.components.HeaderTopBar;
import selenium.phptravel.tests.dataprovider.AccountDataProviders;

public class LoginTests extends BaseTest{

    @Test
    public void loginTestSuccess() throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();

        String email = "viendong@gmail.com";
        String password = "Test@123";

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);

        Thread.sleep(1000);

        Assert.assertEquals(loginPage.getDashbroad()," Dashboard");

    }

    @Test(dataProvider = "JSONValidAccounts", dataProviderClass = AccountDataProviders.class)
    public void loginSuccessTest(Account account) {
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(account.getEmail(), account.getPassword());

        Assert.assertEquals(loginPage.getDashbroad()," Dashboard");
    }


    @Test (dataProvider = "InvalidAccounts")
    public void loginFailTests(String email, String password) throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);

        Thread.sleep(1000);

        Assert.assertEquals(loginPage.getErrorMessage(), "Wrong credentials. try again!");
    }


    @DataProvider(name = "InvalidAccounts")
    public Object[][] invalidAccount() {
        return new Object[][]
                {
                        {"a.viendong@gmail.com", "123456"},
                        {"", "123456"},
                        {"viendong@gmail.com",""},
                };
    }
}
