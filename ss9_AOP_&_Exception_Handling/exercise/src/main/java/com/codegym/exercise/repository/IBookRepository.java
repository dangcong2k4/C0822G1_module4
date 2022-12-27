package com.codegym.exercise.repository;

import com.codegym.exercise.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Books, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update books set remaining = remaining - 1 where id =:id", nativeQuery = true)
    void reduceTheNumber(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update books set amount_borrowed = amount_borrowed + 1 where id =:id", nativeQuery = true)
    void increasingTheNumber(@Param("id") int id);
}
