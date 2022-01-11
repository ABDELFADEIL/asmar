package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT s from SubCategory s WHERE s.category = ?1 ORDER BY s.label")
    List<SubCategory> findSubCategoriesByCategory(Category category);
}
