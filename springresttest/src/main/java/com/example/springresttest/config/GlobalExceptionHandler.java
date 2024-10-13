package com.example.springresttest.config;

import com.example.springresttest.exception.EmployeeNotFoundException;
import com.example.springresttest.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> employeeExceptionHandler(EmployeeNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage(exception.getMessage());
        exceptionResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setMessage(exception.getMessage());
        exceptionResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
