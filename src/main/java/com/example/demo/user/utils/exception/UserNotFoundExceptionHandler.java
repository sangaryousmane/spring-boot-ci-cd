package com.example.demo.user.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> userHandlerException(ResourceNotFoundException e) {
        UserException userExcept = new UserException(
                e.getMessage(),
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userExcept, HttpStatus.NOT_FOUND);
    }
}
