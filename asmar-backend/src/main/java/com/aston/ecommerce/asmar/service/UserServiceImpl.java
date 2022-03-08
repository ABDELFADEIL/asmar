package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.RoleRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.*;
import com.aston.ecommerce.asmar.dto.mapper.AddressMapper;
import com.aston.ecommerce.asmar.dto.mapper.UserMapper;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.exption.UserExpception;
import com.aston.ecommerce.asmar.utils.SendingMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SendingMailService mailService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressService addressService;

    @Override
    public UserDTO addUser(UserForm userForm) {
        String password=userForm.getPassword();
        String repassword=userForm.getRepassword();
        if(!(repassword.equals(password))) throw new UserExpception(repassword+ " Mot de passe n'est pas confirmé");
        String username = userForm.getUsername();
        User user= userRepository.findByEmailOrUserName(username);
        if(user !=null) throw new UserExpception(userForm.getUsername() +" existe déjà");

        user = userMapper.toUser(userForm);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        try {
            Role role =roleRepository.findByRoleName("CUSTOMER");
            user = userRepository.save(user);
            user.getRoles().add(role);
            user = userRepository.save(user);
            AddressDTO addressDTO = addressMapper.toAddressDto(userForm);
            UserDTO userDTO = userMapper.toUserDto(user);
            userDTO.setId(user.getId());
            addressDTO.setUser(userDTO);
            addressService.addAddress(addressDTO);
        } catch (Exception e) {
            throw new UserExpception("error de sevgarde " + e);
        }
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDTO updatePassword(UserUpdatePassword userUpdatePassword) throws Exception{
        User user = userRepository.getById(userUpdatePassword.getId());
        if (user == null){
            throw new UserExpception("Utilisateur n'existe pas");
        }
        String password = bCryptPasswordEncoder.encode(userUpdatePassword.getPassword());
        user.setPassword(password);
        user = userRepository.save(user);
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserDtos(users);
    }

    @Override
    public UserDTO getCurrentUser(String username) {
        return userMapper.toUserDto(userRepository.findByEmailOrUserName(username));
    }

    @Override
    public UserDTO addUser(UserMobileDTO userMobileDTO) {
        String password=userMobileDTO.getPassword();
        String repassword=userMobileDTO.getConfirmPassword();
        if(!(repassword.equals(password))) throw new UserExpception(repassword+ " Mot de passe n'est pas confirmé");
        String username = userMobileDTO.getUsername();
        User user= userRepository.findByEmailOrUserName(username);
        if(user !=null) throw new UserExpception(userMobileDTO.getUsername() +" existe déjà");

        user = userMapper.toUser(userMobileDTO);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        try {
            Role role =roleRepository.findByRoleName("CUSTOMER");
            user.getRoles().add(role);
            user = userRepository.save(user);
        } catch (Exception e) {
            throw new UserExpception("error de sevgarde " + e);
        }
        return userMapper.toUserDto(user);
    }
}