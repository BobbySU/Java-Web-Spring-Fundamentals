package com.exam.shoppingList.service;

import com.exam.shoppingList.models.entity.Category;
import com.exam.shoppingList.models.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
