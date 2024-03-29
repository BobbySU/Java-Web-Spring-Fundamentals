package com.example.battleships.web;

import com.example.battleships.models.dto.bilding.ShipAddDTO;
import com.example.battleships.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String getAddShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String postAddShip(@Valid @ModelAttribute(name = "shipAddDTO") ShipAddDTO shipAddDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute ("shipAddDTO", shipAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddDTO",
                            bindingResult);
            return "redirect:add";
        }

        this.shipService.addShip(shipAddDTO);

        return "redirect:/home";
    }

    @ModelAttribute(name = "shipAddDTO")
    public ShipAddDTO shipAddDTO(){
        return new ShipAddDTO();
    }
}
