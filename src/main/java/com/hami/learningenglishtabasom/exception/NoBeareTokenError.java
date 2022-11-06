package com.hami.learningenglishtabasom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoBeareTokenError extends ResponseStatusException {

    public NoBeareTokenError() {
        super(HttpStatus.BAD_REQUEST, "No bearer token");
    }
}
