package com.example.apiproductservice.Services;

import com.example.apiproductservice.Repositories.ProductRepository;
import com.example.apiproductservice.Services.FilteringService.FactoryFilter;
import com.example.apiproductservice.Services.SortingService.SorterFactory;
import com.example.apiproductservice.dtos.search.FilterDto;
import com.example.apiproductservice.dtos.search.SortingCriteria;
import com.example.apiproductservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> search(
            String query,
            List<FilterDto> filters,
            SortingCriteria sortingCriteria,
            int pageNumber,
            int pageSize
    ){
   List<Product> products = productRepository.findByTitleContaining(query);
   for(FilterDto filterDto: filters) {

       products= FactoryFilter.getFilterFromKey(filterDto.getKey())
                .applyFilter(products, filterDto.getValues());
   }

   products= SorterFactory.getSorterbyCriteria(sortingCriteria).sort(products);
    List<Product> ProductsonOnPage = new ArrayList<>();
   for(int i=pageSize * (pageNumber - 1); i < pageSize * pageNumber && i < products.size(); i++){
       ProductsonOnPage.add(products.get(i));
   }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
    return new PageImpl<>(ProductsonOnPage, pageable, products.size());
    }
}
