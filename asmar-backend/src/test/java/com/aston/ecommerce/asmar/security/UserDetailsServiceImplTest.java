package com.aston.ecommerce.asmar.security;

import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setRoleName("Role Name");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRoles()).thenReturn(roleList);
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setBirthDate((LocalDate) any());
        doNothing().when(user).setConnectionStatus(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRegistrationDate((LocalDateTime) any());
        doNothing().when(user).setRoles((List<Role>) any());
        doNothing().when(user).setTelephone(anyLong());
        doNothing().when(user).setUsername((String) any());
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
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertEquals(
                "org.springframework.security.core.userdetails.User [Username=jane.doe@example.org, Password=[PROTECTED],"
                        + " Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted"
                        + " Authorities=[Role Name]]",
                actualLoadUserByUsernameResult.toString());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmailOrUsername((String) any(), (String) any());
        verify(user).getEmail();
        verify(user).getPassword();
        verify(user).getRoles();
        verify(user).setId((Long) any());
        verify(user).setBirthDate((LocalDate) any());
        verify(user).setConnectionStatus(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRegistrationDate((LocalDateTime) any());
        verify(user).setRoles((List<Role>) any());
        verify(user).setTelephone(anyLong());
        verify(user).setUsername((String) any());
    }
}

