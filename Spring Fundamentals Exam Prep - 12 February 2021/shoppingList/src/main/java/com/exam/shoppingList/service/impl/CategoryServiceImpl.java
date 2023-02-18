package com.exam.shoppingList.service.impl;

import com.exam.shoppingList.models.entity.Category;
import com.exam.shoppingList.models.entity.enums.CategoryName;
import com.exam.shoppingList.repository.CategoryRepository;
import com.exam.shoppingList.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(categoryName -> {
                Category category = new Category(categoryName,
                        "Description for " + categoryName.name());
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
