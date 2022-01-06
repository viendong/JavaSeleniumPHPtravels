package selenium.phptravel.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.pages.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchTourCardInfo extends BasePage {

    private String tourName;
    private final WebElement container;

    public SearchTourCardInfo(WebDriver webDriver, String tourName) {
        super(webDriver);
        this.tourName = tourName;
        this.container = webDriver.findElement(By.id(tourName.toLowerCase()));
    }

    public SearchTourCardInfo(WebDriver webDriver, WebElement container) {
        super(webDriver);
        this.container = container;
    }

    public TourCard getTourCard() {
        TourCard tourCard = new TourCard();
        tourCard.setName(getTourName());
        tourCard.setLocation(getLocation());
        tourCard.setStars(getStars());
        tourCard.setRatings(getRatings());
        tourCard.setCurrency(getCurrency());
        tourCard.setPrice(getPrice());

        return tourCard;
    }

    private String getTourName() {
        By byHotelName = By.xpath(".//h3[@class='card-title']");
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(container.findElement(byHotelName)))
                .getText()
                .trim();
    }

    private String getLocation() {
        By byLocation = By.xpath(".//p[@class='card-meta']");
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(container.findElement(byLocation)))
                .getText()
                .trim();
    }

    private int getStars() {
        By byReview = By.className("review__text");
        By byStar = By.xpath(".//div[@class='rating la la-star']");
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(container.findElement(byReview)))
                .findElements(byStar)
                .size();
    }

    private int getRatings() {
        By byRating = By.className("rating__text");
        return Integer.parseInt(
                webDriverWait
                        .until(ExpectedConditions.visibilityOf(container.findElement(byRating)))
                        .findElement(By.tagName("span"))
                        .getText()
        );
    }

    private String getCurrency() {
        By byPrice = By.className("price__num");
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(container.findElement(byPrice)))
                .findElement(By.tagName("small"))
                .getText();
    }

    private double getPrice() {
        By byPrice = By.className("price__num");
        return Double.parseDouble(
                webDriverWait
                        .until(ExpectedConditions.visibilityOf(container.findElement(byPrice)))
                        .findElement(By.tagName("strong"))
                        .getText()
        );
    }
}
