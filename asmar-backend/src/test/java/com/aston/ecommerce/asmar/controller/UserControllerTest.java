package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dto.UserDTO;
import com.aston.ecommerce.asmar.dto.UserForm;
import com.aston.ecommerce.asmar.dto.UserMobileDTO;
import com.aston.ecommerce.asmar.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Test
    void testAddUser() throws Exception {
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
        when(this.userService.addUser((UserForm) any())).thenReturn(userDTO);

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
        String content = (new ObjectMapper()).writeValueAsString(userForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\","
                                        + "\"birthDate\":[1970,1,2],\"telephone\":1,\"registrationDate\":[1,1,1,1,1],\"roles\":[]}"));
    }

    @Test
    void testAddUserMobile() throws Exception {
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
        when(this.userService.addUser((UserMobileDTO) any())).thenReturn(userDTO);

        UserMobileDTO userMobileDTO = new UserMobileDTO();
        userMobileDTO.setBirthDate("2020-03-01");
        userMobileDTO.setConfirmPassword("iloveyou");
        userMobileDTO.setEmail("jane.doe@example.org");
        userMobileDTO.setFirstName("Jane");
        userMobileDTO.setLastName("Doe");
        userMobileDTO.setPassword("iloveyou");
        userMobileDTO.setTelephone(1L);
        userMobileDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userMobileDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\","
                                        + "\"birthDate\":[1970,1,2],\"telephone\":1,\"registrationDate\":[1,1,1,1,1],\"roles\":[]}"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(this.userService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/all");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllUsers2() throws Exception {
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

        ArrayList<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(userDTO);
        when(this.userService.findAll()).thenReturn(userDTOList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/all");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\","
                                        + "\"birthDate\":[1970,1,2],\"telephone\":1,\"registrationDate\":[1,1,1,1,1],\"roles\":[]}]"));
    }

    @Test
    void testGetAllUsers3() throws Exception {
        when(this.userService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/users/all");
        getResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController).build().perform(getResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetCurrentUser() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

