package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.CommandLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandLineRepository extends JpaRepository<CommandLine, Integer> {
    List<CommandLine> findAllByUserIdAndOrderIsNull(Integer userId);
    List<CommandLine> findByOrderId(Integer orderId);
    CommandLine findByProductIdAndOrderIsNull(Integer productId);
}
