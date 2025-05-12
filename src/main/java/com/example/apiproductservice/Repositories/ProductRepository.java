package com.example.apiproductservice.Repositories;

import com.example.apiproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product p);

    @Override
    void delete(Product p);
}
