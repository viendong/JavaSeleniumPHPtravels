package selenium.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TourPage extends BasePage {
    @FindBy(xpath = ".//a[text()='Tours']")
    private WebElement lkTours;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement tbDestination;

    @FindBy(id = "date")
    private WebElement tbDate;

    @FindBy (xpath = ".//div[@class='dropdown dropdown-contain']")
//    css="div.dropdown.dropdown-contain"
    private WebElement listTravellers;

    @FindBy(id = "tours_adults")
    private WebElement tbAdults;

    @FindBy(id = "tours_child")
    private WebElement tbChild;

    @FindBy(id="submit")
    private WebElement btnSearch;

    public TourPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void scrollPixel() {
        jsExecutor.executeScript("window.scrollBy(0,500)");
    }

    public void inputDestination (String Destination) throws InterruptedException {
        By selectContainer = By.xpath(".//span[@aria-labelledby='select2-tours_city-container']");
        By inputResult = By.xpath(".//input[@class='select2-search__field']");
        By selectResult = By.xpath(String.format(".//li[contains(normalize-space(.),'%s')]", Destination));

        Thread.sleep(1000);

        click(selectContainer);
        inputText(inputResult,Destination);

        click(selectResult);
    }

    public void selectDate(String date) throws ParseException {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        String checkinDate = new SimpleDateFormat("dd-MM-yyyy").format(d);
        click(tbDate);
        setText(tbDate, checkinDate);
    }

    public void selectAdults(int adults){
        setText(tbAdults,String.valueOf(adults));
    }

    public void selectChild(int child){
        setText(tbChild,String.valueOf(child));
    }

    public void setTravellers(int adults, int child){
        click(listTravellers);

        selectAdults(adults);
        selectChild(child);

    }

    public void clickSearch(){
        click(btnSearch);
    }

    public SearchTourPage Search(String destination, String date, int adults, int child) throws ParseException, InterruptedException {
        inputDestination(destination);
        selectDate(date);
        setTravellers( adults, child);
        click(btnSearch);

        return new SearchTourPage(webDriver);
    }
}
