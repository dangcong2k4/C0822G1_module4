package com.codegym.exercise.service;

import com.codegym.exercise.model.ReturnBook;

import java.util.List;

public interface IReturnBookService {
    List<ReturnBook> findAll();

    void save(ReturnBook returnBook);

    ReturnBook findById(int id);

    void delete(int id);
}
