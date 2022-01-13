package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
