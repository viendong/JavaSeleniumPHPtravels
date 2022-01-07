package selenium.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.pages.components.SearchTourCardInfo;

import java.util.ArrayList;
import java.util.List;

public class SearchTourPage extends BasePage{

    @FindBy(xpath = ".//section[@id='data']")
    private static WebElement dataSection;

    public SearchTourPage(WebDriver webDriver) {
        super(webDriver);
    }

//    public static List<TourCard> getTourCardList() {
//        List<WebElement> tourContainers = dataSection.findElements(By.xpath(".//div[@class='card-item card-item-list']"));
//        List<TourCard> tourCards = new ArrayList<>();
//
//        for (WebElement container : tourContainers) {
//            SearchTourCardInfo searchTourCardInfo = new SearchTourCardInfo(webDriver, container);
//            tourCards.add(searchTourCardInfo.getTourCard());
//        }
//
//        return tourCards;
//    }

    public static List<TourCard> getTourCardList(){
        List<WebElement> tourContainer = dataSection.findElements(By.xpath(".//div[@class='card-item card-item-list']"));
        List<TourCard> tourCards = new ArrayList<>();

        for (WebElement container : tourContainer){
            SearchTourCardInfo searchTourCardInfo = new SearchTourCardInfo(webDriver,container);
            tourCards.add(searchTourCardInfo.getTourCard());
        }

        return  tourCards;
    }
}
