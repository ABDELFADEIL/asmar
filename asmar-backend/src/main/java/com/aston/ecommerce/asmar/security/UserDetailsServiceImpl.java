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
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u =null;
        System.out.println("email: "+s);
        //u=userRepository.findByEmailOrUID(email);
        u=userRepository.findByEmailOrUserName(s);
        System.out.println("email: "+u.getEmail()+ " password: "+u.getPassword());
        if(u==null) throw new UsernameNotFoundException(s+ "est null .....");
        final User user = u;
          Collection<Role> roles = new ArrayList<>();
        roles.addAll(user.getRoles());
        Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        roles.forEach(r->
        { authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        System.out.println("email: "+user.getEmail()+ " password: "+user.getPassword());
        System.out.println("succès ....//////");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}