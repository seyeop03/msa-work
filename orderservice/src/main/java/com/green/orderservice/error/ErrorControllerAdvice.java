package com.green.orderservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<String> orderExceptionHandle(OrderException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class })
    public ResponseEntity<String> validationHandle(Exception e) {
        String[] defaultMessages = e.getMessage().split("default message");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(defaultMessages[2]);
    }
}