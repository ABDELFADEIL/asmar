package com.aston.ecommerce.asmar.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AddressDTOTest {
    @Test
    void testConstructor() {
        AddressDTO actualAddressDTO = new AddressDTO();
        actualAddressDTO.setActive(true);
        actualAddressDTO.setAddInfos("Add Infos");
        actualAddressDTO.setCity("Oxford");
        actualAddressDTO.setCountry("GB");
        actualAddressDTO.setId(123L);
        actualAddressDTO.setPostalCode("Postal Code");
        actualAddressDTO.setState("MD");
        actualAddressDTO.setStreet("Street");
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
        actualAddressDTO.setUserId(userDTO.getId());
        assertEquals("Add Infos", actualAddressDTO.getAddInfos());
        assertEquals("Oxford", actualAddressDTO.getCity());
        assertEquals("GB", actualAddressDTO.getCountry());
        assertEquals(123L, actualAddressDTO.getId().longValue());
        assertEquals("Postal Code", actualAddressDTO.getPostalCode());
        assertEquals("MD", actualAddressDTO.getState());
        assertEquals("Street", actualAddressDTO.getStreet());
        assertSame(userDTO.getId(), actualAddressDTO.getUserId());
        assertTrue(actualAddressDTO.isActive());
    }

    @Test
    void testConstructor2() {
        AddressDTO actualAddressDTO = new AddressDTO();
        actualAddressDTO.setActive(true);
        actualAddressDTO.setAddInfos("Add Infos");
        actualAddressDTO.setCity("Oxford");
        actualAddressDTO.setCountry("GB");
        actualAddressDTO.setId(123L);
        actualAddressDTO.setPostalCode("Postal Code");
        actualAddressDTO.setState("MD");
        actualAddressDTO.setStreet("Street");
        actualAddressDTO.setUserId(123L);
        assertEquals("Add Infos", actualAddressDTO.getAddInfos());
        assertEquals("Oxford", actualAddressDTO.getCity());
        assertEquals("GB", actualAddressDTO.getCountry());
        assertEquals(123L, actualAddressDTO.getId().longValue());
        assertEquals("Postal Code", actualAddressDTO.getPostalCode());
        assertEquals("MD", actualAddressDTO.getState());
        assertEquals("Street", actualAddressDTO.getStreet());
        assertEquals(123L, actualAddressDTO.getUserId());
        assertTrue(actualAddressDTO.isActive());
        assertEquals(
                "AddressDTO{id=123, fullName='null', street='Street', city='Oxford', state='MD', postalCode='Postal Code', country='GB',"
                        + " addInfos='Add Infos', active=true, userId=123}",
                actualAddressDTO.toString());
    }
}

