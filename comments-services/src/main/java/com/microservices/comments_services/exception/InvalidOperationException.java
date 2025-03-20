package com.microservices.comments_services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidOperationException extends Exception{

    public InvalidOperationException(String message) {
        super(message);
    }
}
