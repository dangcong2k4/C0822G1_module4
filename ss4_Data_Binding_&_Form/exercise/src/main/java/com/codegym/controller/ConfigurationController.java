package com.codegym.controller;

import com.codegym.model.ElectronicMail;
import com.codegym.service.IElectronicMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConfigurationController {
    @Autowired
    private IElectronicMailService electronicMailService;

    @GetMapping({"/electronicMai"})
    public String showList(Model model){
        List<ElectronicMail> electronicMailList = electronicMailService.findAll();
        model.addAttribute("electronicMailList",electronicMailList);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id,Model model){
        ElectronicMail electronicMail = electronicMailService.findIndexById(id);
        model.addAttribute("listSize",this.electronicMailService.listSize());
        model.addAttribute("listLanguage",this.electronicMailService.listLanguage());
        model.addAttribute("electronicMail",electronicMail);
        return "/update";
    }

    @PostMapping("/edit")
    public String updateMail(Model model, @ModelAttribute("electronicMail") ElectronicMail electronicMail){
        this.electronicMailService.update(electronicMail);
        List<ElectronicMail> electronicMailList = electronicMailService.findAll();
        model.addAttribute("electronicMailList",electronicMailList);
        return "/list";
    }
}
