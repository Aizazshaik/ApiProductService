package com.example.apiproductservice.Controllers;

import com.example.apiproductservice.Services.FilteringService.Filter;
import com.example.apiproductservice.Services.SearchService;
import com.example.apiproductservice.dtos.Products.GetProductDto;
import com.example.apiproductservice.dtos.search.FilterDto;
import com.example.apiproductservice.dtos.search.SortingCriteria;
import com.example.apiproductservice.dtos.search.searchResponseDto;
import com.example.apiproductservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/searchApi")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("")
    public searchResponseDto search(
            @RequestParam("query") String query,
            @RequestParam("filter") List<FilterDto> filters,
            @RequestParam("sortBy") SortingCriteria sortingCriteria,
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize
    ) {

        searchResponseDto responseDto = new searchResponseDto();

        Page<Product> productsPage = searchService.search(query,filters,sortingCriteria,pageNumber,pageSize);
        List<GetProductDto> getProductDtoList =
                productsPage.getContent().stream()
                        .map(GetProductDto::fromProduct)
                        .toList();
        Pageable pageable =  PageRequest.of(productsPage.getNumber(), productsPage.getSize(), productsPage.getSort());
        Page<GetProductDto> getProductDtoPage = new PageImpl<>(
                getProductDtoList,
                productsPage.getPageable(),
                productsPage.getTotalElements()
        );
        responseDto.setProductsPage(getProductDtoPage);

        return responseDto;

    }

}
