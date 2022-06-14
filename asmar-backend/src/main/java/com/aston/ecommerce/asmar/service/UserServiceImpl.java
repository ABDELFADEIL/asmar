package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.RoleRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.*;
import com.aston.ecommerce.asmar.dto.mapper.AddressMapper;
import com.aston.ecommerce.asmar.dto.mapper.UserMapper;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.exption.UserExpception;
import com.aston.ecommerce.asmar.config.SendingMailService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SendingMailService mailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final AddressService addressService;
    public UserServiceImpl(
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           SendingMailService mailService,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           UserMapper userMapper,
                           AddressMapper addressMapper,
                           AddressService addressService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mailService = mailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.addressService = addressService;
    }
    @Override
    public UserDTO addUser(UserForm userForm) {
        String password=userForm.getPassword();
        String repassword=userForm.getRepassword();
        if(!(repassword.equals(password))) throw new UserExpception(repassword+ " Mot de passe n'est pas confirmé");
        String email = userForm.getEmail();
        if (Objects.equals(null, userForm.getEmail())) throw new UserExpception("L'email ou username est requis");
        User user= userRepository.findByEmailOrUsername(email, email);
        if(user !=null) throw new UserExpception(userForm.getEmail() +" existe déjà");

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
            addressDTO.setUserId(userDTO.getId());
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
        return userMapper.toUserDto(userRepository.findByEmailOrUsername(username, username));
    }

    @Override
    public UserDTO addUser(UserMobileDTO userMobileDTO) {
        String password=userMobileDTO.getPassword();
        String repassword=userMobileDTO.getConfirmPassword();
        if(!(repassword.equals(password))) throw new UserExpception(repassword+ " Mot de passe n'est pas confirmé");
        String username = userMobileDTO.getUsername();
        User user= userRepository.findByEmailOrUsername(username, username);
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

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = userRepository.getById(userId);
        return userMapper.toUserDto(user);
    }

    @Override
    public Integer getUserId(String email){
        User user = userRepository.findByEmailOrUsername(email, email);
        return user.getId();
    }
}