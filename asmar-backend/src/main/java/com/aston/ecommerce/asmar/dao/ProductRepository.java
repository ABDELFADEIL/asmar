package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {






    Page<Product> findAllByDescriptionContainsOrderByLabel(String description, String label, Pageable pageable);
}
