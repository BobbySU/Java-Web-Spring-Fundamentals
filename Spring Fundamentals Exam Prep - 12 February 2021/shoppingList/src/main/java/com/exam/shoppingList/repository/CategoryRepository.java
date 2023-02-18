package com.exam.shoppingList.repository;

import com.exam.shoppingList.models.entity.Category;
import com.exam.shoppingList.models.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findByName(CategoryName name);
}
