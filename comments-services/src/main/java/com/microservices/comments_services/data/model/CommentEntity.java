package com.microservices.comments_services.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;
    private String comment;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeModficacion;

    @OneToMany(mappedBy = "comment",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonManagedReference
    private List<AnswersEntity> answers = new ArrayList<>();

    public CommentEntity(Long userId, Long postId, String comment, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModficacion) {
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModficacion = fechaDeModficacion;
    }

    public CommentEntity(Long id, Long userId, Long postId, String comment, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModficacion) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModficacion = fechaDeModficacion;
    }

    public CommentEntity() {

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

    public List<AnswersEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersEntity> answers) {
        this.answers = answers;
    }

}
