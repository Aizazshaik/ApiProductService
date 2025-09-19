package com.example.apiproductservice.Services.FilteringService;

public class FactoryFilter {
    public static Filter getFilterFromKey(String key){
        return switch(key)
        {
            case "RAM" -> new RAMFilter();
            case "Brand" -> new BrandFilter();
            case null, default -> null;
        };
    }
}
