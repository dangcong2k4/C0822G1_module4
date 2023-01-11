package com.codegym.casetudy.controller;

import com.codegym.casetudy.dto.ContractDto;
import com.codegym.casetudy.dto.CustomerDto;
import com.codegym.casetudy.dto.IContractDto;
import com.codegym.casetudy.model.contract.AttachFacility;
import com.codegym.casetudy.model.contract.Contract;
import com.codegym.casetudy.model.contract.ContractDetail;
import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.facility.Facility;
import com.codegym.casetudy.service.IContractService;
import com.codegym.casetudy.service.ICustomerService;
import com.codegym.casetudy.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String showList(Model model){
        List<IContractDto> contractDtos = contractService.findAllContract();
        model.addAttribute("contractDtos",contractDtos);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList",facilityList);
        List<AttachFacility> attachFacilityList = contractService.findAllAttachFacility();
        model.addAttribute("attachFacilityList",attachFacilityList);
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contract",new Contract());
        return "view/contract/list";
    }

    @PostMapping("/creates")
    public String createContract(@Validated @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasErrors()){
            List<Customer> customerList = customerService.findAll();
            model.addAttribute("customerList",customerList);
            List<Facility> facilityList = facilityService.findAll();
            model.addAttribute("facilityList",facilityList);
            model.addAttribute("modal2",true);
            return "redirect:/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        contractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping("/add")
    public String createContractDetail(ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractService.add(contractDetail);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return "redirect:/contract";
    }

    @PostMapping("/edit")
    public String update(Model model, @ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        contractService.update(contract);
        return "redirect:/contract";
    }
    @PostMapping("/create")
    public String createContract( @ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        contractService.save(contract);
        return "redirect:/contract";
    }
    @GetMapping("/show/{id}")
    public String showAttachFacility(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        List<AttachFacility> attachFacilityList = contractService.findAttachFacilityById(id);
        redirectAttributes.addFlashAttribute("attachFacilityList2",attachFacilityList);
        redirectAttributes.addFlashAttribute("modal",true);
        return "redirect:/contract";
    }
}
