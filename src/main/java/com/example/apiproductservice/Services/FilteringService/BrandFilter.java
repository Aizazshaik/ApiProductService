package com.example.apiproductservice.Services.FilteringService;

import com.example.apiproductservice.models.Product;

import java.util.List;

public class BrandFilter implements Filter {

    @Override
    public List<Product> applyFilter(List<Product> products, List<String> allowedValues) {
            return List.of();
    }
}
