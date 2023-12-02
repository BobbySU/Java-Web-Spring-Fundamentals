package com.example.battleships.services;

import com.example.battleships.models.dto.CategoryDTO;
import com.example.battleships.models.dto.ShipDTO;
import com.example.battleships.models.dto.bilding.BattleShipsDTO;
import com.example.battleships.models.dto.bilding.LoggedUser;
import com.example.battleships.models.dto.bilding.ShipAddDTO;
import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.entity.Ship;
import com.example.battleships.repository.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryServices categoryServices;

    @Autowired
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

    public List<ShipDTO> findAllByUserId(String id){
        return this.shipRepository.findAllByUserId(id).orElseThrow().stream()
                .map(ship -> this.modelMapper.map(ship, ShipDTO.class)).toList();
    }

    public void fight(BattleShipsDTO battleShipsDTO) {
        Ship loggedShip = this.shipRepository.findById(battleShipsDTO.getLoggedUserShip()).orElseThrow();
        Ship notLoggedShip = this.shipRepository.findById(battleShipsDTO.getNotLoggedUserShip()).orElseThrow();

        notLoggedShip.setHealth(notLoggedShip.getHealth() - loggedShip.getPower());

        if (notLoggedShip.getHealth() <= 0) {
            this.shipRepository.deleteById(battleShipsDTO.getNotLoggedUserShip());
        } else {
            this.shipRepository.saveAndFlush(notLoggedShip);
        }
    }
}
