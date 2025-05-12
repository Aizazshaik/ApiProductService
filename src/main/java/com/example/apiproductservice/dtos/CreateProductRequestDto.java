package com.example.apiproductservice.dtos;

import com.example.apiproductservice.models.Category;
import com.example.apiproductservice.models.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String categoryName;

    public Product toProduct()
    {
        Product product = new Product();
        product.setTitle(title);

        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(imageURL);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        return product;
    }
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCategoryName() {
//            return categoryName;
//    }
//    public void setCategoryName(String categoryName) {
//        this.categoryName=categoryName;
//    }
//    public String getImageURL() {
//        return imageURL;
//    }
//    public void setImageURL(String imageURL) {
//        this.imageURL = imageURL;
//    }
}
