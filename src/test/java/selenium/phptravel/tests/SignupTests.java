package selenium.phptravel.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.phptravel.dto.Account;
import selenium.phptravel.pages.LoginPage;
import selenium.phptravel.pages.SignupPage;
import selenium.phptravel.pages.components.HeaderTopBar;
import selenium.phptravel.tests.dataprovider.AccountDataProviders;

public class SignupTests extends BaseTest{


    @Test(dataProvider = "JSONInvalidAccounts", dataProviderClass = AccountDataProviders.class)
    public void signUpFail(Account account) throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");
        String message = "Please fill out this field.";

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        SignupPage signupPage = headerTopBar.openSignupPage();
        signupPage.signup(account);

        if (account.getFirstName().equals("")) {
            Assert.assertEquals(signupPage.getRequiredMessage(signupPage.getTbFirstName()), message);
        } else if (account.getLastName().equals("")) {
            Assert.assertEquals(signupPage.getRequiredMessage(signupPage.getTbLastName()), message);
        } else if (account.getPhone().equals("")) {
            Assert.assertEquals(signupPage.getRequiredMessage(signupPage.getTbPhone()), message);
        }
    }

    @Test(dataProvider = "JSONValidAccounts", dataProviderClass = AccountDataProviders.class)
    public void signUpSuccess(Account account) throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        SignupPage signupPage = headerTopBar.openSignupPage();
        signupPage.signup(account);
        Thread.sleep(5000);

        Assert.assertEquals(signupPage.getTitle(),"Login");
    }

    @Test
    public void SignUp1Account() throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();
        SignupPage signupPage = headerTopBar.openSignupPage();

        String firstname="Vo";
        String lastname="Dong";
        String phone="0123456789";
        String email="viendong.agent@gmail.com";
        String password="Test@123";
        String accountType="Agent";

        signupPage.signup(firstname,lastname,phone,email, password, accountType);
        Assert.assertEquals(signupPage.getTitle(),"Login");
    }
}
