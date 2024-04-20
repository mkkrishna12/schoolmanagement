package com.schoolManagementSystem.schoolManagementSystem.exception;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

public class ServerErrorExceptionHandler extends RuntimeException{
    private final HttpStatus errorCode;
    public ServerErrorExceptionHandler(@Qualifier("sins") String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}