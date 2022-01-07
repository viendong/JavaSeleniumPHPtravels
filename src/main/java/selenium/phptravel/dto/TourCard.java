package selenium.phptravel.dto;

public class TourCard {
    private String name;
    private String location;
    private int stars;
    private int ratings;
    private String currency;
    private double price;

    public TourCard() {
    }

    public TourCard(String name, String location, int stars, int ratings, String currency, double price) {
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.ratings = ratings;
        this.currency = currency;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TourCard{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", stars=" + stars +
                ", ratings=" + ratings +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        TourCard tourCard = (TourCard) o;
        return this.getName().equals(tourCard.getName())
                && this.getLocation().equals(tourCard.getLocation())
                && this.getStars() == tourCard.getStars()
                && this.getCurrency().equals(tourCard.getCurrency())
                && this.getPrice() == tourCard.getPrice();
    }

}
