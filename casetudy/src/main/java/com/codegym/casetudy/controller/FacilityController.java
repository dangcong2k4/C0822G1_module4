package com.codegym.casetudy.controller;

import com.codegym.casetudy.dto.CustomerDto;
import com.codegym.casetudy.dto.FacilityDto;
import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.customer.CustomerType;
import com.codegym.casetudy.model.facility.Facility;
import com.codegym.casetudy.model.facility.FacilityType;
import com.codegym.casetudy.model.facility.RentType;
import com.codegym.casetudy.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value ="name" ,   defaultValue = "")String name,
                           @RequestParam(value = "facilityType", defaultValue = "")String facilityType,
                           @PageableDefault(size = 5,page = 0) Pageable pageable){
        Page<Facility> facilityList = facilityService.searchFacility(name,facilityType,pageable);
        if(Objects.equals(facilityType, "")){
            facilityList = facilityService.searchFacilityName(name,pageable);
        }else {
            facilityList  = facilityService.searchFacility(name,facilityType,pageable);
        }
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
        model.addAttribute("facilityDto",facility);
        return "view/facility/create";
    }
    @PostMapping("/create")
    public String createFacility(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new FacilityDto().validate(facilityDto,bindingResult);
        if(bindingResult.hasErrors()){
            List<FacilityType> facilityTypeList = facilityService.findFacilityTypeAll();
            model.addAttribute("facilityTypeList",facilityTypeList);
            List<RentType> rentTypeList = facilityService.findRentTypeAll();
            model.addAttribute("rentTypeList",rentTypeList);
            return "view/facility/create";
        }
        List<Facility> facilityList = facilityService.findAll();
        for (Facility facility1:facilityList ) {
            if (facilityDto.getName().equals(facility1.getName())) {
                redirectAttributes.addFlashAttribute("mess","Đã có cơ sở này");
                return "redirect:/facility";
            }
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facility.setMaxPeople(Integer.parseInt(facilityDto.getMaxPeople()));
        facility.setArea(Integer.parseInt(facilityDto.getArea()));
        facility.setCost(Double.parseDouble(facilityDto.getCost()));
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
