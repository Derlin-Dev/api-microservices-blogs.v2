package com.microservices.auth_servicie.services;

import com.microservices.auth_servicie.config.SecurityConfig;
import com.microservices.auth_servicie.model.dto.UserRequest;
import com.microservices.auth_servicie.model.entity.UserEntity;
import com.microservices.auth_servicie.model.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRespository userRespository;

    List<String> roles = new ArrayList<>();

    public UserServices(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserEntity save(UserRequest request) throws UsernameNotFoundException{

        if (findByUser(request.getUserName()) != null){
            throw new UsernameNotFoundException("Usuario ya registrado");
        }else {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            roles.add(request.getRol());
            UserEntity user = new UserEntity(
                    request.getUserName(),
                    request.getPassword(),
                    request.getEmail(),
                    roles
            );

            return userRespository.save(user);
        }
    }

    public UserEntity findByUser(String userNamer){
        return userRespository.findByUserName(userNamer);
    }

}
