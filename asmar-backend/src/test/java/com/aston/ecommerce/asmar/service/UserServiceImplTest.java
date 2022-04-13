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
    void testAddUser() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    @Test
    void testAddUser2() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserForm userForm = mock(UserForm.class);
        when(userForm.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userForm.getPassword()).thenReturn("iloveyou");
        when(userForm.getRepassword()).thenReturn("iloveyou");
        doNothing().when(userForm).setActive(anyBoolean());
        doNothing().when(userForm).setAddInfos((String) any());
        doNothing().when(userForm).setBirthDate((String) any());
        doNothing().when(userForm).setCity((String) any());
        doNothing().when(userForm).setCountry((String) any());
        doNothing().when(userForm).setEmail((String) any());
        doNothing().when(userForm).setFirstName((String) any());
        doNothing().when(userForm).setLastName((String) any());
        doNothing().when(userForm).setPassword((String) any());
        doNothing().when(userForm).setPostalCode((String) any());
        doNothing().when(userForm).setRepassword((String) any());
        doNothing().when(userForm).setState((String) any());
        doNothing().when(userForm).setStreet((String) any());
        doNothing().when(userForm).setTelephone(anyInt());
        doNothing().when(userForm).setUsername((String) any());
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
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(userForm).getPassword();
        verify(userForm).getRepassword();
        verify(userForm).getUsername();
        verify(userForm).setActive(anyBoolean());
        verify(userForm).setAddInfos((String) any());
        verify(userForm).setBirthDate((String) any());
        verify(userForm).setCity((String) any());
        verify(userForm).setCountry((String) any());
        verify(userForm).setEmail((String) any());
        verify(userForm).setFirstName((String) any());
        verify(userForm).setLastName((String) any());
        verify(userForm).setPassword((String) any());
        verify(userForm).setPostalCode((String) any());
        verify(userForm).setRepassword((String) any());
        verify(userForm).setState((String) any());
        verify(userForm).setStreet((String) any());
        verify(userForm).setTelephone(anyInt());
        verify(userForm).setUsername((String) any());
    }

    @Test
    void testAddUser3() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserForm userForm = mock(UserForm.class);
        when(userForm.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userForm.getPassword()).thenReturn("foo");
        when(userForm.getRepassword()).thenReturn("iloveyou");
        doNothing().when(userForm).setActive(anyBoolean());
        doNothing().when(userForm).setAddInfos((String) any());
        doNothing().when(userForm).setBirthDate((String) any());
        doNothing().when(userForm).setCity((String) any());
        doNothing().when(userForm).setCountry((String) any());
        doNothing().when(userForm).setEmail((String) any());
        doNothing().when(userForm).setFirstName((String) any());
        doNothing().when(userForm).setLastName((String) any());
        doNothing().when(userForm).setPassword((String) any());
        doNothing().when(userForm).setPostalCode((String) any());
        doNothing().when(userForm).setRepassword((String) any());
        doNothing().when(userForm).setState((String) any());
        doNothing().when(userForm).setStreet((String) any());
        doNothing().when(userForm).setTelephone(anyInt());
        doNothing().when(userForm).setUsername((String) any());
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
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(userForm).getPassword();
        verify(userForm).getRepassword();
        verify(userForm).setActive(anyBoolean());
        verify(userForm).setAddInfos((String) any());
        verify(userForm).setBirthDate((String) any());
        verify(userForm).setCity((String) any());
        verify(userForm).setCountry((String) any());
        verify(userForm).setEmail((String) any());
        verify(userForm).setFirstName((String) any());
        verify(userForm).setLastName((String) any());
        verify(userForm).setPassword((String) any());
        verify(userForm).setPostalCode((String) any());
        verify(userForm).setRepassword((String) any());
        verify(userForm).setState((String) any());
        verify(userForm).setStreet((String) any());
        verify(userForm).setTelephone(anyInt());
        verify(userForm).setUsername((String) any());
    }

    @Test
    void testAddUser4() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);

        UserMobileDTO userMobileDTO = new UserMobileDTO();
        userMobileDTO.setBirthDate("2020-03-01");
        userMobileDTO.setConfirmPassword("iloveyou");
        userMobileDTO.setEmail("jane.doe@example.org");
        userMobileDTO.setFirstName("Jane");
        userMobileDTO.setLastName("Doe");
        userMobileDTO.setPassword("iloveyou");
        userMobileDTO.setTelephone(1L);
        userMobileDTO.setUsername("janedoe");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userMobileDTO));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    @Test
    void testAddUser5() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserMobileDTO userMobileDTO = mock(UserMobileDTO.class);
        when(userMobileDTO.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userMobileDTO.getConfirmPassword()).thenReturn("iloveyou");
        when(userMobileDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(userMobileDTO).setBirthDate((String) any());
        doNothing().when(userMobileDTO).setConfirmPassword((String) any());
        doNothing().when(userMobileDTO).setEmail((String) any());
        doNothing().when(userMobileDTO).setFirstName((String) any());
        doNothing().when(userMobileDTO).setLastName((String) any());
        doNothing().when(userMobileDTO).setPassword((String) any());
        doNothing().when(userMobileDTO).setTelephone(anyLong());
        doNothing().when(userMobileDTO).setUsername((String) any());
        userMobileDTO.setBirthDate("2020-03-01");
        userMobileDTO.setConfirmPassword("iloveyou");
        userMobileDTO.setEmail("jane.doe@example.org");
        userMobileDTO.setFirstName("Jane");
        userMobileDTO.setLastName("Doe");
        userMobileDTO.setPassword("iloveyou");
        userMobileDTO.setTelephone(1L);
        userMobileDTO.setUsername("janedoe");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userMobileDTO));
        verify(userMobileDTO).getConfirmPassword();
        verify(userMobileDTO).getPassword();
        verify(userMobileDTO).getUsername();
        verify(userMobileDTO).setBirthDate((String) any());
        verify(userMobileDTO).setConfirmPassword((String) any());
        verify(userMobileDTO).setEmail((String) any());
        verify(userMobileDTO).setFirstName((String) any());
        verify(userMobileDTO).setLastName((String) any());
        verify(userMobileDTO).setPassword((String) any());
        verify(userMobileDTO).setTelephone(anyLong());
        verify(userMobileDTO).setUsername((String) any());
    }

    @Test
    void testAddUser6() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserMobileDTO userMobileDTO = mock(UserMobileDTO.class);
        when(userMobileDTO.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userMobileDTO.getConfirmPassword()).thenReturn("foo");
        when(userMobileDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(userMobileDTO).setBirthDate((String) any());
        doNothing().when(userMobileDTO).setConfirmPassword((String) any());
        doNothing().when(userMobileDTO).setEmail((String) any());
        doNothing().when(userMobileDTO).setFirstName((String) any());
        doNothing().when(userMobileDTO).setLastName((String) any());
        doNothing().when(userMobileDTO).setPassword((String) any());
        doNothing().when(userMobileDTO).setTelephone(anyLong());
        doNothing().when(userMobileDTO).setUsername((String) any());
        userMobileDTO.setBirthDate("2020-03-01");
        userMobileDTO.setConfirmPassword("iloveyou");
        userMobileDTO.setEmail("jane.doe@example.org");
        userMobileDTO.setFirstName("Jane");
        userMobileDTO.setLastName("Doe");
        userMobileDTO.setPassword("iloveyou");
        userMobileDTO.setTelephone(1L);
        userMobileDTO.setUsername("janedoe");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userMobileDTO));
        verify(userMobileDTO).getConfirmPassword();
        verify(userMobileDTO).getPassword();
        verify(userMobileDTO).setBirthDate((String) any());
        verify(userMobileDTO).setConfirmPassword((String) any());
        verify(userMobileDTO).setEmail((String) any());
        verify(userMobileDTO).setFirstName((String) any());
        verify(userMobileDTO).setLastName((String) any());
        verify(userMobileDTO).setPassword((String) any());
        verify(userMobileDTO).setTelephone(anyLong());
        verify(userMobileDTO).setUsername((String) any());
    }

    @Test
    void testAddUser7() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    @Test
    void testAddUser8() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserForm userForm = mock(UserForm.class);
        when(userForm.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userForm.getPassword()).thenReturn("iloveyou");
        when(userForm.getRepassword()).thenReturn("iloveyou");
        doNothing().when(userForm).setActive(anyBoolean());
        doNothing().when(userForm).setAddInfos((String) any());
        doNothing().when(userForm).setBirthDate((String) any());
        doNothing().when(userForm).setCity((String) any());
        doNothing().when(userForm).setCountry((String) any());
        doNothing().when(userForm).setEmail((String) any());
        doNothing().when(userForm).setFirstName((String) any());
        doNothing().when(userForm).setLastName((String) any());
        doNothing().when(userForm).setPassword((String) any());
        doNothing().when(userForm).setPostalCode((String) any());
        doNothing().when(userForm).setRepassword((String) any());
        doNothing().when(userForm).setState((String) any());
        doNothing().when(userForm).setStreet((String) any());
        doNothing().when(userForm).setTelephone(anyInt());
        doNothing().when(userForm).setUsername((String) any());
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
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userForm));
        verify(userForm).getPassword();
        verify(userForm).getRepassword();
        verify(userForm).getUsername();
        verify(userForm).setActive(anyBoolean());
        verify(userForm).setAddInfos((String) any());
        verify(userForm).setBirthDate((String) any());
        verify(userForm).setCity((String) any());
        verify(userForm).setCountry((String) any());
        verify(userForm).setEmail((String) any());
        verify(userForm).setFirstName((String) any());
        verify(userForm).setLastName((String) any());
        verify(userForm).setPassword((String) any());
        verify(userForm).setPostalCode((String) any());
        verify(userForm).setRepassword((String) any());
        verify(userForm).setState((String) any());
        verify(userForm).setStreet((String) any());
        verify(userForm).setTelephone(anyInt());
        verify(userForm).setUsername((String) any());
    }



    @Test
    void testAddUser12() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setRoles(new ArrayList<>());
        user.setTelephone(1L);
        user.setUsername("janedoe");
        when(this.userRepository.findByEmailOrUsername((String) any(), (String) any())).thenReturn(user);
        UserMobileDTO userMobileDTO = mock(UserMobileDTO.class);
        when(userMobileDTO.getUsername()).thenThrow(new UserExpception("Not all who wander are lost"));
        when(userMobileDTO.getConfirmPassword()).thenReturn("foo");
        when(userMobileDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(userMobileDTO).setBirthDate((String) any());
        doNothing().when(userMobileDTO).setConfirmPassword((String) any());
        doNothing().when(userMobileDTO).setEmail((String) any());
        doNothing().when(userMobileDTO).setFirstName((String) any());
        doNothing().when(userMobileDTO).setLastName((String) any());
        doNothing().when(userMobileDTO).setPassword((String) any());
        doNothing().when(userMobileDTO).setTelephone(anyLong());
        doNothing().when(userMobileDTO).setUsername((String) any());
        userMobileDTO.setBirthDate("2020-03-01");
        userMobileDTO.setConfirmPassword("iloveyou");
        userMobileDTO.setEmail("jane.doe@example.org");
        userMobileDTO.setFirstName("Jane");
        userMobileDTO.setLastName("Doe");
        userMobileDTO.setPassword("iloveyou");
        userMobileDTO.setTelephone(1L);
        userMobileDTO.setUsername("janedoe");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.addUser(userMobileDTO));
        verify(userMobileDTO).getConfirmPassword();
        verify(userMobileDTO).getPassword();
        verify(userMobileDTO).setBirthDate((String) any());
        verify(userMobileDTO).setConfirmPassword((String) any());
        verify(userMobileDTO).setEmail((String) any());
        verify(userMobileDTO).setFirstName((String) any());
        verify(userMobileDTO).setLastName((String) any());
        verify(userMobileDTO).setPassword((String) any());
        verify(userMobileDTO).setTelephone(anyLong());
        verify(userMobileDTO).setUsername((String) any());
    }

    @Test
    void testUpdatePassword() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setRoles(new ArrayList<>());
        user1.setTelephone(1L);
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.getById((Long) any())).thenReturn(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setBirthDate(LocalDate.ofEpochDay(1L));
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setFirstName("Jane");
        userDTO.setId(123L);
        userDTO.setLastName("Doe");
        userDTO.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        userDTO.setRoles(new ArrayList<>());
        userDTO.setTelephone(1);
        userDTO.setUsername("janedoe");
        when(this.userMapper.toUserDto((User) any())).thenReturn(userDTO);

        UserUpdatePassword userUpdatePassword = new UserUpdatePassword();
        userUpdatePassword.setId(123L);
        userUpdatePassword.setPassword("iloveyou");
        assertSame(userDTO, this.userServiceImpl.updatePassword(userUpdatePassword));
        verify(this.userRepository).getById((Long) any());
        verify(this.userRepository).save((User) any());
        verify(this.userMapper).toUserDto((User) any());
        assertTrue(this.userServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdatePassword2() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setRoles(new ArrayList<>());
        user1.setTelephone(1L);
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.getById((Long) any())).thenReturn(user);
        when(this.userMapper.toUserDto((User) any())).thenThrow(new UserExpception("Not all who wander are lost"));

        UserUpdatePassword userUpdatePassword = new UserUpdatePassword();
        userUpdatePassword.setId(123L);
        userUpdatePassword.setPassword("iloveyou");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.updatePassword(userUpdatePassword));
        verify(this.userRepository).getById((Long) any());
        verify(this.userRepository).save((User) any());
        verify(this.userMapper).toUserDto((User) any());
    }

    @Test
    void testUpdatePassword3() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setRoles(new ArrayList<>());
        user1.setTelephone(1L);
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.getById((Long) any())).thenReturn(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setBirthDate(LocalDate.ofEpochDay(1L));
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setFirstName("Jane");
        userDTO.setId(123L);
        userDTO.setLastName("Doe");
        userDTO.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        userDTO.setRoles(new ArrayList<>());
        userDTO.setTelephone(1);
        userDTO.setUsername("janedoe");
        when(this.userMapper.toUserDto((User) any())).thenReturn(userDTO);

        UserUpdatePassword userUpdatePassword = new UserUpdatePassword();
        userUpdatePassword.setId(123L);
        userUpdatePassword.setPassword("iloveyou");
        assertSame(userDTO, this.userServiceImpl.updatePassword(userUpdatePassword));
        verify(this.userRepository).getById((Long) any());
        verify(this.userRepository).save((User) any());
        verify(this.userMapper).toUserDto((User) any());
        assertTrue(this.userServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdatePassword4() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRegistrationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setRoles(new ArrayList<>());
        user1.setTelephone(1L);
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.getById((Long) any())).thenReturn(user);
        when(this.userMapper.toUserDto((User) any())).thenThrow(new UserExpception("Not all who wander are lost"));

        UserUpdatePassword userUpdatePassword = new UserUpdatePassword();
        userUpdatePassword.setId(123L);
        userUpdatePassword.setPassword("iloveyou");
        assertThrows(UserExpception.class, () -> this.userServiceImpl.updatePassword(userUpdatePassword));
        verify(this.userRepository).getById((Long) any());
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
    void testFindAll3() {
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
    void testFindAll4() {
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
        user.setId(123L);
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
        userDTO.setId(123L);
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
        user.setId(123L);
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

    @Test
    void testGetCurrentUser3() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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
        userDTO.setId(123L);
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
    void testGetCurrentUser4() {
        User user = new User();
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setConnectionStatus(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
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

