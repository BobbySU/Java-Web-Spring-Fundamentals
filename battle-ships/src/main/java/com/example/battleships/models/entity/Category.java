package com.example.battleships.models.entity;

import com.example.battleships.models.entity.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryType name;
    //    o	An option between BATTLE, CARGO, PATROL
//    o	The values should be unique in the database
    @Column(columnDefinition = "TEXT")
    private String description;
//    o	A very long and detailed description of the category
//    o	Can accept null values
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
