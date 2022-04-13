package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.CommandLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLine, Long> {

    List<CommandLine> findAllByUserIdAndOrderIsNull(Long userId);
    List<CommandLine> findByOrderId(Long orderId);
    CommandLine findByProductIdAndOrderIsNull(Long productId);
}
