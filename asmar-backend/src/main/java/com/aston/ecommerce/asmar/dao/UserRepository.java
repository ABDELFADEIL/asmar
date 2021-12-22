package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String s);
}
