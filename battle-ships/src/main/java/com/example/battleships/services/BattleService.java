package com.example.battleships.services;

import com.example.battleships.models.dto.bilding.UserWithShipsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private final UserService userService;
    private final ShipService shipService;
    @Autowired
    public BattleService(UserService userService, ShipService shipService) {
        this.userService = userService;
        this.shipService = shipService;
    }

    public UserWithShipsDTO getUserWithShips(String id) {
        return UserWithShipsDTO.builder()
                .userDTO(this.userService.findById(id))
                .shipDTOS(this.shipService.findAllByUserId(id))
                .build();
    }
}
