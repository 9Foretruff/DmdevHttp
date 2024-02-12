package com.foretruff.http.exception;

import com.foretruff.http.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException{
    @Getter
    private final List<Error>errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
