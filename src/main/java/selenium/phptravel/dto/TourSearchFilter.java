package selenium.phptravel.dto;

public class TourSearchFilter {
    String destination;
    String date;
    int adults;
    int child;

    public TourSearchFilter(){

    }

    public TourSearchFilter(String destination, String date, int adults, int child) {
        this.destination = destination;
        this.date = date;
        this.adults = adults;
        this.child = child;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String tourName) {
        this.destination = tourName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

}
