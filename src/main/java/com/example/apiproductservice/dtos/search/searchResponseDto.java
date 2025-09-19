package com.example.apiproductservice.dtos.search;

import com.example.apiproductservice.dtos.Products.GetProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class searchResponseDto {
    private Page<GetProductDto> ProductsPage;
}
