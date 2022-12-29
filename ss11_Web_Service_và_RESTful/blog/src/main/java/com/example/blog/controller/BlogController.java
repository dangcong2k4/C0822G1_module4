package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
//@Component
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "")String title, @PageableDefault(size = 3,page = 0) Pageable pageable, Model model){
        Page<Blog> blogList = iBlogService.findByTitle(title,pageable);
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Blog blog = new Blog();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog",blog);
        return "blog/create";
    }
    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
        List<Blog> blogList = iBlogService.findAll();
        for (Blog blog1:blogList ) {
            if (blog.getTitle().equals(blog1.getTitle())) {
                redirectAttributes.addFlashAttribute("mess","Đã có blog này");
                return "redirect:/blog";
            }
        }
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog",iBlogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        List<Blog> blogList = iBlogService.findAll();
        for (Blog blog1:blogList ) {
            if (blog.getTitle().equals(blog1.getTitle())) {
                redirectAttributes.addFlashAttribute("mess","Đã có blog này");
                return "redirect:/blog";
            }
        }
       iBlogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model,@PathVariable("id") int id){
        iBlogService.delete(id);
        return "redirect:/blog";
    }
    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/blogDetails";
    }
}
