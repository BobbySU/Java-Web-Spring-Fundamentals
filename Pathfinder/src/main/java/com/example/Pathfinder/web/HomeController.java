package com.example.Pathfinder.web;

import com.example.Pathfinder.service.impl.RouteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController{
    private final RouteServiceImpl routeService;

    public HomeController(RouteServiceImpl routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.addObject("mostCommented", routeService.getMostCommented());
        return super.view("index", modelAndView);
    }
}
