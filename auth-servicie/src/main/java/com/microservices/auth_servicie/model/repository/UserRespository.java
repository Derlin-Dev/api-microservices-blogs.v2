package com.microservices.auth_servicie.model.repository;

import com.microservices.auth_servicie.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);

}
