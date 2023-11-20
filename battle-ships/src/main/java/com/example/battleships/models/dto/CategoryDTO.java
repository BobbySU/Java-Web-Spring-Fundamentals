package com.example.battleships.models.dto;

import com.example.battleships.models.entity.enums.CategoryType;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private String id;
    private CategoryType name;
    private String description;

}
