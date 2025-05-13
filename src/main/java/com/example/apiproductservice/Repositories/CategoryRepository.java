package com.example.apiproductservice.Repositories;

import com.example.apiproductservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
Optional<Category> findByName(String name);
//List<Category> findByIdGreaterThanAndNameGreater(Long id,String name);

    @Override
Category save(Category category);
}
