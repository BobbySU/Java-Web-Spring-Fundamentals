package com.exam.shoppingList.init;

import com.exam.shoppingList.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitializer implements CommandLineRunner {

    private final CategoryService categoryService;

    public DataBaseInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
