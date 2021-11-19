package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
