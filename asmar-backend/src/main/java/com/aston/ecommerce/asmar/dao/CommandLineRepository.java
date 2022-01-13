package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.CommandLine;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandLineRepository extends JpaRepository<CommandLine, Long> {
}
