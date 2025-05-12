package com.example.apiproductservice.Services;

import com.example.apiproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

// we annotate this with service to tell spring to create an object of this class in container or creating a bean
@Service("DBproductService")
public class ProductserviceDBImpl implements Productservice{
    @Override
    public Product createProduct( Product product) {
        return null;
    }
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public Product PatchUpdateProduct(Long ProductId,Product product) {
        return null;
    }
    @Override
    public Product getSingleProduct(Long ProductId) {
        return null;
    }
}
