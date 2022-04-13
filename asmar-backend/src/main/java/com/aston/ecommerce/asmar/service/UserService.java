package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserMobileDTO;
import com.aston.ecommerce.asmar.dto.UserUpdatePassword;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserForm userForm);
    UserDTO updatePassword(UserUpdatePassword userUpdatePassword) throws Exception;
    List<UserDTO> findAll();
    UserDTO getCurrentUser(String username);
    UserDTO addUser(UserMobileDTO userMobileDTO);
    UserDTO getUserById(Long userId);

    Long getUserId(String email);
}
