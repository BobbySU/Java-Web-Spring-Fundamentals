package com.example.battleships.web;

import com.example.battleships.models.dto.bilding.UserLoginDTO;
import com.example.battleships.models.dto.bilding.UserRegisterDTO;
import com.example.battleships.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterDTO") UserRegisterDTO userRegisterDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute ("userRegisterDTO", userRegisterDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO",
                            bindingResult);
            return "redirect:register";
        }

        this.authService.registerUser(userRegisterDTO);

        return "redirect:login";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginDTO") UserLoginDTO userLoginDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute ("userLoginDTO", userLoginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",
                            bindingResult);
            return "redirect:login";
        }
        this.authService.loginUser(userLoginDTO);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String getLogout() {
        this.authService.logoutUser();
        return "redirect:/";
    }

    // Model attributes
    @ModelAttribute(name = "userRegisterDTO")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }

    @ModelAttribute(name = "userLoginDTO")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }
}
