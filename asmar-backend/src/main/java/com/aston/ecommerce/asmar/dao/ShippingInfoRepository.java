package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Integer> {
}
