package com.example.apiproductservice.dtos.Products;

import com.example.apiproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageURL;
    private String categoryName;

    public static GetProductDto fromProduct(Product product) {
        GetProductDto getProductdto = new GetProductDto();
        getProductdto.setId(product.getId());
        getProductdto.setTitle(product.getTitle());
        getProductdto.setDescription(product.getDescription());
        getProductdto.setPrice(product.getPrice());
        getProductdto.setImageURL(product.getImageURL());
        getProductdto.setCategoryName(product.getCategory().getName());

        return getProductdto;
    }

//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
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
//    public void setCategoryName(Category category) {
//        this.category = category;
//    }
}
