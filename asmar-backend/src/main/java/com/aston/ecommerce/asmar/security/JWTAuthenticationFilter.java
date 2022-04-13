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
        String username = "";
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), com.aston.ecommerce.asmar.entity.User.class);
            System.out.println("User app "+ user.getEmail() + " "+ user.getPassword());
            if (user.getEmail() == null){
                username = user.getUsername();
            }else {
                username = user.getEmail();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email " + username);
        System.out.println("password " + user.getPassword());

        /*if (user.getUsername() != null || !Objects.equals(user.getUsername(), "")){
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        }
        else {
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        }*/

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User userSpring = (User) authResult.getPrincipal();
        String jwtToken = Jwts.builder().
                setSubject(userSpring.getUsername()).
                setId("").
                setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME)).
                signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).
                claim("roles", userSpring.getAuthorities()).
                compact();
        System.out.println("token builder "+jwtToken);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

       /*response.getWriter().write(
                "{\"" + SecurityConstants.HEADER_STRING + "\":\"" + SecurityConstants.TOKEN_PREFIX+jwtToken + "\"}"
        );*/
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);}
}
