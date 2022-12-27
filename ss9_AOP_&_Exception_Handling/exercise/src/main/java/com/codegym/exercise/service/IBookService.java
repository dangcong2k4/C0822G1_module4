package com.codegym.exercise.service;

import com.codegym.exercise.model.Books;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookService {
    List<Books> findAll();

    Books findById(int id);

    void reduceTheNumber(@Param("id") int id);

    void increasingTheNumber(@Param("id") int id);

}
