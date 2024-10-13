package com.example.springsecurityinmemorytest.exception;

public class GlobalException extends RuntimeException {

    public GlobalException(String message) {
        super(message);
    }
    
    public static GlobalException of(String messgae) {
        return new GlobalException(messgae);
    }
}
