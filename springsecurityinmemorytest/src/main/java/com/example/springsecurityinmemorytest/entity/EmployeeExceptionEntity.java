package com.example.springsecurityinmemorytest.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeExceptionEntity {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
