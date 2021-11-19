package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.SubCategory;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
