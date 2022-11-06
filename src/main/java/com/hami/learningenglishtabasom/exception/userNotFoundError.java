package com.hami.learningenglishtabasom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class userNotFoundError extends ResponseStatusException {
    public userNotFoundError() {
        super(HttpStatus.BAD_REQUEST, "user not found");
    }
}
