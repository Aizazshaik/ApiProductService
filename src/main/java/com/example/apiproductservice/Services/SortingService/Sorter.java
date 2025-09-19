package com.example.apiproductservice.Services.SortingService;

import com.example.apiproductservice.models.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
