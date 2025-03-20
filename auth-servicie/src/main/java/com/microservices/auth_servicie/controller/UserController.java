package com.microservices.auth_servicie.controller;

import com.microservices.auth_servicie.model.dto.AuthenticationRequest;
import com.microservices.auth_servicie.model.dto.AuthenticationResponse;
import com.microservices.auth_servicie.model.dto.UserRequest;
import com.microservices.auth_servicie.model.entity.UserEntity;
import com.microservices.auth_servicie.services.JwtServices;
import com.microservices.auth_servicie.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final JwtServices jwtServices;
    private final UserServices userServices;

    public UserController(JwtServices jwtServices, UserServices userServices) {
        this.jwtServices = jwtServices;
        this.userServices = userServices;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request){
        final String jwtToken = jwtServices.createJwtToken(request);
        UserEntity user = userServices.findByUser(request.getUserName());
        AuthenticationResponse response = new AuthenticationResponse(user.getId(), user.getUserName(), jwtToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registreUser(@RequestBody UserRequest request){
            userServices.save(request);
            return ResponseEntity.ok("Usuario registrado correctamente...!");
    }

}

