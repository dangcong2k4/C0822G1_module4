package com.codegym.exercise.service.impl;

import com.codegym.exercise.model.Books;
import com.codegym.exercise.repository.IBookRepository;
import com.codegym.exercise.repository.IReturnBookRepository;
import com.codegym.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IReturnBookRepository returnBookRepository;

    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Books findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void reduceTheNumber(int id) {
        bookRepository.reduceTheNumber(id);
    }

    @Override
    public void increasingTheNumber(int id) {
        bookRepository.increasingTheNumber(id);
    }


}
