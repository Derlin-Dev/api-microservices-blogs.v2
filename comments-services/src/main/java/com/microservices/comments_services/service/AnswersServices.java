package com.microservices.comments_services.service;

import com.microservices.comments_services.data.dto.AnswersRequest;
import com.microservices.comments_services.data.model.AnswersEntity;
import com.microservices.comments_services.data.model.CommentEntity;
import com.microservices.comments_services.data.repository.AnswersRespository;
import com.microservices.comments_services.data.repository.CommentRepositori;
import com.microservices.comments_services.exception.InvalidOperationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswersServices {

    private final AnswersRespository answersRespository;
    private final CommentRepositori commentRepositori;

    public AnswersServices(AnswersRespository respository, CommentRepositori commentRepositori) {
        this.answersRespository = respository;
        this.commentRepositori = commentRepositori;
    }

    public String newAnswers(AnswersRequest request) throws InvalidOperationException {

        if (request == null){ throw new InvalidOperationException(""); }

        CommentEntity comment = commentRepositori.findById(request.getCommentId())
                        .orElseThrow(() -> new InvalidOperationException("Comentario no encontrado"));

        request.setLocalDateTime(LocalDateTime.now());

        AnswersEntity answers = new AnswersEntity(
           request.getIdUserComment(),
           request.getIdUserAnswers(),
           request.getAnswers(),
           request.getLocalDateTime()
        );

        answers.setComment(comment);

        answersRespository.save(answers);

        return "Respuesta enviada corretamente...!";
    }
}
