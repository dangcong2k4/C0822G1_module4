package com.example.blog.controller.rest;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog2")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = iBlogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogList(@PathVariable("id") int id) {
        List<Blog> list = iBlogService.findByCategory(id);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<List<Blog>> getBlogListById(@PathVariable("id") int id) {
        List<Blog> list = iBlogService.findByIdBlog(id);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
