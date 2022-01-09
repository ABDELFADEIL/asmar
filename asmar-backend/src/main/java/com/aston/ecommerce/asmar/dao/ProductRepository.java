package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT(p) FROM Product p WHERE CONCAT(p.label,'', p.description) LIKE %:keyword%")
    List<Product> findProductsByLabelOrderByDescription(String keyword);


    @Query("SELECT p from Product p WHERE p.subCategory.id = ?1")
    List<Product> getProductBySubCategory(Integer sub_category_id);

}