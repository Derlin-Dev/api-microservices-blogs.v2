package com.microservices.auth_servicie.services;

import com.microservices.auth_servicie.config.JwtUtil;
import com.microservices.auth_servicie.model.dto.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServices {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    public JwtServices(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public String createJwtToken(AuthenticationRequest authenticationRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
           authenticationRequest.getUserName(), authenticationRequest.getPassword()
        ));

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        return jwtUtil.generateToken(userDetails);
    }

}
