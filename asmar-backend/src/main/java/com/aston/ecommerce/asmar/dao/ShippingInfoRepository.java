package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.ShippingInfo;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
}
