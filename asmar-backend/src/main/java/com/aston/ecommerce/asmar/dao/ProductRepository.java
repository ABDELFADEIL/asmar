package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT(p) FROM Product p WHERE CONCAT(p.label,'', p.description) LIKE %:keyword%")
    List<Product> findProductsByLabelOrderByDescription(String keyword);
    @Query("SELECT p FROM Product p WHERE p.category.id =?1 ORDER BY p.label")
    List<Product> getProductsByCategoryId(Long categoryId);

 /*   List<Product> findByCategoryId(Long categoryId);*/
}

