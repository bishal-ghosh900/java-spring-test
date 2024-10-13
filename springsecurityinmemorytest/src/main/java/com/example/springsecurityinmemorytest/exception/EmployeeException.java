package com.example.springsecurityinmemorytest.exception;

public class EmployeeException extends RuntimeException {
    
    public EmployeeException(String message) {
        super(message);
    }

    public static EmployeeException of(String message) {
        return new EmployeeException(message);
    }

}
