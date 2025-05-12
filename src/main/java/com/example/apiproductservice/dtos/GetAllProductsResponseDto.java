package com.example.apiproductservice.dtos;

import java.util.List;

public class GetAllProductsResponseDto {
    private List<GetProductDto> product;
    public List<GetProductDto> getProduct() {
        return product;
    }
    public void setProduct(List<GetProductDto> product) {
        this.product = product;
    }

}
