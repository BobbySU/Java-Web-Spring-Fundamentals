package com.exam.shoppingList.models.service;

import com.exam.shoppingList.models.entity.enums.CategoryName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryName category;

    public ProductServiceModel() {
    }

    public String getId() {
        return id;
    }

    public ProductServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductServiceModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
