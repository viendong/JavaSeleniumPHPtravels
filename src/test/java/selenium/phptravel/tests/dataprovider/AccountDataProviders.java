package selenium.phptravel.tests.dataprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.json.JSONArray;
import org.testng.annotations.DataProvider;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import selenium.phptravel.dto.Account;
import java.util.List;

public class AccountDataProviders {
    @DataProvider(name = "JSONValidAccounts")
    public static Object[][] jsonValidAccounts() throws IOException {
        File fileValidAccounts = new File("src/test/java/resources/data/login/valid_accounts.json");
        ObjectMapper mapper = new ObjectMapper();

        List<Account> accountList = mapper.readValue(fileValidAccounts, new TypeReference<List<Account>>() {});
        Object[][] validAccounts = new Object[accountList.size()][];
        for (int i = 0; i < accountList.size(); i++) {
            Object[] account = new Object[]{accountList.get(i)};
            validAccounts[i] = account;
        }
        return validAccounts;
    }
//
    @DataProvider(name = "JSONInvalidAccounts")
    public static Object[][] jsonInvalidAccounts() throws IOException {
        File fileValidAccounts = new File("src/test/java/resources/data/login/invalid_accounts.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Account> accountList = mapper.readValue(fileValidAccounts, new TypeReference<List<Account>>() {});
        Object[][] validAccounts = new Object[accountList.size()][];
        for (int i = 0; i < accountList.size(); i++) {
            Object[] account = new Object[]{accountList.get(i)};
            validAccounts[i] = account;
        }
        return validAccounts;
    }

//
//    @DataProvider(name = "accounts")
//    public Object[][] accounts() throws IOException {
//        File fileValidAccounts = new File("src/test/resources/data/login_success/valid_accounts.json");
//        JSONArray jsonArrayValidAccounts = new JSONArray(Files.readFile(fileValidAccounts));
//        Object[][] validAccounts = new Object[jsonArrayValidAccounts.length()][];
//        for (int i = 0; i < jsonArrayValidAccounts.length(); i++) {
//            Object[] account = new Object[]{jsonArrayValidAccounts.getJSONObject(i)};
//            validAccounts[i] = account;
//        }
//        return validAccounts;
//    }
}
