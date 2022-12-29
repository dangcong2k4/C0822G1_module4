package com.codegym.casetudy.service.impl;

import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.customer.CustomerType;
import com.codegym.casetudy.repository.customer.ICustomerRepository;
import com.codegym.casetudy.repository.customer.ICustomerTypeRepository;
import com.codegym.casetudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerType> findCustomerTypeAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> searchCustomer(String name, String email, String customerType, Pageable pageable) {
        return customerRepository.searchCustomer(name,email,customerType,pageable);
    }
}
