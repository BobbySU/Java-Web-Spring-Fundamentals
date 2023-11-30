package com.example.battleships.models.dto.bilding;

import com.example.battleships.models.entity.enums.CategoryType;
import com.example.battleships.validation.checkShipExistence.ValidateExistenceShip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
public class ShipAddDTO {

    @NotNull
    @Size(min = 2, max = 10)
    @ValidateExistenceShip
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    private Date created;

    @NotNull
    private CategoryType category;
}
