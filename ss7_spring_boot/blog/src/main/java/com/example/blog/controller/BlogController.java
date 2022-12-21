package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;


    @GetMapping("")
    public String showList(Model model){
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "blog/create";
    }
    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @ModelAttribute("blog") Blog blog){
        this.iBlogService.update(blog);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model,@PathVariable("id") int id){
        iBlogService.delete(id);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }
    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/blogDetails";
    }
}
