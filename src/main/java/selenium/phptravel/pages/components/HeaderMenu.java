package selenium.phptravel.pages.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.phptravel.pages.SignupPage;
import selenium.phptravel.pages.TourPage;

import selenium.phptravel.pages.BasePage;

public class HeaderMenu extends BasePage {
    @FindBy(linkText = "Home")
    private WebElement lkHome;

    @FindBy(linkText = "Hotels")
    private WebElement lkHotels;

    @FindBy(linkText = "Flights")
    private WebElement lkFlights;

    @FindBy(linkText = "Tours")
    private WebElement lkTours;

    @FindBy(linkText = "Cars")
    private WebElement lkCars;

    @FindBy(linkText = "Visa")
    private WebElement lkVisa;

    @FindBy(linkText = "Blog")
    private WebElement lkBlog;


    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

//    public HotelPage openHotels(){
//        scrollClick(lkHotels);
//        return new HotelPage(webDriver);
//    }


    public TourPage openTourPage() {
        scrollClick(lkTours);
        return new TourPage(webDriver);
    }
}
