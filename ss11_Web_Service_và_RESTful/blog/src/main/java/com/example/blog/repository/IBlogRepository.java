package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where title like concat('%',:title,'%') order by date_create desc ",nativeQuery = true)
    Page<Blog> findByTitle(@Param("title") String title,Pageable pageable);

    @Query(value = "select * from blog where category_id = :id ",nativeQuery = true)
    List<Blog> findByCategory(@Param("id") int id);

    @Query(value = "select * from blog where id = :id ",nativeQuery = true)
    List<Blog> findByIdBlog(@Param("id") int id);
}
