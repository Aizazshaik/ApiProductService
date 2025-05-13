package com.example.apiproductservice.Services;

import com.example.apiproductservice.Repositories.CategoryRepository;
import com.example.apiproductservice.Repositories.ProductRepository;
import com.example.apiproductservice.exceptions.ExceptionAdvice;
//import com.example.apiproductservice.exceptions.ProductNotFoundException;
import com.example.apiproductservice.models.Category;
import com.example.apiproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// we annotate this with service to tell spring to create an object of this class in container or creating a bean
@Service("DBproductService")
public class ProductserviceDBImpl implements Productservice{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductserviceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Product createProduct( Product product) {

        String categoryName = product.getCategory().getName();
         Optional<Category> category=categoryRepository.findByName(categoryName);
        Category categoryToputinProduct =null;
         if(category.isEmpty())
         {
             Category toSaveCategory=new Category();
             toSaveCategory.setName(categoryName);
             categoryToputinProduct=categoryRepository.save(toSaveCategory);
         }
         else
         {
             categoryToputinProduct=category.get();
         }
         product.setCategory(categoryToputinProduct);
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
    @Override
    public Product PatchUpdateProduct(Long ProductId,Product product) {
        Optional<Product> productToupdateOptional=productRepository.findById(ProductId);

        if(productToupdateOptional.isEmpty())
        {
            throw new RuntimeException("Product not found");
        }
        Product productToUpdate=productToupdateOptional.get();

        if(product.getTitle()!=null)
        {
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getDescription()!=null)
        {
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null)
        {
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getImageURL()!=null)
        {
            productToUpdate.setImageURL(product.getImageURL());
        }
        if(product.getCategory()!=null)
        {
            String categoryName=product.getCategory().getName();
           Optional<Category> categoryToUpdateOptional=categoryRepository.findByName(categoryName);

          Category categoryToUpdate=null;
           if(categoryToUpdateOptional.isEmpty())
           {
               Category toSaveCategory=new Category();
               toSaveCategory.setName(categoryName);
               categoryToUpdate=categoryRepository.save(toSaveCategory);
           }
           else {
               categoryToUpdate=categoryToUpdateOptional.get();
           }
            productToUpdate.setCategory(categoryToUpdate);
        }

        return productRepository.save(productToUpdate);
    }
    @Override
    public Product getSingleProduct(Long ProductId) {
        return null;
    }
}
