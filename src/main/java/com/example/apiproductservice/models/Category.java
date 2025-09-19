package com.example.apiproductservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> FeaturedProducts;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> allProducts;

 
    @OneToOne
    private Subcategory subcategories;
}
