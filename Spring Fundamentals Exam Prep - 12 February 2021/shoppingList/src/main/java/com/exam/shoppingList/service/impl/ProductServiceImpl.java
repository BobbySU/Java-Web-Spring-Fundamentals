package com.exam.shoppingList.service.impl;

import com.exam.shoppingList.models.entity.Product;
import com.exam.shoppingList.models.service.ProductServiceModel;
import com.exam.shoppingList.repository.ProductRepository;
import com.exam.shoppingList.service.CategoryService;
import com.exam.shoppingList.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));
        productRepository.save(product);
    }
}
