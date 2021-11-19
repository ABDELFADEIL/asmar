package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
