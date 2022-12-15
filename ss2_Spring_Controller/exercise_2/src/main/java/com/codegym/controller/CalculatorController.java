package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class CalculatorController {
    @GetMapping
    public String showFrom(){
        return "/index";
    }
    @RequestMapping("/calculator")
    public String calculator(Model model,double numberOne,double numberTwo,String calculation){
        double result=0;
        String display="";
        switch (calculation){
            case "+":
                result = numberOne + numberTwo;
                display = "kết quả là: "+result;
                break;
            case "-":
                result = numberOne - numberTwo;
                display = "kết quả là: "+result;
                break;
            case "x":
                result = numberOne * numberTwo;
                display = "kết quả là: "+result;
                break;
            case "/":
                if (numberTwo==0) {
                    display ="số thứ hai không thể chia cho 0";
                    break;
                }
                result = numberOne / numberTwo;
                display = "kết quả là: "+result;
                break;
        }
        model.addAttribute("display",display);
        return "/index";
    }
}
