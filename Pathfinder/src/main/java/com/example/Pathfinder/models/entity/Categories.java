package com.example.Pathfinder.models.entity;


import com.example.Pathfinder.models.entity.enums.CategoriesName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoriesName name;  // - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)

    @Column(columnDefinition = "TEXT")
    private String description;  // - Accepts very long String values

    public Categories() {
    }

    public CategoriesName getName() {
        return name;
    }

    public Categories setName(CategoriesName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Categories setDescription(String description) {
        this.description = description;
        return this;
    }
}
