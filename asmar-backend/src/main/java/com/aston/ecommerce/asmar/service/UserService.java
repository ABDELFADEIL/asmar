package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserUpdatePassword;

public interface UserService {

    UserDTO addUser(UserForm userForm);
    UserDTO updatePassword(UserUpdatePassword userUpdatePassword) throws Exception;

}
