package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandLineRepository extends JpaRepository<CommandLine, Long> {
    @Query("select c from CommandLine c where c.user.id=:userId and c.order.id is null ")
    List<CommandLine> findByUserAndOrderIsNull(Long userId);
    List<CommandLine> findByOrder(Long orderId);
}
