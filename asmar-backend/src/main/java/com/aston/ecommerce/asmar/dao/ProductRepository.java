package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT(p) FROM Product p WHERE CONCAT(p.label,'', p.description) LIKE %:keyword%")
    List<Product> findProductsByLabelOrderByDescription(String keyword);

    @Query( value = "SELECT p FROM Product p WHERE p.subCategory =?1 ORDER BY p.label")
    List<Product> getProductBySubCategory(SubCategory subCategory);
    }

