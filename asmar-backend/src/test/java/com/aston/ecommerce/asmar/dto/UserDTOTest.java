package com.aston.ecommerce.asmar.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserDTOTest {
    @Test
    void testConstructor() {
        UserDTO actualUserDTO = new UserDTO();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualUserDTO.setBirthDate(ofEpochDayResult);
        actualUserDTO.setEmail("jane.doe@example.org");
        actualUserDTO.setFirstName("Jane");
        actualUserDTO.setId(123L);
        actualUserDTO.setLastName("Doe");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUserDTO.setRegistrationDate(ofResult);
        ArrayList<RoleDTO> roleDTOList = new ArrayList<>();
        actualUserDTO.setRoles(roleDTOList);
        actualUserDTO.setTelephone(1);
        actualUserDTO.setUsername("janedoe");
        assertSame(ofEpochDayResult, actualUserDTO.getBirthDate());
        assertEquals("jane.doe@example.org", actualUserDTO.getEmail());
        assertEquals("Jane", actualUserDTO.getFirstName());
        assertEquals(123L, actualUserDTO.getId().longValue());
        assertEquals("Doe", actualUserDTO.getLastName());
        assertSame(ofResult, actualUserDTO.getRegistrationDate());
        assertSame(roleDTOList, actualUserDTO.getRoles());
        assertEquals(1, actualUserDTO.getTelephone());
        assertEquals("janedoe", actualUserDTO.getUsername());
        assertEquals(
                "UserDTO{id=123, firstName='Jane', lastName='Doe', email='jane.doe@example.org', telephone='1',"
                        + " userName='janedoe', birthDate=1970-01-02, registrationDate=0001-01-01T01:01, roles=[]}",
                actualUserDTO.toString());
    }
}

