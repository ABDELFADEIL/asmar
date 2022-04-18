package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
