package com.example.battleships.services;

import com.example.battleships.models.dto.CategoryDTO;
import com.example.battleships.models.dto.ShipDTO;
import com.example.battleships.models.dto.bilding.LoggedUser;
import com.example.battleships.models.dto.bilding.ShipAddDTO;
import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.entity.Ship;
import com.example.battleships.repository.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryServices categoryServices;

    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryServices categoryServices) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryServices = categoryServices;
    }

    public void addShip(ShipAddDTO shipAddDTO) {
        UserDTO user1 = this.userService.findById(loggedUser.getId());
        CategoryDTO category1 = this.categoryServices.findByName(shipAddDTO.getCategory());

        Ship ship = this.modelMapper.map(ShipDTO.builder()
                .name(shipAddDTO.getName())
                .health(shipAddDTO.getHealth())
                .power(shipAddDTO.getPower())
                .created(shipAddDTO.getCreated())
                .category(category1)
                .user(user1)
                .build(), Ship.class);

        this.shipRepository.saveAndFlush(ship);
    }
}
