package com.example.apiproductservice.dtos;

import com.example.apiproductservice.dtos.Products.GetProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchproductResponseDto {
    private GetProductDto productDto;

//    public GetProductDto getProductDto() {
//            return productDto;
//    }
//    public void setProductDto(GetProductDto getProductDto) {
//        this.productDto = getProductDto;
//    }

}
