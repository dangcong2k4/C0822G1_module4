package com.codegym.exercise.service.impl;

import com.codegym.exercise.model.ReturnBook;
import com.codegym.exercise.repository.IReturnBookRepository;
import com.codegym.exercise.service.IReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReturnBookService implements IReturnBookService {
    @Autowired
    IReturnBookRepository returnBookRepository;
    @Override
    public List<ReturnBook> findAll() {
        return returnBookRepository.findAll();
    }

    @Override
    public void save(ReturnBook returnBook) {
        returnBookRepository.save(returnBook);
    }

    @Override
    public ReturnBook findById(int id) {
        return returnBookRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        returnBookRepository.deleteById(id);
    }
}
