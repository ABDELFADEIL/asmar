package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String user);
}
