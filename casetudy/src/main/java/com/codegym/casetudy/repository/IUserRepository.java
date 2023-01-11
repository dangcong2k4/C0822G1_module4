package com.codegym.casetudy.repository;

import com.codegym.casetudy.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
