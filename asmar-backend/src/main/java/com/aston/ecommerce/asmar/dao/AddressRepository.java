package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
