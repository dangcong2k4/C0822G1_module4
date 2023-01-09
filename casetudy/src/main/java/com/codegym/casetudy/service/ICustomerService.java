package com.codegym.casetudy.service;

import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICustomerService {
    List<Customer> findAll();

    List<CustomerType> findCustomerTypeAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Customer findById(int id);

    Page<Customer> searchCustomer(String name,String email,String customerType, Pageable pageable);

    Page<Customer> findByNameAndEmail(String name,String email, Pageable pageable);
}
