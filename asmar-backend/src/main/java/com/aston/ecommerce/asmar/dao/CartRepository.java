package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Cart;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
