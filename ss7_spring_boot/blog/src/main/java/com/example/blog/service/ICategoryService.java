package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void update(Category category);

    void delete(int id);

    Category findById(int id);
}
