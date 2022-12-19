package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void update(Product product);

    Product findIndexById(int id);

    void delete(int id);

    void add(Product product);

    List<Product>  findByName(String nameProduct);
}
