package com.example.battleships.services;

import com.example.battleships.models.dto.CategoryDTO;
import com.example.battleships.models.entity.Category;
import com.example.battleships.models.entity.enums.CategoryType;
import com.example.battleships.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServices {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServices(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct (){
        if(this.categoryRepository.count() == 0){
            this.categoryRepository.saveAllAndFlush(Arrays.stream(CategoryType.values())
                    .map(enumValue -> CategoryDTO.builder()
                    .name(enumValue)
                    .description("Fight for the Glory")
                    .build())
                    .map(categoryDTO -> this.modelMapper.map(categoryDTO, Category.class))
                    .toList());
        }
    }
}
