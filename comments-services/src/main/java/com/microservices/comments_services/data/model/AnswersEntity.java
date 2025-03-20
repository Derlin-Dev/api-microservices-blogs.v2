package com.microservices.comments_services.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class AnswersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idUserComment;
    private Long idUserAnswers;
    private String answers;
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    @JsonBackReference
    private CommentEntity comment;

    public AnswersEntity(){}

    public AnswersEntity(Long idUserComment, Long idUserAnswers, String answers, LocalDateTime localDateTime) {
        this.idUserComment = idUserComment;
        this.idUserAnswers = idUserAnswers;
        this.answers = answers;
        this.localDateTime = localDateTime;
    }

    public void setIdUserAnswers(Long idUserAnswers) {
        this.idUserAnswers = idUserAnswers;
    }

    public Long getIdUserAnswers() {
        return idUserAnswers;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserComment() {
        return idUserComment;
    }

    public void setIdUserComment(Long idUserComment) {
        this.idUserComment = idUserComment;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }
}
