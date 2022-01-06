package selenium.phptravel.dto;

import java.util.List;

public class FilterResult {

    TourSearchFilter filters;
    List<TourCard> results;

    public FilterResult(){}

    public TourSearchFilter getFilters() {
        return filters;
    }

    public List<TourCard> getResults() {
        return results;
    }
}
