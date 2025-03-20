package com.microservices.auth_servicie.model.dto;

public class UserRequest {

    private String userName;
    private String password;
    private String email;
    private String rol;

    public UserRequest(String userName, String password, String email, String rol) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
}
