package com.codegym.exercise.repository;

import com.codegym.exercise.model.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReturnBookRepository extends JpaRepository<ReturnBook,Integer> {
}
