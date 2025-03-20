package com.microservices.post_services.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessege {

    private HttpStatus httpStatus;
    private String messege;

    public ErrorMessege(String messege, HttpStatus httpStatus) {
        this.messege = messege;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
