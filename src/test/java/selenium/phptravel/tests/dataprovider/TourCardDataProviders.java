package selenium.phptravel.tests.dataprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.reporters.Files;
import selenium.phptravel.dto.Account;
import selenium.phptravel.dto.FilterResult;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.dto.TourSearchFilter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TourCardDataProviders {

    @DataProvider(name = "CardTourTestDataProvider")
    public static Object[][] cardTourTestDataProvider() throws IOException {
        File fileSearchDataDriven = new File("src/test/java/resources/data/end2end.json");
        ObjectMapper mapper = new ObjectMapper();

        JSONArray testData = new JSONArray(Files.readFile(fileSearchDataDriven));
        Object [][] array = new Object[testData.length()][];

        for (int i = 0; i < testData.length(); i++) {

            JSONObject data = (JSONObject) testData.get(i);

            Account account = mapper.readValue(data.getJSONObject("account").toString(), Account.class);
            TourSearchFilter filter = mapper.readValue(data.getJSONObject("filters").toString(), TourSearchFilter.class);
            List<TourCard> tourCards = mapper.readValue(data.getJSONArray("results").toString(), new TypeReference<List<TourCard>>() {});

            Object [] tc = new Object[]{account, filter, tourCards};
            array[i] = tc;
        }

        return array;
    }

}
