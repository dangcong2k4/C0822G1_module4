package com.example.exercise_1.controller;

import com.example.exercise_1.dto.UserDto;
import com.example.exercise_1.model.User;
import com.example.exercise_1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showCreate( Model model){

        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    @GetMapping("/result")
    public String showResult( Model model){
        return "/result";
    }



    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        redirectAttributes.addFlashAttribute("mess","Đăng nhập thành công");
        userService.save(user);
        return "redirect:/result";
    }
}
