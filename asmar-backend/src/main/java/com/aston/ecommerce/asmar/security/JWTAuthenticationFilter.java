package com.aston.ecommerce.asmar.security;
import com.aston.ecommerce.asmar.security.config.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        com.aston.ecommerce.asmar.entity.User user = null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), com.aston.ecommerce.asmar.entity.User.class);
            System.out.println("User app "+ user.getEmail() + " "+ user.getPassword());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email " + user.getEmail());
        System.out.println("password " + user.getPassword());

        if (user.getUserName() != null || !user.getUserName().equals("")){
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        }
        else {
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        }

        //return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User springuser = (User) authResult.getPrincipal();
        String jwtToken = Jwts.builder().
                setSubject(springuser.getUsername()).
                setExpiration(new Date(System.currentTimeMillis()+ SecurityConstants.EXPIRATION_TIME)).
                signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).
                claim("roles", springuser.getAuthorities()).compact();
        System.out.println("token builder "+jwtToken);
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);
    }
}
