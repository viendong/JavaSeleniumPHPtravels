package selenium.phptravel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.phptravel.pages.LoginPage;
import selenium.phptravel.pages.components.HeaderTopBar;

public class LoginTests extends BaseTest{

    @Test
    public void loginTestSuccess() throws InterruptedException {
        String email = "viendong@gmail.com";
        String password = "Test@123";
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);
        Thread.sleep(10000);

        Assert.assertEquals(loginPage.getDashbroad()," Dashboard");
        Thread.sleep(1000);
    }

    @Test (dataProvider = "InvalidAccounts")
    public void loginFailTests(String email, String password) {
        webDriver.get("https://www.phptravels.net/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);

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
