package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping({""})
    public String currencyConversion(Model model,String number1,String number2){
        double number = Double.parseDouble(number1);
        int choose = Integer.parseInt(number2);
        String result = null;
        switch (choose){
            case 1:
                result = (number * 23000) + " VND";
                break;
             case 2:
                result = (number / 23000) + " USD";
                break;
        }
        model.addAttribute("mess",result);
        return "/result";
    }
}
