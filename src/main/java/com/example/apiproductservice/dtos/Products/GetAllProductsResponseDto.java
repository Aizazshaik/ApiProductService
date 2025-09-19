package com.example.apiproductservice.dtos.Products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsResponseDto {
    private List<GetProductDto> product;
//    public List<GetProductDto> getProduct() {
//        return product;
//    }
//    public void setProduct(List<GetProductDto> product) {
//        this.product = product;
//    }

}
