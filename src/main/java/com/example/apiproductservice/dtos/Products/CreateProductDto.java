package com.example.apiproductservice.dtos.Products;

import com.example.apiproductservice.models.Category;
import com.example.apiproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageURL;
    private String categoryName;

//    public void setId(Long id) {
//        this.id = id;
//    }
//    public Long getId() {
//        return id;
//    }

    public static CreateProductDto fromProduct(Product product) {
        CreateProductDto createProductDto = new CreateProductDto();
        createProductDto.setId(product.getId());
        createProductDto.setTitle(product.getTitle());
        createProductDto.setDescription(product.getDescription());
        createProductDto.setPrice(product.getPrice());
        createProductDto.setImageURL(product.getImageURL());
//        createProductDto.setCategoryName(product.getCategory().getName());
        return createProductDto;
    }
    public Product toProduct()
    {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(imageURL);
        Category category1=new Category();
        category1.setName(categoryName);
        product.setCategory(category1);
        return product;
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
