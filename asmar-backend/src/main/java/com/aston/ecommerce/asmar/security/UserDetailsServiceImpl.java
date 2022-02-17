package com.aston.ecommerce.asmar.security;
import com.aston.ecommerce.asmar.dao.UserRepository;
import com.aston.ecommerce.asmar.entity.Role;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u =null;
        u=userRepository.findByEmailOrUserName(username);
        if(u==null) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        u.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), authorities);
    }

}