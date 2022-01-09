package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT s from SubCategory s WHERE s.category.id = ?1")
    List<SubCategory> getSubCategoriesByCategoryId(Integer categoryId);
}
