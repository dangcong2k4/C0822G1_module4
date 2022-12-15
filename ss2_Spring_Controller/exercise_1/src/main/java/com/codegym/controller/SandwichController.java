package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping({""})
    public String saveSandwich(Model model, String lettuce, String tomato, String mustard, String sprouts){
        model.addAttribute("lettuce",lettuce);
        model.addAttribute("tomato",tomato);
        model.addAttribute("mustard",mustard);
        model.addAttribute("sprouts",sprouts);
        return "/result";
    }
}
