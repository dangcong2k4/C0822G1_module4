package com.codegym.casetudy.repository;

import com.codegym.casetudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select `customer`.* from `customer`" +
            "join `customer_type` on `customer_type`.id=`customer`.customer_type_id" +
            " where `customer`.name like concat('%',:name,'%') and `customer`.email like concat('%',:email,'%') and `customer_type`.name like concat('%',:customerType,'%')",nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name") String name,
                                  @Param("email") String email,
                                  @Param("customerType") String customerType,
                                  Pageable pageable);
}
