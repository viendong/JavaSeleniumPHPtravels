package selenium.phptravel.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.phptravel.dto.TourCard;
import selenium.phptravel.pages.BasePage;


public class SearchTourCardInfo extends BasePage {

    private String destination;
    private final WebElement container;

    public SearchTourCardInfo(WebDriver webDriver, String destination) {
        super(webDriver);
        By byContainer = By.xpath(String.format(".//h3[@class='card-title' and normalize-space(.)='%s']",destination));
        this.destination = destination;
        this.container = webDriver.findElement(By.id(destination.toLowerCase()));
    }

    public SearchTourCardInfo(WebDriver webDriver, WebElement container) {
        super(webDriver);
        this.container = container;
    }

    public TourCard getTourCard() {
        TourCard tourCard = new TourCard();
        tourCard.setName(getDestination());
        tourCard.setLocation(getLocation());
        tourCard.setStars(getStars());
        tourCard.setRatings(getRatings());
        tourCard.setCurrency(getCurrency());
        tourCard.setPrice(getPrice());

        return tourCard;
    }

    private String getDestination() {
        By byTourName = By.xpath(".//h3[@class='card-title']");
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(container.findElement(byTourName)))
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
