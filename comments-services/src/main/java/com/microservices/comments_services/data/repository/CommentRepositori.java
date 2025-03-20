package com.microservices.comments_services.data.repository;

import com.microservices.comments_services.data.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositori extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByUserId(Long UserID);
    List<CommentEntity> findByPostId(Long PostId);
    int countByPostId(Long PostId);
}
