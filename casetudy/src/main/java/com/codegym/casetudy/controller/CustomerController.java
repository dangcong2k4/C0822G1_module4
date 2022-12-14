package com.codegym.casetudy.controller;

import com.codegym.casetudy.dto.CustomerDto;
import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.customer.CustomerType;
import com.codegym.casetudy.service.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(value ="name" ,   defaultValue = "")String name,
                           @RequestParam( value = "email", defaultValue = "")String email,
                           @RequestParam(value = "customerType", defaultValue = "")String customerType, @PageableDefault(size = 5,page = 0) Pageable pageable){
        Page<Customer> customerList;
        if(Objects.equals(customerType, "")){
            customerList = customerService.findByNameAndEmail(name,email,pageable);
        }else {
            customerList  = customerService.searchCustomer(name,email,customerType,pageable);
        }
        model.addAttribute("customerList",customerList);
        List<CustomerType> customerTypeList = customerService.findCustomerTypeAll();
        model.addAttribute("customerTypeList",customerTypeList);
        return "view/customer/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Customer customer = new Customer();
        List<CustomerType> customerTypeList = customerService.findCustomerTypeAll();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customerDto",customer);
        return "view/customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            List<CustomerType> customerTypeList = customerService.findCustomerTypeAll();
            model.addAttribute("customerTypeList",customerTypeList);
            return "view/customer/create";
        }
        List<Customer> customerList = customerService.findAll();
        for (Customer customer1:customerList ) {
            if (customerDto.getIdCard().equals(customer1.getIdCard())) {
                redirectAttributes.addFlashAttribute("mess","???? c?? Kh??ch h??ng n??y");
                return "redirect:/customer";
            }
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        redirectAttributes.addFlashAttribute("mess","Th??m m???i th??nh c??ng");
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        List<CustomerType> customerTypeList = customerService.findCustomerTypeAll();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customerDto",customerService.findById(id));
        return "view/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            List<CustomerType> customerTypeList = customerService.findCustomerTypeAll();
            model.addAttribute("customerTypeList",customerTypeList);
            return "view/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        redirectAttributes.addFlashAttribute("mess","Ch???nh s???a th??nh c??ng");
        customerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(int id){
        customerService.delete(id);
        return "redirect:/customer";
    }

}
