package com.codegym.exercise.controller;

import com.codegym.exercise.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute("cart")CartDto cartDto){
        return new ModelAndView("cart/list","cart",cartDto);
    }
}
