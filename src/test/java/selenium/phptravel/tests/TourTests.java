package selenium.phptravel.tests;

import org.testng.annotations.Test;
import selenium.phptravel.pages.TourPage;
import selenium.phptravel.pages.components.HeaderMenu;

import java.text.ParseException;

public class TourTests extends BaseTest{

    @Test
    public void SearchTours() throws InterruptedException, ParseException {
        webDriver.get("https://www.phptravels.net/login");

        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        TourPage tourPage = headerMenu.openTourPage();

        String tour = "Singapore";
        String date ="04/01/2022";

        tourPage.inputDestination(tour);
        tourPage.selectDate(date);
        tourPage.setTravellers(2,3);
        Thread.sleep(1000);
    }
}
