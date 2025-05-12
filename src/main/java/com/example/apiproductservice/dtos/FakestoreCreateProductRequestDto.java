package com.example.apiproductservice.dtos;

import com.example.apiproductservice.models.Category;
import com.example.apiproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreCreateProductRequestDto {

    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public static FakestoreCreateProductRequestDto fromProduct(Product product) {
        FakestoreCreateProductRequestDto fakestoreCreateProductRequestDto = new FakestoreCreateProductRequestDto();
        fakestoreCreateProductRequestDto.title = product.getTitle();
        fakestoreCreateProductRequestDto.price = product.getPrice();
        fakestoreCreateProductRequestDto.category = product.getCategory().getName();
        fakestoreCreateProductRequestDto.description = product.getDescription();
        fakestoreCreateProductRequestDto.image=product.getImageURL();
        return fakestoreCreateProductRequestDto;

    }
//
//    public String getTitle() {
//            return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//    public String getImage() {
//        return image;
//    }
//    public void setImage(String image) {
//        this.image = image;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public String getCategory() {
//        return category;
//    }
//    public void setCategory(String category) {
//        this.category = category;
//    }

}
