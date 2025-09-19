package com.example.apiproductservice.Repositories;

import com.example.apiproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<Product> findAllByCategory_Subcategories_Lastname(String subcategorysurname);

    @Query("select p from Product p where p.category.subcategories= :categorysurname")
    List<Product> blabla(@Param("categorySurname")    String categorysurname);

    @Query("select p from Product p where p.id =:idGreaterthan")
    List<Product> findingsomeproductbyID(@Param("idGreaterthan")   Long idGreaterthan);

    @Query(value = CustomQueries.GET_PRODUCTS_WITH_SUBCATEGORY_NAME,
            nativeQuery = true
    )
    List<Product> someproductsjoins();

    List<Product> findByTitleContaining(String query);
}
