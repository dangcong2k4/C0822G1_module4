package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "category/create";
    }
    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute("category") Category category){
        categoryService.save(category);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @ModelAttribute("blog") Category category){
        this.categoryService.update(category);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model,@PathVariable("id") int id){
        categoryService.delete(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }
}
