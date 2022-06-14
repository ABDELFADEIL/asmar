package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.config.SendingMailService;
import com.aston.ecommerce.asmar.dao.RoleRepository;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserMobileDTO;
import com.aston.ecommerce.asmar.dto.UserUpdatePassword;
import com.aston.ecommerce.asmar.dto.mapper.AddressMapper;
import com.aston.ecommerce.asmar.dto.mapper.UserMapper;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import com.aston.ecommerce.asmar.exption.UserExpception;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private AddressMapper addressMapper;
    @MockBean
    private AddressService addressService;
    @MockBean
    private RoleRepository roleRepository;
    @MockBean
    private SendingMailService sendingMailService;
    @MockBean
    private UserMapper userMapper;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;



    @Test
    void testAddUser1() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserForm userForm = new UserForm();
        userForm.setActive(true);
        userForm.setAddInfos("Add Infos");
        userForm.setBirthDate("2020-03-01");
        userForm.setCity("Oxford");
        userForm.setCountry("GB");
        userForm.setEmail("jane.doe@example.org");
        userForm.setFirstName("Jane");
        userForm.setLastName("Doe");
        userForm.setPassword("iloveyou");
        userForm.setPostalCode("Postal Code");
        userForm.setRepassword("iloveyou");
        userForm.setState("MD");
        userForm.setStreet("Street");
        userForm.setTelephone(1);
        userForm.setUsername("janedoe");
        User userMapped = new User();
        UserDTO userDTO = new UserDTO();
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    //@Test
    void testAddUser() {
        UserForm userForm = new UserForm();
        userForm.setActive(true);
        userForm.setAddInfos("Add Infos");
        userForm.setBirthDate("2020-03-01");
        userForm.setCity("Oxford");
        userForm.setCountry("GB");
        userForm.setEmail("jane.doe@example.org");
        userForm.setFirstName("Jane");
        userForm.setLastName("Doe");
        userForm.setPassword("iloveyou");
        userForm.setPostalCode("Postal Code");
        userForm.setRepassword("iloveyou");
        userForm.setState("MD");
        userForm.setStreet("Street");
        userForm.setTelephone(1);
        userForm.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(null);
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        User userMapped = new User();
        userMapped.setEmail(user.getEmail());
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        when(userMapper.toUser(userForm)).thenReturn(userMapped);
        Role role = new Role("CUSTOMER");
        when(roleRepository.findByRoleName("CUSTOMER")).thenReturn(role);
        when(userRepository.save(user)).thenReturn(user);
        user.setRoles(Arrays.asList(role));
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toUserDto(user)).thenReturn(userDTO);
        final UserDTO result = userServiceImpl.addUser(userForm);
        assertEquals(result, userDTO);
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    @Test
    void testUpdatePassword2() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setConnectionStatus(true);
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setRoles(new ArrayList<>());
        user1.setTelephone(1L);
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.getById((Integer) any())).thenReturn(user);
        when(this.userMapper.toUserDto((User) any())).thenThrow(new UserExpception("Not all who wander are lost"));

        UserUpdatePassword userUpdatePassword = new UserUpdatePassword();
        userUpdatePassword.setId(123);
        userUpdatePassword.setPassword("iloveyou");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.updatePassword(userUpdatePassword));
        verify(this.userRepository).getById((Integer) any());
        verify(this.userRepository).save((User) any());
        verify(this.userMapper).toUserDto((User) any());
    }


    @Test
    void testFindAll() {
        when(this.userRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<UserDTO> userDTOList = new ArrayList<>();
        when(this.userMapper.toUserDtos((List<User>) any())).thenReturn(userDTOList);
        List<UserDTO> actualFindAllResult = this.userServiceImpl.findAll();
        assertSame(userDTOList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.userRepository).findAll();
        verify(this.userMapper).toUserDtos((List<User>) any());
    }

    @Test
    void testFindAll2() {
        when(this.userRepository.findAll()).thenReturn(new ArrayList<>());
        when(this.userMapper.toUserDtos((List<User>) any())).thenThrow(new UserExpception("Not all who wander are lost"));
        assertThrows(UserExpception.class, () -> this.userServiceImpl.findAll());
        verify(this.userRepository).findAll();
        verify(this.userMapper).toUserDtos((List<User>) any());
    }


    @Test
    void testGetCurrentUser() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setBirthDate(LocalDate.ofEpochDay(1L));
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setFirstName("Jane");
        userDTO.setId(123);
        userDTO.setLastName("Doe");
        userDTO.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        userDTO.setRoles(new ArrayList<>());
        userDTO.setTelephone(1);
        userDTO.setUsername("janedoe");
        when(this.userMapper.toUserDto((User) any())).thenReturn(userDTO);
        assertSame(userDTO, this.userServiceImpl.getCurrentUser("janedoe"));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
        verify(this.userMapper).toUserDto((User) any());
        assertTrue(this.userServiceImpl.findAll().isEmpty());
    }

    @Test
    void testGetCurrentUser2() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        when(this.userMapper.toUserDto((User) any())).thenThrow(new UserExpception("Not all who wander are lost"));
        assertThrows(UserExpception.class, () -> this.userServiceImpl.getCurrentUser("janedoe"));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
        verify(this.userMapper).toUserDto((User) any());
    }

}

