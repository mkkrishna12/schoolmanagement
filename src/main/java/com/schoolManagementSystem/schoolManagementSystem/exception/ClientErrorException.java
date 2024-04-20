package com.schoolManagementSystem.schoolManagementSystem.exception;
import org.springframework.http.HttpStatus;

public class ClientErrorException extends RuntimeException{
    private final HttpStatus errorCode;

    public ClientErrorException( String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}


