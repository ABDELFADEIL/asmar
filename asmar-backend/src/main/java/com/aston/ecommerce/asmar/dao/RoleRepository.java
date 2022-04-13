package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String user);
}
