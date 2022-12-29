package com.codegym.casetudy.controller;

import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.customer.CustomerType;
import com.codegym.casetudy.model.facility.Facility;
import com.codegym.casetudy.model.facility.FacilityType;
import com.codegym.casetudy.model.facility.RentType;
import com.codegym.casetudy.repository.facility.IFacilityRepository;
import com.codegym.casetudy.repository.facility.IFacilityTypeRepository;
import com.codegym.casetudy.repository.facility.IRentTypeRepository;
import com.codegym.casetudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String showList(Model model){
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList",facilityList);
        List<FacilityType> facilityTypeList = facilityService.findFacilityTypeAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        List<RentType> rentTypeList = facilityService.findRentTypeAll();
        model.addAttribute("rentTypeList",rentTypeList);
        return "view/facility/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Facility facility = new Facility();
        List<FacilityType> facilityTypeList = facilityService.findFacilityTypeAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        List<RentType> rentTypeList = facilityService.findRentTypeAll();
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("facility",facility);
        return "view/facility/create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes){

        List<Facility> facilityList = facilityService.findAll();
        for (Facility facility1:facilityList ) {
            if (facility.getName().equals(facility1.getName())) {
                redirectAttributes.addFlashAttribute("mess","Đã có cơ sở này");
                return "redirect:/facility";
            }
        }
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        facilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        List<FacilityType> facilityTypeList = facilityService.findFacilityTypeAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        List<RentType> rentTypeList = facilityService.findRentTypeAll();
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("facility",facilityService.findById(id));
        return "view/facility/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        facilityService.update(facility);
        return "redirect:/facility";
    }

    @GetMapping("/delete")
    public String deleteProduct(int id){
        facilityService.delete(id);
        return "redirect:/facility";
    }
}
