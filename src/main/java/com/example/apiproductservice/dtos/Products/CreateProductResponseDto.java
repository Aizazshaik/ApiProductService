package com.example.apiproductservice.dtos.Products;

import com.example.apiproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String category;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public Long getId() {
//        return id;
//    }

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        createProductResponseDto.setId(product.getId());
        createProductResponseDto.setTitle(product.getTitle());
        createProductResponseDto.setDescription(product.getDescription());
        createProductResponseDto.setPrice(product.getPrice());
        createProductResponseDto.setImageURL(product.getImageURL());
        createProductResponseDto.setCategory(product.getCategory().getName());
        return createProductResponseDto;
    }

//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//
//    }
//    public String getImageURL() {
//        return imageURL;
//    }
//    public void setImageURL(String imageURL) {
//        this.imageURL = imageURL;
//    }
//    public Category getCategory() {
//        return category;
//    }
//    public void setCategory(Category category) {
//        this.category = category;
//    }

}
