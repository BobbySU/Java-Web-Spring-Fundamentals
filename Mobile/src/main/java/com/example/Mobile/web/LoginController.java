package com.example.Mobile.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class LoginController extends BaseController{

    @GetMapping("/login")
    public ModelAndView getRegister(){
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public ModelAndView postRegister(){
        return super.redirect("index");
    }
}
