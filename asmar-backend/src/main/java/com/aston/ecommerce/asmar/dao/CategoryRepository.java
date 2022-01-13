package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT s from Category s WHERE s.id =:categoryId ORDER BY s.label")
    List<Category> getProductsByCategoryId(Long categoryId);
}
