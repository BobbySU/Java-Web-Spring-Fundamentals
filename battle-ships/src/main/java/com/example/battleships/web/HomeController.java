package com.example.battleships.web;

import com.example.battleships.models.dto.ShipDTO;
import com.example.battleships.models.dto.bilding.BattleShipsDTO;
import com.example.battleships.models.dto.bilding.LoggedUser;
import com.example.battleships.models.dto.bilding.UserWithShipsDTO;
import com.example.battleships.models.entity.Ship;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.services.BattleService;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final LoggedUser loggedUser;
    private final BattleService battleService;
    private final UserService userService;
    private final ShipRepository shipRepository;
    private final ShipService shipService;

    @Autowired
    public HomeController(LoggedUser loggedUser, BattleService battleService, UserService userService,
                          ShipRepository shipRepository, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.battleService = battleService;
        this.userService = userService;
        this.shipRepository = shipRepository;
        this.shipService = shipService;
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        UserWithShipsDTO loggedUserWithShips = battleService.getUserWithShips(this.loggedUser.getId());
        UserWithShipsDTO notLoggedUserWithShips = battleService.getUserWithShips(this.userService
                .findByIdNot(loggedUser.getId())
                .getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("loggedUserWithShips", loggedUserWithShips);
        modelAndView.addObject("notLoggedUserWithShips", notLoggedUserWithShips);

        return modelAndView;
    }

    @PostMapping("battle")
    public String getHome(@ModelAttribute(name = "battleShipsModel") BattleShipsDTO battleShipsModel) {
        this.shipService.fight(battleShipsModel);
        return "redirect:home";
    }
    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @ModelAttribute(name = "battleShipsModel")
    public BattleShipsDTO battleShipsModel() {
        return new BattleShipsDTO();
    }

    @ModelAttribute(name = "allShips")
    public List<Ship> ships(){
        if(loggedUser.isEmpty()){
            return List.of();
        }
        return this.shipRepository.findAll();
    }
}
