package selenium.phptravel.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.pages.SearchTourPage;
import selenium.phptravel.pages.TourPage;
import selenium.phptravel.pages.components.HeaderMenu;
import selenium.phptravel.pages.components.HeaderTopBar;

import java.text.ParseException;
import java.util.List;

public class TourTests extends BaseTest{

    @Test
    public void AccessTour(){
        webDriver.get("https://www.phptravels.net/login");

        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        headerMenu.openTourPage();
    }
    @Test
    public void SearchTours() throws InterruptedException, ParseException {
        webDriver.get("https://www.phptravels.net/login");

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();

        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        TourPage tourPage = headerMenu.openTourPage();

        Thread.sleep(1000);

        String destination = "Amersfoort";
        String date ="09/01/2022";

        tourPage.inputDestination(destination);
        tourPage.selectDate(date);
        tourPage.setTravellers(2,1);
        tourPage.clickSearch();
        Thread.sleep(1000);
    }

    @Test
    public void scrollFilter() throws InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        Thread.sleep(5000);

        HeaderTopBar headerTopBar = new HeaderTopBar(webDriver);
        headerTopBar.cookieGotIt();

        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        TourPage tourPage = headerMenu.openTourPage();

        tourPage.scrollPixel();
        Thread.sleep(5000);
    }

    @Test
    public void searchTourTest() throws ParseException, JsonProcessingException, InterruptedException {
        webDriver.get("https://www.phptravels.net/login");

        String destination = "Amersfoort";
        String date ="09/01/2022";
        int adults = 2;
        int child = 1;


        String expectedResult = "[" +
                "{\"name\":\"Private Day Trip to Amersfoort from Amsterdam with a local\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":137},\n" +
                "{\"name\":\"WhatsApp Murder trip Amersfoort\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":74},\n" +
                "{\"name\":\"Walk and Explore Amersfoort with the interactive Qula City Trail\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":37},\n" +
                "{\"name\":\"Private Day Trip to Amersfoort from Rotterdam with a local\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":162},\n" +
                "{\"name\":\"Private 1 23 persons Taxi or Bus Transfer Amsterdam Airport to Amersfoort\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":231},\n" +
                "{\"name\":\"Anne Frank in Westerbork\",\"location\":\"Amersfoort\",\"stars\":5,\"ratings\":5,\"currency\":\"USD\",\"price\":340},\n" +
                "{\"name\":\"Anne Frank in Holland\",\"location\":\"Amersfoort\",\"stars\":5,\"ratings\":5,\"currency\":\"USD\",\"price\":518},\n" +
                "{\"name\":\"Breweries of Amsterdam on wheels\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":95},\n" +
                "{\"name\":\"Private Walking Tour in Utrecht\",\"location\":\"Amersfoort\",\"stars\":0,\"ratings\":0,\"currency\":\"USD\",\"price\":138}\n" +
                "]";

        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        TourPage tourPage = headerMenu.openTourPage();

        SearchTourPage searchTourPage = tourPage.Search(destination, date, adults, child);
        List<TourCard> actualTourCards = SearchTourPage.getTourCardList();

        ObjectMapper objectMapper = new ObjectMapper();
        List<TourCard> expectedTourCards = objectMapper.readValue(expectedResult, new TypeReference<List<TourCard>>() {});


        Assert.assertEquals(actualTourCards.size(), expectedTourCards.size());
        System.out.println("ActualResult"+actualTourCards);
        System.out.println("ExpectedResult"+expectedTourCards);
        Assert.assertTrue(actualTourCards.containsAll(expectedTourCards));
        Assert.assertTrue(expectedTourCards.containsAll(actualTourCards));
    }

}
