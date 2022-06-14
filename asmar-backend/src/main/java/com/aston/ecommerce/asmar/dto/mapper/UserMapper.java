package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserMobileDTO;
import com.aston.ecommerce.asmar.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = { RoleMapper.class})
public interface UserMapper {

    @InheritInverseConfiguration
    UserDTO toUserDto(User user);
    List<UserDTO> toUserDtos(List<User> users);

    User toUser(UserDTO userDTO);
    List<User> toUsers(List<UserDTO> userDTOS);
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
    @InheritInverseConfiguration
    User toUser(UserForm userForm);
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
    @InheritInverseConfiguration
    User toUser(UserMobileDTO userMobileDTO);
}
