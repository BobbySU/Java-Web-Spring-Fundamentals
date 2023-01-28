package com.example.Mobile.models.dto;

import com.example.Mobile.models.entity.Brand;
import com.example.Mobile.models.entity.enums.Category;

import java.time.LocalDate;

public class ModelDTO extends BaseEntityDTO{
    private String name;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDate created;
    private LocalDate modified;
    private BrandDTO brand;
}
