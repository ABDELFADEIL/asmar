package com.aston.ecommerce.asmar.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualUser.setBirthDate(ofEpochDayResult);
        actualUser.setConnectionStatus(true);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setRegistrationDate(ofResult);
        ArrayList<Role> roleList = new ArrayList<>();
        actualUser.setRoles(roleList);
        actualUser.setTelephone(1L);
        actualUser.setUsername("janedoe");
        assertSame(ofEpochDayResult, actualUser.getBirthDate());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(ofResult, actualUser.getRegistrationDate());
        assertSame(roleList, actualUser.getRoles());
        assertEquals(1L, actualUser.getTelephone());
        assertEquals("janedoe", actualUser.getUsername());
        assertTrue(actualUser.isConnectionStatus());
        assertEquals(
                "User{firstName='Jane', lastName='Doe', email='jane.doe@example.org', password='iloveyou', username='janedoe',"
                        + " birthDate=1970-01-02, registrationDate=0001-01-01T01:01, connectionStatus=true, telephone=1,"
                        + " roles=[]}",
                actualUser.toString());
    }

    @Test
    void testConstructor2() {
        assertTrue((new User()).getRoles().isEmpty());
    }
}

