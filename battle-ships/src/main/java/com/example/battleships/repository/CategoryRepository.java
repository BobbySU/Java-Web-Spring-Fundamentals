package com.example.battleships.repository;

import com.example.battleships.models.entity.Category;
import com.example.battleships.models.entity.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(CategoryType name);
}
