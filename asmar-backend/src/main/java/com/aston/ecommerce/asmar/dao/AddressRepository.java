package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Address;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.id=:id") // hql
    Address getAddress(Integer id);

    List<Address> findAddressesByUserId(Long userId);
}
