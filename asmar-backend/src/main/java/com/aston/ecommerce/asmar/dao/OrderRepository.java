package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
