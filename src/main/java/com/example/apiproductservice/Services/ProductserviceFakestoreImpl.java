package com.example.apiproductservice.Services;

import com.example.apiproductservice.dtos.Fakestore.FakestoreCreateProductRequestDto;
import com.example.apiproductservice.dtos.Fakestore.FakestoreCreateProductResponseDto;
import com.example.apiproductservice.dtos.Fakestore.FakestoreGetProductResponseDto;
import com.example.apiproductservice.models.Category;
import com.example.apiproductservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
public class ProductserviceFakestoreImpl implements Productservice {
    private RestTemplate restTemplate;
    public ProductserviceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakestoreCreateProductRequestDto request = new FakestoreCreateProductRequestDto();
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setImage(product.getImageURL());
        request.setDescription(product.getDescription());
        request.setCategory(product.getCategory().getName());

        FakestoreCreateProductResponseDto response = restTemplate.postForObject("https://fakeStoreApi.com/Products",
                request,FakestoreCreateProductResponseDto.class );

        Product product1=new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setPrice(response.getPrice());
        product1.setDescription(response.getDescription());
        Category category1= new Category();
        category1.setName(response.getCategory());
        product1.setCategory(category1);
        product1.setImageURL(response.getImage());

        return product1;
    }

    @Override
    public List<Product> getAllProducts() {

        FakestoreGetProductResponseDto[] response=restTemplate.getForObject("https://fakestoreapi.com/products",
               FakestoreGetProductResponseDto[].class
        );
        List<FakestoreGetProductResponseDto> responseDtolist= Stream.of(response).toList();

        List<Product> products=new ArrayList<>();

        for(FakestoreGetProductResponseDto FakestoreresponseDto:responseDtolist){
            products.add(FakestoreresponseDto.toProduct());
        }
            return products;
    }
    @Override
    public Product getSingleProduct(Long productId) {

        return null;
    }

    @Override
    public Product PatchUpdateProduct(Long productId,Product product) {

//        FakestoreGetProductResponseDto fakestoreGetProductResponseDto=restTemplate.patchForObject(
//                "https://fakestoreapi.com/products/"+productId,
//                FakestoreCreateProductRequestDto.fromProduct(product),
//                FakestoreGetProductResponseDto.class);

        HttpEntity<FakestoreCreateProductRequestDto> requestEntity = new HttpEntity<>(FakestoreCreateProductRequestDto.fromProduct(product));
        ResponseEntity<FakestoreGetProductResponseDto> fakestoreGetProductResponseDtoEntity=restTemplate.exchange(
                "https://fakestoreapi.com/products/"+productId,
                HttpMethod.PATCH,
                requestEntity,
                FakestoreGetProductResponseDto.class);
        return fakestoreGetProductResponseDtoEntity.getBody().toProduct();
    }



}
