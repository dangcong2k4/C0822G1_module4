package com.codegym.casetudy.repository;

import com.codegym.casetudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
