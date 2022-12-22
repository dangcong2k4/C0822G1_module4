package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findById(int id);

    Page<Blog> findByTitle(String title, Pageable pageable);
}
