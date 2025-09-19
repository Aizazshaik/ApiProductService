package com.example.apiproductservice.Controllers;

import com.example.apiproductservice.Services.Productservice;
import com.example.apiproductservice.dtos.*;
import com.example.apiproductservice.dtos.Fakestore.GetSingleProductResponseDto;
import com.example.apiproductservice.dtos.Products.*;
import com.example.apiproductservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class TestproductController {
        private Productservice productService;
        public TestproductController(@Qualifier("DBproductService") Productservice productService) {
                this.productService = productService;
        }

        @PostMapping("")
        public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
                Product product = productService.createProduct(createProductRequestDto.toProduct());

                //return "This product is a priced at : " + createProductRequestDto.getPrice();
                return CreateProductResponseDto.fromProduct(product);
        }

        @GetMapping("")
        public GetAllProductsResponseDto getAllProducts() {
                List<Product> products = productService.getAllProducts();
                GetAllProductsResponseDto response = new GetAllProductsResponseDto();
                List<GetProductDto> getProductresponseDtos = new ArrayList<>();

                for ( Product product : products ) {
                        getProductresponseDtos.add(GetProductDto.fromProduct(product));
                }
                response.setProduct(getProductresponseDtos);
                return response;
        }

        @GetMapping("/{id}")
        public String getProductById(@PathVariable("id") Long id) {
                Product product=productService.getSingleProduct(id);
                GetSingleProductResponseDto getProductResponseDto = new GetSingleProductResponseDto();
                getProductResponseDto.setProduct(GetProductDto.fromProduct(product));

                return "Here is your product";
        }

//        @DeleteMapping("/{id}")
//        public void deleteProductById(@PathVariable("id") Long id) {
//        }
        @PatchMapping("/{id}")
        public PatchproductResponseDto UpdateProduct(@PathVariable("id") Long id,@RequestBody CreateProductDto productDto){
                Product product = productService.PatchUpdateProduct(id,productDto.toProduct());

                PatchproductResponseDto response = new PatchproductResponseDto();
                response.setProductDto(GetProductDto.fromProduct(product));

                return response;
        }
//        @RequestMapping(name = "AIZAZ", value = "")
//        public String asdfhbib() {
//                return "magic";
//        }

}
