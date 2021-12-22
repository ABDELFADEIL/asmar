package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select a from Address a where a.id=:id") // hql
    Address getAddress(Integer id);
}
