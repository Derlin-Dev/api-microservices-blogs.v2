package com.microservices.comments_services.data.repository;

import com.microservices.comments_services.data.model.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRespository extends JpaRepository<AnswersEntity, Long> {
}
