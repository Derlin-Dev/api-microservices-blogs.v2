package com.microservices.auth_servicie.model.dto;

public class AuthenticationResponse {

    private final Long id;
    private final String userNamer;
    private final String jwt;

    public AuthenticationResponse(Long id, String userNamer, String jwt) {
        this.id = id;
        this.userNamer = userNamer;
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getId() {
        return id;
    }

    public String getUserNamer() {
        return userNamer;
    }
}
