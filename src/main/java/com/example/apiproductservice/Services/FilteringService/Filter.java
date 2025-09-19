package com.example.apiproductservice.Services.FilteringService;

import com.example.apiproductservice.models.Product;

import java.util.List;

public interface Filter {

    public List<Product> applyFilter(List<Product> products, List<String> allowedValues);

}
