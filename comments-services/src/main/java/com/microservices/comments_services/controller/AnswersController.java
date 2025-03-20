package com.microservices.comments_services.controller;

import com.microservices.comments_services.data.dto.AnswersRequest;
import com.microservices.comments_services.exception.InvalidOperationException;
import com.microservices.comments_services.service.AnswersServices;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
@RefreshScope
public class AnswersController {

    private final AnswersServices services;

    public AnswersController(AnswersServices services) {
        this.services = services;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createNewAnswers(@RequestBody AnswersRequest request) throws InvalidOperationException {
        String newAnswers = services.newAnswers(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAnswers);
    }
}
