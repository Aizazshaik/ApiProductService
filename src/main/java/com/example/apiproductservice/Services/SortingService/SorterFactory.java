package com.example.apiproductservice.Services.SortingService;

import com.example.apiproductservice.dtos.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterbyCriteria(SortingCriteria criteria) {
        return switch (criteria) {
            case RELEVANCE -> null;
            case POPULARITY -> null;
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case RATING_HIGH_TO_LOW -> null;
            case null, default -> null;
        };
    }
}
