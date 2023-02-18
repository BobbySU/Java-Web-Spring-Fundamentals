package com.exam.shoppingList.models.binding;

import com.exam.shoppingList.models.entity.enums.CategoryName;
import com.exam.shoppingList.models.service.ProductServiceModel;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryName category;

    public ProductAddBindingModel() {
    }

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3, message = "Description must be min 3 characters.")
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be positive.")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date cannot be in the past.")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    @NotNull(message = "You must select Category.")
    public CategoryName getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
