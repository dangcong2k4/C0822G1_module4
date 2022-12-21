package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findById(int id);
}
