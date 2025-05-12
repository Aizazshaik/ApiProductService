package com.example.apiproductservice.Services;

import com.example.apiproductservice.models.Product;

import java.util.List;

public interface Productservice {
    Product createProduct(Product product);

    List<Product> getAllProducts();
    Product getSingleProduct(Long id);

    Product PatchUpdateProduct(Long id,Product product);
}
