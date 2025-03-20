package com.microservices.comments_services.data.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CommentResponse {

    private Long id;
    private Long userId;
    private Long postId;
    private String comment;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeModficacion;

    public CommentResponse(LocalDateTime fechaDeModficacion, LocalDateTime fechaDeCreacion, String comment, Long postId, Long userId, Long id) {
        this.fechaDeModficacion = fechaDeModficacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.comment = comment;
        this.postId = postId;
        this.userId = userId;
        this.id = id;
    }

    public CommentResponse(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
