package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where u.email= ?1 or u.username= ?1")
    public User findByEmailOrUserName(String email);

}