package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.PaymentDTO;
import com.aston.ecommerce.asmar.dto.RoleDTO;
import com.aston.ecommerce.asmar.entity.Payment;
import com.aston.ecommerce.asmar.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toRoleDto(Role role);
    List<RoleDTO> toRoleDtos(List<Role> roles);

    Role toRole(RoleDTO roleDTO);
    List<Role> toRoles(List<RoleDTO> roleDTOS);
}
