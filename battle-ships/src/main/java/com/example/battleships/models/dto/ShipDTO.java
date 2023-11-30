package com.example.battleships.models.dto;

import com.example.battleships.models.entity.enums.CategoryType;
import lombok.*;

import java.sql.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipDTO {
    private String id;
    private String name;
    private Long health;
    private Long power;
    private Date created;
    private CategoryDTO category;
    private UserDTO user;
}
