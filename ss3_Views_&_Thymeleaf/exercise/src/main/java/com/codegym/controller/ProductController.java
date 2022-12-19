package com.codegym.controller;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping({"/product"})
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        Product product = productService.findIndexById(id);
        model.addAttribute("product",product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @ModelAttribute("product") Product product){
        this.productService.update(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model,@PathVariable("id") int id){
        productService.delete(id);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "/create";
    }
    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute("product") Product product){
        productService.add(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }
    @GetMapping("/search")
    public String showSearch( Model model, String nameProduct){
        List<Product> product = productService.findByName(nameProduct);
        model.addAttribute("product",product);
        return "/search";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model){
        Product product = productService.findIndexById(id);
        model.addAttribute("product",product);
        return "/productDetails";
    }
}
