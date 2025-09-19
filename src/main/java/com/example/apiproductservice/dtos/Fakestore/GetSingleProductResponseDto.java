package com.example.apiproductservice.dtos.Fakestore;

import com.example.apiproductservice.dtos.Products.GetProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private GetProductDto product;
}
