package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void update(Product product);

    Product findIndexById(int id);

    void delete(int id);

    void add(Product product);

    List<Product>  findByName(String nameProduct);
}
