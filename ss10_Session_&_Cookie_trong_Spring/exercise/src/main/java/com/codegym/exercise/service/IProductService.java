package com.codegym.exercise.service;

import com.codegym.exercise.model.Product;

import java.util.List;
import java.util.Optional;


public interface IProductService {
    void save(Product product);

    List<Product> findAll();

    Optional<Product> findById(int id);
}
