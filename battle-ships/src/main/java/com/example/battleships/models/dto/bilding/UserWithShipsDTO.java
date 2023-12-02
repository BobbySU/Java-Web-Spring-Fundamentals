package com.example.battleships.models.dto.bilding;

import com.example.battleships.models.dto.ShipDTO;
import com.example.battleships.models.dto.UserDTO;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWithShipsDTO {
    private UserDTO userDTO;
    private List<ShipDTO> shipDTOS;
}
