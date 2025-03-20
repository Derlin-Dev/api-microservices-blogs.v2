package com.microservices.auth_servicie.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;
    @ElementCollection(fetch = FetchType.EAGER) // Permite almacenar listas de valores simples
    private List<String> roles; // Almacena los roles como una lista de strings

    public UserEntity(String userName, String password, String email, List<String> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserEntity(Long id, String userName, String password, String email, List<String> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
