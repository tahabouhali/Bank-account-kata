package com.example.katabank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NegativeAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNegativeAmountException(NegativeAmountException ex) {
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInsufficientFundsException(InsufficientFundsException ex) {
        return "Error: " + ex.getMessage();
    }
}
