package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByLabelContainingOrDescriptionContainingOrderByDescription(@Param("label") String label, @Param("description") String description);
    List<Product> findAllByCategoryIdOrderByLabelAsc(Integer categoryId);



}

