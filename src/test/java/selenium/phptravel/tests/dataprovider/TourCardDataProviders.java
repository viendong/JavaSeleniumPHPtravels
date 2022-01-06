package selenium.phptravel.tests.dataprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.reporters.Files;
import selenium.phptravel.dto.FilterResult;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.dto.TourSearchFilter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TourCardDataProviders {

    @DataProvider(name = "FilterResult")
    public static Object[][] filterResult() throws IOException {
        File fileSearchDataDriven = new File("src/test/java/resources/data/search_tour.json");
        ObjectMapper mapper = new ObjectMapper();

        List<FilterResult> filterResults = mapper.readValue(fileSearchDataDriven, new TypeReference<List<FilterResult>>() {});
        Object[][] array = new Object[filterResults.size()][];
        for (int i = 0; i < filterResults.size(); i++) {
            Object[] fr = new Object[] {filterResults.get(i)};
            array[i] = fr;
        }
        return array;
    }

}
