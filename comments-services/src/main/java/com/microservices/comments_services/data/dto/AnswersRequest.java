package com.microservices.comments_services.data.dto;

import java.time.LocalDateTime;

public class AnswersRequest {

    private Long idUserComment;
    private Long idUserAnswers;
    private String answers;
    private LocalDateTime localDateTime;
    private Long commentId;

    public AnswersRequest(Long idUserComment, Long idUserAnswers, String answers, LocalDateTime localDateTime, Long commentId) {
        this.idUserComment = idUserComment;
        this.idUserAnswers = idUserAnswers;
        this.answers = answers;
        this.localDateTime = localDateTime;
        this.commentId = commentId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Long getIdUserComment() {
        return idUserComment;
    }

    public void setIdUserComment(Long idUserComment) {
        this.idUserComment = idUserComment;
    }

    public Long getIdUserAnswers() {
        return idUserAnswers;
    }

    public void setIdUserAnswers(Long idUserAnswers) {
        this.idUserAnswers = idUserAnswers;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
