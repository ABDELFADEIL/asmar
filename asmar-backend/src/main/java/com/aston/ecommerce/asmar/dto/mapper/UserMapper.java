package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.RoleDTO;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDto(User user);
    List<UserDTO> toUserDtos(List<User> users);

    User toUser(UserDTO userDTO);
    List<User> toUsers(List<UserDTO> userDTOS);
}
