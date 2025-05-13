package com.example.apiproductservice.Repositories;

import com.example.apiproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product p);

    @Override
    void delete(Product Entity);


    Optional<Product> findProductById(Long id);

    @Override
    List<Product> findAll();
}
