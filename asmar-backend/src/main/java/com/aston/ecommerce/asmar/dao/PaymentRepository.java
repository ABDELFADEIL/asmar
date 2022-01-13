package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Payment;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
