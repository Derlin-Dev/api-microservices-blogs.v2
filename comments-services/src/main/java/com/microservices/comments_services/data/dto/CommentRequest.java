package com.microservices.comments_services.data.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CommentRequest {

    private Long userId;
    private Long postId;
    private String comment;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeModficacion;

    public CommentRequest(Long userId, Long postId, String comment, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModficacion) {
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModficacion = fechaDeModficacion;
    }

    public CommentRequest() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDateTime getFechaDeModficacion() {
        return fechaDeModficacion;
    }

    public void setFechaDeModficacion(LocalDateTime fechaDeModficacion) {
        this.fechaDeModficacion = fechaDeModficacion;
    }
}
