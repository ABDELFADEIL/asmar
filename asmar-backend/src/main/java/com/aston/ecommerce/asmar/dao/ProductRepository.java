package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByLabelContainingOrDescriptionContainingOrderByDescription(String label, String desc);
    List<Product> findAllByCategoryIdOrderByLabelAsc(Long categoryId);



}

