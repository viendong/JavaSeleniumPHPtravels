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

    @Test
    public void AccessWeb() throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");
        Thread.sleep(1000);
    }


    @Test(dataProvider = "JSONInvalidAccounts", dataProviderClass = AccountDataProviders.class)
    public void signUpFail(Account account) {
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

    @Test (dataProvider = "Valid_Accounts")
    public void SignUpSeccess(String firstname, String lastname, String phone, String email, String password, String accountType) throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        Thread.sleep(1000);
        SignupPage signupPage = new SignupPage(webDriver);
        signupPage.signup(firstname, lastname, phone, email, password, accountType);

        Thread.sleep(1000);
    }

    @DataProvider(name = "Valid_Accounts")
    public Object[][] invalidAccount() {
        return new Object[][]
                {
                        {"Vo","Dong", "0123456789","viendong.agent@gmail.com","Test@123","Agent"},
                        {"Vo","Dong", "0123456789","viendong.supplier@gmail.com","Test@123","Supplier"},
                        {"Vo","Dong", "0123456789","viendong.customer@gmail.com","Test@123","Customer"}
                };
    }

}
